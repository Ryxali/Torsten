package core.image;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * An implement for all classes that uses position defined drawing with input checks.
 * 
 * @author Niklas L
 * @see core.image.Drawable
 * @see core.image.DefaultImage
 */
public interface DrawableXYI {
	/**
	 * Draws the content on the screen
	 * 
	 * @param g
	 *            the current Graphics context
	 * @param x
	 *            the horizontal position to draw from
	 * @param y
	 *            the vertical position to draw from
	 * @param input
	 *            the current user input.
	 */
	public void draw(Graphics g, int x, int y, Input input);
}
