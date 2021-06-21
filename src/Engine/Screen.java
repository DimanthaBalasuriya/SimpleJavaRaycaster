package Engine;

import java.awt.*;
import java.util.ArrayList;

public class Screen {
    public int[][] map;
    public int mapWidth, mapHeight, width, height;
    public double xPos, yPos, xDir, yDir, xPlane, yPlane;
    public ArrayList<Texture> textures;

    public Sprite sprites[];
    public int spriteOrder[];
    public double spriteDistance[];
    public double zbuffer[];

    public Screen(int[][] m, int mapW, int mapH, ArrayList<Texture> tex, int w, int h, double x, double y, double xd, double yd, double xp, double yp, Sprite[] sprite) {
        map = m;
        mapWidth = mapW;
        mapHeight = mapH;
        textures = tex;
        width = w;
        height = h;
        xPos = x;
        yPos = y;
        xDir = xd;
        yDir = yd;
        xPlane = xp;
        yPlane = yp;
        sprites = sprite;
        spriteOrder = new int[19];
        spriteDistance = new double[19];
        zbuffer = new double[width];
    }

    public int[] update(Camera camera, int[] pixels) {
        for (int n = 0; n < pixels.length / 2; n++) {
            if (pixels[n] != Color.DARK_GRAY.getRGB()) pixels[n] = Color.DARK_GRAY.getRGB();
        }
        for (int i = pixels.length / 2; i < pixels.length; i++) {
            if (pixels[i] != Color.gray.getRGB()) pixels[i] = Color.gray.getRGB();
        }

        //Floor Casting
        for (int y = height / 2 + 1; y < height; ++y) {
            double rayDirX0 = xDir - xPlane;
            double rayDirY0 = yDir - yPlane;
            double rayDirX1 = xDir + xPlane;
            double rayDirY1 = yDir + yPlane;

            int p = y - height / 2;

            double posZ = .5 * height;

            double rowDistance = posZ / p;

            double floorStepX = rowDistance * (rayDirX1 - rayDirX0) / width;
            double floorStepY = rowDistance * (rayDirY1 - rayDirY0) / width;

            double floorX = xPos + rowDistance * rayDirX0;
            double floorY = yPos + rowDistance * rayDirY0;

            for (int x = 0; x < width; ++x) {

                int cellX = (int) (floorX);
                int cellY = (int) (floorY);

                int tx = (int) (64 * (floorX - cellX)) & (64 - 1);
                int ty = (int) (64 * (floorY - cellY)) & (64 - 1);

                floorX += floorStepX;
                floorY += floorStepY;

                int floorTexture = 3;
                int ceilingTexture = 6;

                int color = 0;
                color = textures.get(floorTexture).pixels[64 * ty + tx];
                pixels[x + y * width] = color;

                color = textures.get(ceilingTexture).pixels[64 * ty + tx];
                pixels[(x + width * (height - y - 1))] = color;//x * (height - y - 1)
            }

        }

        double perpWallDist = 0;

        //Wall casting
        for (int x = 0; x < width; x++) {
            double cameraX = 2 * x / (double) (width) - 1;
            double rayDirX = camera.xDir + camera.xPlane * cameraX;
            double rayDirY = camera.yDir + camera.yPlane * cameraX;
            int mapX = (int) camera.xPos;
            int mapY = (int) camera.yPos;
            double sideDistX;
            double sideDistY;
            double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
            double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));

            int stepX, stepY;
            boolean hit = false;
            int side = 0;
            if (rayDirX < 0) {
                stepX = -1;
                sideDistX = (camera.xPos - mapX) * deltaDistX;
            } else {
                stepX = 1;
                sideDistX = (mapX + 1.0 - camera.xPos) * deltaDistX;
            }
            if (rayDirY < 0) {
                stepY = -1;
                sideDistY = (camera.yPos - mapY) * deltaDistY;
            } else {
                stepY = 1;
                sideDistY = (mapY + 1.0 - camera.yPos) * deltaDistY;
            }
            while (!hit) {
                if (sideDistX < sideDistY) {
                    sideDistX += deltaDistX;
                    mapX += stepX;
                    side = 0;
                } else {
                    sideDistY += deltaDistY;
                    mapY += stepY;
                    side = 1;
                }
                if (map[mapX][mapY] > 0) hit = true;
            }
            if (side == 0)
                perpWallDist = Math.abs((mapX - camera.xPos + (1 - stepX) / 2) / rayDirX);
            else
                perpWallDist = Math.abs((mapY - camera.yPos + (1 - stepY) / 2) / rayDirY);
            int lineHeight;
            if (perpWallDist > 0) lineHeight = Math.abs((int) (height / perpWallDist));
            else lineHeight = height;
            int drawStart = -lineHeight / 2 + height / 2;
            if (drawStart < 0)
                drawStart = 0;
            int drawEnd = lineHeight / 2 + height / 2;
            if (drawEnd >= height)
                drawEnd = height - 1;
            int texNum = map[mapX][mapY] - 1;
            double wallX;
            if (side == 0) {
                wallX = (camera.yPos + perpWallDist * rayDirY);
            } else {
                wallX = camera.xPos + perpWallDist * rayDirX;
            }
            wallX -= Math.floor(wallX);
            int texX = (int) (wallX * (textures.get(texNum).SIZE));
            if (side == 0 && rayDirX > 0) texX = textures.get(texNum).SIZE - texX - 1;
            if (side == 1 && rayDirY < 0) texX = textures.get(texNum).SIZE - texX - 1;
            for (int y = drawStart; y < drawEnd; y++) {
                int texY = (((y * 2 - height + lineHeight) << 6) / lineHeight) / 2;
                int color;
                if (side == 0) color = textures.get(texNum).pixels[texX + (texY * textures.get(texNum).SIZE)];
                else
                    color = (textures.get(texNum).pixels[texX + (texY * textures.get(texNum).SIZE)]);
                pixels[x + y * (width)] = color;
            }
            zbuffer[x] = perpWallDist;
        }

        //Engine.Sprite casting
        for (int i = 0; i < sprites.length; i++) {
            spriteOrder[i] = i;
            spriteDistance[i] = ((xPos - sprites[i].x) * (xPos - sprites[i].x) + (yPos - sprites[i].y) * (yPos - sprites[i].y));
        }
        //sortSprites(spriteOrder, spriteDistance, sprites.length);

        for (int i = 0; i < sprites.length; i++) {
            double spriteX = sprites[spriteOrder[i]].x - xPos;
            double spriteY = sprites[spriteOrder[i]].y - yPos;

            double invDet = 1.0 / (xPlane * yDir - xDir * yPlane);

            double transformX = invDet * (yDir * spriteX - xDir * spriteY);
            double transformY = invDet * (-yPlane * spriteX + xPlane * spriteY);

            int spriteScreenX = (int) ((width / 2) * (1 + transformX / transformY));

            int spriteHeight = Math.abs((int) (height / transformY));

            int drawStartY = -spriteHeight / 2 + height / 2;
            if (drawStartY < 0) {
                drawStartY = 0;
            }
            int drawEndY = spriteHeight / 2 + height / 2;
            if (drawEndY >= height) {
                drawEndY = height - 1;
            }

            int spriteWidth = Math.abs((int) (height / (transformY)));
            int drawStartX = -spriteWidth / 2 + spriteScreenX;
            if (drawStartX < 0) {
                drawStartX = 0;
            }
            int drawEndX = spriteWidth / 2 + spriteScreenX;
            if (drawEndX >= width) {
                drawEndX = width - 1;
            }

            for (int stripe = drawStartX; stripe < drawEndX; stripe++) {
                int texX = (256 * (stripe - (-spriteWidth / 2 + spriteScreenX)) * 64 / spriteWidth) / 256;
                if (transformY > 0 && stripe > 0 && stripe < width && transformY < zbuffer[stripe]) {
                    for (int y = drawStartY; y < drawEndY; y++) {
                        int d = (y) * 256 - height * 128 + spriteHeight * 128;
                        int texY = ((d * 64) / spriteHeight) / 256;
                        int color = textures.get(sprites[spriteOrder[i]].texture).pixels[64 * texY + texX];
                        if ((color & 0x00FFFFFF) != 0) {//(x + width * (height - y - 1))
                            pixels[i + y * width + stripe] = color;

                            //i + y * (stripe)
                            //i + y * (stripe) - work with glitch
                            //i * y * width + stripe - correctly work but has some rendering glitch
                        }
                    }
                }
            }
        }
        return pixels;
    }


    private void sortSprites(int[] spriteOrder, double[] spriteDistance, int amount) {
        for (int i = 0; i < spriteDistance.length; i++) {
            System.out.print(spriteDistance[i] + ", ");
        }
        for (int i = 0; i < amount; i++) {
            sprites[i].y = spriteDistance[i];
            sprites[i].y = spriteOrder[i];
            System.out.println(spriteDistance[i] + ", " + spriteOrder[i]);
        }
        System.exit(0);
        for (int i = 0; i < amount; i++) {
            spriteDistance[i] = sprites[amount - i - 1].y;
            spriteOrder[i] = (int) sprites[amount - i - 1].y;
            // System.out.println(spriteDistance[i]);
        }

        for (int i = 0; i < spriteDistance.length; i++) {
            // System.out.print(spriteDistance[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < spriteOrder.length; i++) {
            //System.out.print(spriteOrder[i] + ", ");
        }
    }


}