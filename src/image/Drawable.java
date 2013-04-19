package image;

import org.newdawn.slick.Graphics;
/**
 * An implement to all classes that uses draw methods without position
 * specifications
 * @author Niklas L
 * @see image.DrawableXY
 * @see image.ImageStore
 */
public interface Drawable {
	/**
	 * Draws the content on the screen.
	 * @param g the current Graphics context
	 */
	public void draw(Graphics g);
}
