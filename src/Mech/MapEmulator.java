
        package Mech;

        import Core.network.NetworkMap;
import Main.SIZE;
import Objects.Animation;
import Objects.Camera;
import Resources.Content;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by SeaDevil on 31.08.2015.
 */
public class MapEmulator {

    public int MAP_WEIGHT;
    public int PIX_WEIGHT;
    public int MAP_HEIGHT;
    public int PIX_HEIGHT;
    public static char[][] fullMap;
    private NetworkMap networkMap = new NetworkMap();
    public static boolean initialised = false;
    private static BufferedImage[][] mapTiles = Content.MAP;
    private static Animation animation = new Animation();

    public MapEmulator(String path) {
        try {
            fullMap = networkMap.createMap(path);
            initialised = true;
            System.out.println("Map loaded");
        } catch (IOException e) {
            e.printStackTrace();
            initialised = false;
        }
        animation.setFrames(Content.Water[0]);
        animation.setDelay(15);
    }

    public static char getNeuron(int PosX, int PosY) {
        char n;
        try {
            n = fullMap[PosX][PosY];
        }
        catch (Exception e) {
            n = 'E';             //will return 'E' - empty
        }
        return n;
    }


    private void PixToBlock(int curX, int curY) {
        MAP_WEIGHT = PIX_WEIGHT / SIZE.PPB + 1;
        MAP_HEIGHT = PIX_HEIGHT / SIZE.PPB + 1;
    }


    public static void update() {
        animation.update();
    }

    public static void draw(int curX, int curY, Graphics g) {
        update();
        BufferedImage BI = null;
        if (initialised) {
            g.setColor(Color.cyan);
            for (int i = 0; i < fullMap[0].length; i++) {
                for (int j = 0; j < fullMap.length; j++) {
                    if (Collision.isColised(j * SIZE.PPB-j*6, i * SIZE.PPB-i*6, SIZE.PPB, SIZE.PPB, Camera.X0, Camera.Y0, Camera.X1 - Camera.X0, Camera.Y1 - Camera.Y0)) {

                        if(fullMap[j][i]=='1')
                            BI = animation.getImage();
                        if(fullMap[j][i]=='2')
                            BI = mapTiles[0][0];
                        if(fullMap[j][i]=='3')
                            BI = mapTiles[0][1];
                        if(fullMap[j][i]=='4')
                            BI = mapTiles[0][0];
                        if(fullMap[j][i]=='5')
                            BI = mapTiles[0][1];
                        if(fullMap[j][i]=='6')
                            BI = mapTiles[0][1];


                        g.drawImage(BI,SIZE.PPB * j - Camera.X0-j*6, i * SIZE.PPB - Camera.Y0-i*6, SIZE.PPB, SIZE.PPB, null);
                      //  g.fillRect(SIZE.PPB * j - Camera.X0, i * SIZE.PPB - Camera.Y0, SIZE.PPB, SIZE.PPB);
                    }
                }
            }
        }
    }
}