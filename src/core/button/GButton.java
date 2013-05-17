package core.button;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DefaultImage;

/**
 * A button drawn with the slick graphics.
 * 
 * @author Niklas L
 * @see core.button.Button
 */
public class GButton extends Button {

	/**
	 * Constructs a new GButton
	 */
	public GButton() {
		super();
	}

	@Override
	public Button copy() {
		return new GButton();
	}

	/**
	 * Updates the button state and then draws the button at the given position
	 * with given width and height.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param x
	 *            the x position to draw this button at.
	 * @param y
	 *            the y position to draw this button at.
	 * @param width
	 *            the width to draw this button with.
	 * @param height
	 *            the height to draw this button with.
	 * @param input
	 *            the current user input.
	 */
	public void draw(Graphics g, int x, int y, int width, int height,
			Input input) {
		update(g, x, y, width, height, input);
		if (getState() == STATE_IDLE) {
			g.setColor(Color.gray);
		} else if (getState() == STATE_HOVER) {
			g.setColor(Color.lightGray);
		} else if (getState() == STATE_PRESSED) {
			g.setColor(Color.darkGray);
		}
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}

	@Override
	public int getType() {
		return ButtonStore.MODE_REGULAR;
	}

	@Override
	public void onClick(Input input) {
		// TODO onClick effect maybe
	}
}
