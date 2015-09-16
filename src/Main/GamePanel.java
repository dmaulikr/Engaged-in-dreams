// The GamePanel is the drawing canvas.
// It contains the game loop which
// keeps the game moving forward.
// This class is also the one that grabs key events.

        package Main;

import Mech.KeyHandler;
import Mech.MapEmulator;
import Objects.Camera;
import Objects.Entity;
import Objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

    // game loop stuff
    private Thread thread;
    private boolean running;
    private final int FPS = 120;
    private final int TARGET_TIME = 1000 / FPS;
    public long StepTime = 0;
    // drawing stuff
    private BufferedImage image;
    private Graphics g;
    private Camera cam = new Camera();
    public Entity[] ent = new Entity[2];
    public Player player;
    // constructor
    public GamePanel() {
        setPreferredSize(new Dimension(SIZE.WIDTH * SIZE.SCALE, SIZE.HEIGHT * SIZE.SCALE));
        setFocusable(true);
        requestFocus();
    }

    // ready to display
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }

    // run new thread
    public void run() {

        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while(running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000;
            if(wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }

    }

    // initializes fields
    private void init() {
        running = true;
        image = new BufferedImage(SIZE.WIDTH*SIZE.SCALE, SIZE.HEIGHT*SIZE.SCALE, 1);
        g = (Graphics) image.getGraphics();
         MapEmulator me = new MapEmulator("D:/DIGITANALOG/Games/GuruOfSurvival/src/Resources/Map/MAP0.map"); //WINDOWS
//       MapEmulator me = new MapEmulator("/home/embdev/Git/GuruOfSurvival/src/Resources/Map/MAP0.map"); //LINUX
        player = new Player(Camera.X0+Camera.X1/2,Camera.Y0+Camera.Y1/2);
    }

    // updates game
    private void update() {
        for (int i = 0; i < ent.length; i++) {
            if (ent[i] != null)
                ent[i].update();
        }
        if (KeyHandler.isPressed(KeyHandler.UP)) {
            player.moveTo(0,-1);
        }
        if (KeyHandler.isPressed(KeyHandler.LEFT)){
            player.moveTo(-1,0);
        }
        if(KeyHandler.isPressed(KeyHandler.DOWN)) {
            player.moveTo(0, 1);
        }
        if(KeyHandler.isPressed(KeyHandler.RIGHT)) {
            player.moveTo(1,0);
        }
        if(KeyHandler.isPressed(KeyHandler.PAGE_UP)) {
            if (SIZE.PPB<=90) {
                SIZE.PPB++;
                System.out.println(SIZE.PPB);
            }
        }
        if(KeyHandler.isPressed(KeyHandler.PAGE_DOWN)) {
            if (SIZE.PPB>=20) {
                SIZE.PPB--;
                System.out.println(SIZE.PPB);
            }
        }

        cam.update(player.X0C,player.Y0C);
        
    }

    // draws game
    private void draw() {
        g.setColor(Color.black);
        g.fillRect(0, 0, SIZE.WIDTH * SIZE.SCALE, SIZE.HEIGHT * SIZE.SCALE);
        ent[0]=player;
        cam.draw(g,ent,player);
    }

    // copy buffer to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, SIZE.WIDTH * SIZE.SCALE, SIZE.HEIGHT * SIZE.SCALE, null);
        g2.dispose();
    }

    // key event
    public void keyTyped(KeyEvent key) {}
    public void keyPressed(KeyEvent key) {
        KeyHandler.keySet(key.getKeyCode(), true);
    }
    public void keyReleased(KeyEvent key) {
        KeyHandler.keySet(key.getKeyCode(), false);
    }

}