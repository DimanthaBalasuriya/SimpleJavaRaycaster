import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {
    public int[] pixels;
    private String loc;
    public final int SIZE;

    public Texture(String location, int size) {
        loc = location;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(loc));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Environment textures
    public static Texture eagle = new Texture("res/eagle.png", 64);
    public static Texture redbrick = new Texture("res/redbrick.png", 64);
    public static Texture purplestone = new Texture("res/purplestone.png", 64);
    public static Texture greystone = new Texture("res/greystone.png", 64);
    public static Texture bluestone = new Texture("res/bluestone.png", 64);
    public static Texture mossy = new Texture("res/mossy.png", 64);
    public static Texture wood = new Texture("res/wood.png", 64);
    public static Texture colorstone = new Texture("res/colorstone.png", 64);

    //Sprite textures
    public static Texture barrel = new Texture("res/barrel.png", 64);
    public static Texture pillar = new Texture("res/pillar.png", 64);
    public static Texture greenlight = new Texture("res/greenlight.png", 64);
}