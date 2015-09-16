package Objects;

import Main.SIZE;
import Mech.KeyHandler;
import Mech.MapEmulator;
import Resources.Content;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Player extends Entity {

	// sprites
	private BufferedImage[] PLAYER;
	// gameplay
	private long ticks;
	boolean moving = false;
	private double radian = 0;
	public Player(int x, int y) {
		Speed = 1;
		X0C = x;
		Y0C = y;
		OldX = x;
		OldY = y;
		PLAYER = Content.PLAYER[0];
		//animation.setFrames(Content.SPARKLE[0]);
		//animation.setDelay(5);
		Width = SIZE.PPB/100;
		Height = PLAYER[0].getHeight();
		animation.setFrames(PLAYER);
		animation.setDelay(20);
	}
	
	private void setAnimation(int i, BufferedImage[] bi, int d) {
		currentAnimation = i;
		animation.setFrames(bi);
		animation.setDelay(d);
	}

	public void moveTo (int dx, int dy) {
		if ((MapEmulator.getNeuron(calcBlockX(X0C + dx),calcBlockY(Y0C + dy))!='1')) {
			X0C = X0C + dx;
			Y0C = Y0C + dy;
		}
		System.out.println(MapEmulator.getNeuron(calcBlockX(X0C + dx),calcBlockY(Y0C + dy)));
	}

	public void update() {
	//	Sounds.play("/splash.wav")
//
//		System.out.println("Blocks");
//		System.out.println(blockX);
//		System.out.println(blockY);

		if ((OldX!=X0C)||(OldY!=Y0C)) {
			moving = true;
			OldX = X0C;
			OldY = Y0C;
			calcBlock();
		}
			else {
			moving = false;
		}
		double grad = 0;
		double b = (KeyHandler.getMouseX() - X0C);
		double a = (KeyHandler.getMouseY() - Y0C);
		double c = Math.abs(a);
		double d = Math.abs(b);
		if (a>0)
			grad = Math.atan(d/c);
		else if ((a<0)&&(b>0))
			grad = Math.atan(d/c)+Math.PI;
		else if ((a<0)&&(b<0))
			grad = Math.atan(d/c)-Math.PI;
		else if ((a==0)&&(b<=0))
			grad = 270;
		else if ((a==0)&&(b>=0))
			grad = 90;
		radian = grad;
		System.out.println(grad*180/Math.PI);

/*		if (SIZE.PPB!=OldSize) {
			OldSize = SIZE.PPB;
			System.out.println("cord");
			System.out.println(X0C);
			System.out.println(Y0C);
			System.out.println(blockX);
			System.out.println(blockY);
			System.out.println(SIZE.PPB);
			X0C = blockX*SIZE.PPB;
			Y0C = blockY*SIZE.PPB;

			System.out.println(blockX);
			System.out.println(blockY);
			System.out.println("cord");
			System.out.println(X0C);
			System.out.println(Y0C);
			System.out.println("end");
		}
*/
		if (moving)
		animation.update();
		super.update();
	}
	
	// Draw Player.
	public void draw(Graphics g) {
		BufferedImage Img = animation.getImage();
		AffineTransform transform = new AffineTransform();
		int radians = 0;
		//transform.rotate(radian, Img.getWidth(), Img.getHeight());
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		Img = op.filter(Img, null);
		Width = Img.getWidth();
		Height = Img.getHeight();
		g.drawImage(Img, X0 - Camera.X0, Y0 - Camera.Y0, null);
	}
}