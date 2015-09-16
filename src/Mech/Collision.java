 package Mech;

        import Objects.Entity;

/**
 * Created by SeaDevil on 04.09.2015.
 */
public class Collision {
    public static boolean isColised(Entity ent1, Entity ent2){
        if((isPointInside(ent1.X0,ent1.Y0,ent2.X0,ent2.Y0,ent2.X1,ent2.Y1))){
            return true;
        } else
        if((isPointInside(ent1.X1,ent1.Y0,ent2.X0,ent2.Y0,ent2.X1,ent2.Y1))){
            return true;
        } else
        if((isPointInside(ent1.X0,ent1.Y1,ent2.X0,ent2.Y0,ent2.X1,ent2.Y1))){
            return true;
        } else
        if((isPointInside(ent1.X1,ent1.Y1,ent2.X0,ent2.Y0,ent2.X1,ent2.Y1))){
            return true;
        } else

        if((isPointInside(ent2.X0,ent2.Y0,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(ent2.X1,ent2.Y0,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(ent2.X0,ent2.Y1,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(ent2.X1,ent2.Y1,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else return false;
    }
    public static boolean isColised(Entity ent1, int X, int Y, int Width, int Height){
        if((isPointInside(ent1.X0,ent1.Y0,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(ent1.X1,ent1.Y0,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(ent1.X0,ent1.Y1,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(ent1.X1,ent1.Y1,X,Y,X+Width,Y+Height))){
            return true;
        } else

        if((isPointInside(X,Y,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(X+Width,Y,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(X,Y+Height,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else
        if((isPointInside(X+Width,Y+Height,ent1.X0,ent1.Y0,ent1.X1,ent1.Y1))){
            return true;
        } else return false;
    }

    public static boolean isColised(int X, int Y, int Width, int Height, int X1, int Y1, int Width1, int Height1){
        if((isPointInside(X,Y,X1,Y1,X1+Width1,Y1+Height1))){
            return true;
        } else
        if((isPointInside(X+Width,Y,X1,Y1,X1+Width1,Y1+Height1))){
            return true;
        } else
        if((isPointInside(X,Y+Height,X1,Y1,X1+Width1,Y1+Height1))){
            return true;
        } else
        if((isPointInside(X+Width,Y+Height,X1,Y1,X1+Width1,Y1+Height1))){
            return true;
        } else

        if((isPointInside(X1,Y1,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(X1+Width1,Y1,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(X1,Y1+Height1,X,Y,X+Width,Y+Height))){
            return true;
        } else
        if((isPointInside(X1+Width1,Y1+Height1,X,Y,X+Width,Y+Height))){
            return true;
        } else return false;
    }
    private static boolean isPointInside (int x, int y, int ox, int oy, int mx, int my) {
        if (((x>=ox)&&(x<=mx))||((y>=oy)&&(y<=my)))
            return true;
        else return false;
    }
}