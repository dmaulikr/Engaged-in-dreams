  package Objects;

        import Main.SIZE;

        import java.awt.*;

/**
 * Created by SeaDevil on 01.09.2015.
 */
public class Entity {

    public int X0;
    public int Y0;
    public int X1;
    public int Y1;
    public int X0C;
    public int Y0C;
    public int blockX = X0C/SIZE.PPB+1;  //Не досконалий підрахунок
    public int blockY = Y0C/SIZE.PPB+1;
    public double Width;
    public double Height;
    public int Speed;
    public double Size;
    public int OldSize;
    public int OldX;
    public int OldY;
    // animation
    protected Animation animation = new Animation();
    protected int currentAnimation;

    private void calcSize () {
        X0 = X0C - (int)Width/2;
        Y0 = Y0C - (int)Height/2;
        X1 = X0C + (int)Width/2;
        Y1 = Y0C + (int)Height/2;
    }

    public void calcBlock(){
        blockX = X0C/SIZE.PPB+1;
        blockY = Y0C/SIZE.PPB+1;
    }

    public int calcBlockX(int x0){
        return blockX = x0/SIZE.PPB+1;
    }

    public int calcBlockY(int y0){
        return blockY = y0/SIZE.PPB+1;
    }

    public void update(){
        calcSize();
    }

    public void draw(Graphics g) {
        g.drawImage(animation.getImage(), X0-Camera.X0, Y0-Camera.Y0, null);
    }
}