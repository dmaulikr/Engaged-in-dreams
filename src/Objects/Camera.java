package Objects;

import Main.SIZE;
import Mech.Collision;
import Mech.MapEmulator;

import java.awt.*;

/**
 * Created by SeaDevil on 01.09.2015.
 */
public class Camera {
    public static int WIDTH = SIZE.WIDTH;
    public static int HEIGHT = SIZE.HEIGHT;
    public static int X0=0;
    public static int X1= WIDTH+X0;
    public static int Y0 = 0;
    public static int Y1 = HEIGHT+Y0;
    public Animation animation = new Animation();
    public Camera () {

    }

    public boolean isVisible (Entity e) {
        if (Collision.isColised(e, X0, Y0, X1, Y1)){
            return true;
        }
        else
            return false;
    }

    public void update(int x, int y){
        calculate_size();
        if (Camera.X0+WIDTH/2.5>x) {
            Camera.X0--;
        }
        if (Camera.X1-WIDTH/2.5<x) {
            Camera.X0++;
        }
        if (Camera.Y0+HEIGHT/2.5>y) {
            Camera.Y0--;
        }
        if (Camera.Y1-HEIGHT/2.5<y) {
            Camera.Y0++;
        }
        calculate_size();
        animation.update();
    }

    private void calculate_size(){
        X1 = X0 + WIDTH;
        Y1 = Y0 + HEIGHT;
    }

    public void draw(Graphics g, Entity[] ent, Player p) {
          MapEmulator.draw(X0, Y0, g);
        if (ent.length>=1)
            for (int i = 0; i < ent.length; i++) {
                if(ent[i]!=null)
                if(isVisible(ent[i]))
                    ent[i].draw(g);
            }
        p.draw(g);
    }
}