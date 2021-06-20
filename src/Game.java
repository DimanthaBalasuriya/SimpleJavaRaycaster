import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

public class Game extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    public int mapWidth = 24;
    public int mapHeight = 24;
    private Thread thread;
    private boolean running;
    private BufferedImage image;
    public int[] pixels;
    public ArrayList<Texture> textures;
    public Camera camera;
    public Screen screen;
    public static int[][] map =
            {
                    {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 4, 4, 2, 4, 2, 4, 4, 4, 2, 4},
                    {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                    {4, 0, 3, 3, 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {4, 0, 3, 3, 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                    {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2, 4, 2},
                    {4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 0, 0, 0, 0, 0, 2},
                    {3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 4, 0, 4, 0, 4, 0, 4, 4, 0, 4, 0, 2, 0, 2},
                    {3, 3, 0, 0, 0, 0, 0, 0, 3, 4, 0, 4, 0, 4, 0, 4, 4, 2, 0, 0, 0, 0, 0, 2},
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0, 0, 0, 0, 4},
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 2, 0, 2, 0, 2},
                    {3, 3, 0, 0, 0, 0, 0, 0, 3, 4, 0, 4, 0, 4, 0, 4, 4, 2, 4, 2, 0, 2, 2, 2},
                    {3, 3, 3, 3, 0, 3, 3, 3, 3, 4, 4, 4, 0, 2, 4, 4, 4, 3, 3, 3, 0, 3, 3, 3},
                    {2, 2, 2, 2, 0, 2, 2, 2, 2, 4, 2, 4, 0, 0, 2, 0, 2, 3, 0, 0, 0, 0, 0, 3},
                    {2, 2, 0, 0, 0, 0, 0, 2, 2, 4, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 3},
                    {2, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 2, 0, 2, 3, 3, 0, 0, 0, 3, 3},
                    {2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 2, 2, 2, 2, 2, 0, 0, 4, 0, 4, 0, 4},
                    {2, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 2, 2, 0, 4, 0, 4, 0, 0, 0, 4, 4},
                    {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 4, 0, 4, 0, 4, 0, 4, 0, 4},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                    {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 4, 0, 4, 0, 4, 0, 4, 0, 4},
                    {2, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 2, 2, 0, 4, 0, 4, 0, 0, 0, 4, 4},
                    {2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4}
            };

    public ArrayList<Sprite> spriteList;

    public Game() {
        thread = new Thread(this);
        image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        System.out.println(pixels.length);
        textures = new ArrayList<Texture>();
        //Environment textures
        textures.add(Texture.wood);
        textures.add(Texture.brick);
        textures.add(Texture.bluestone);
        textures.add(Texture.stone);
        //Sprite textures
        textures.add(Texture.greenlight);
        textures.add(Texture.barrel);
        textures.add(Texture.pillar);

        //Sprite array
        spriteList = new ArrayList<>();
        //Lights
        spriteList.add(new Sprite(20.5, 11.5, 4));
        spriteList.add(new Sprite(18.5, 4.5, 4));
        spriteList.add(new Sprite(10.0, 4.5, 4));
        spriteList.add(new Sprite(10.0, 12.5, 4));
        spriteList.add(new Sprite(3.5, 6.5, 4));
        spriteList.add(new Sprite(3.5, 20.5, 4));
        spriteList.add(new Sprite(3.5, 14.5, 4));
        spriteList.add(new Sprite(14.5, 20.5, 4));

        //Pillers
        spriteList.add(new Sprite(18.5, 10.5, 6));
        spriteList.add(new Sprite(18.5, 11.5, 6));
        spriteList.add(new Sprite(18.5, 12.5, 6));

        //Barrels
        spriteList.add(new Sprite(21.5, 1.5, 5));
        spriteList.add(new Sprite(15.5, 1.5, 5));
        spriteList.add(new Sprite(16.0, 1.8, 5));
        spriteList.add(new Sprite(16.2, 1.2, 5));
        spriteList.add(new Sprite(3.5, 2.5, 5));
        spriteList.add(new Sprite(9.5, 15.5, 5));
        spriteList.add(new Sprite(10.0, 15.1, 5));
        spriteList.add(new Sprite(10.5, 15.8, 5));

        camera = new Camera(4.5, 4.5, 1, 0, 0, -.66);
        screen = new Screen(map, mapWidth, mapHeight, textures, 640, 480, 4.5, 4.5, 1, 0, 0, -.66, spriteList);
        addKeyListener(camera);
        setSize(640, 480);
        setResizable(false);
        setTitle("Diyamond War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }

    private synchronized void start() {
        running = true;
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        bs.show();
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        requestFocus();
        while (running) {
            long now = System.nanoTime();
            delta = delta + ((now - lastTime) / ns);
            lastTime = now;
            while (delta >= 1) {
                screen.update(camera, pixels);
                camera.update(map);
                delta--;
            }
            render();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}

