package core.image;

import org.newdawn.slick.Graphics;

/**
 * An implement to all classes that uses draw methods without position
 * specifications
 * 
 * @author Niklas L
 * @see core.image.DrawableXY
 * @see core.image.DefaultImage
 */
public interface Drawable {
	/**
	 * Draws the content on the screen.
	 * 
	 * @param g
	 *            the current Graphics context
	 */
	public void draw(Graphics g);
}
