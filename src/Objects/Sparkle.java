// Simple class that plays animation
// once and is removed.

package Objects;

import java.awt.*;

public class Sparkle extends Entity {
	
	private boolean remove;
	
	public Sparkle() {
		//animation.setFrames(Content.SPARKLE[0]);
		//animation.setDelay(5);
	}
	
	public boolean shouldRemove() {
		return remove;
	}
	
	public void update() {
		animation.update();
		if(animation.hasPlayedOnce()) remove = true;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
	}
	
}
