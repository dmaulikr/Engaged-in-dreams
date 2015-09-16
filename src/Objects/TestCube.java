package Objects;

        import java.awt.Color;
        import java.awt.Graphics;

public class TestCube extends Entity {
    public TestCube () {
        X0C = 128;
        Y0C = 120;
        Width = 6;
        Height = 6;
    }
    private void calcSize () {
        X0 = X0C - (int)Width/2;
        Y0 = Y0C - (int)Height/2;
        X1 = X0C + (int)Width/2;
        Y1 = Y0C + (int)Height/2;
    }

    public void update () {
    //    X0C--;
        Y0C--;
        calcSize();
    }

    public void draw (Graphics g){
        g.setColor(Color.cyan);
        g.drawRect(X0-Camera.X0, Y0-Camera.Y0, X1-Camera.X0, Y1-Camera.Y0);
    }
}