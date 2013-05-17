package core.image;

import org.newdawn.slick.Graphics;

/**
 * An implement for all classes that uses position defined drawing
 * 
 * @author Niklas L
 * @see core.image.Drawable
 * @see core.image.DefaultImage
 */
public interface DrawableXY {
	/**
	 * Draws the content on the screen
	 * 
	 * @param g
	 *            the current Graphics context
	 * @param x
	 *            the horizontal position to draw from
	 * @param y
	 *            the vertical position to draw from
	 */
	public void draw(Graphics g, int x, int y);
}
