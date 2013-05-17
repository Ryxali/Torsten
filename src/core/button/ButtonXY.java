package core.button;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.image.Drawable;

/**
 * A button with set x and y coordinates.
 * 
 * @author Niklas L
 * @deprecated this Class does not conform to hierarchy
 */
public abstract class ButtonXY extends Button {

	/**
	 * The x position of this button
	 */
	protected int x;
	/**
	 * The y position of this button
	 */
	protected int y;

	/**
	 * constructs a new button with an x and y position
	 * 
	 * @param x
	 *            the x position of this button
	 * @param y
	 *            the y position of this button
	 */
	public ButtonXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks whether a point is within this button's position and a given width
	 * and height
	 * 
	 * @param pointX
	 *            the x position of the point to check
	 * @param pointY
	 *            the y position of the point to check
	 * @param buttonWidth
	 *            the 'width' of this button.
	 * @param buttonHeight
	 *            the 'height' of this button.
	 * @return
	 */
	public boolean contains(int pointX, int pointY, int buttonWidth,
			int buttonHeight) {
		return contains(pointX, pointY, x, y, x + buttonWidth, y + buttonHeight);
	}

	/**
	 * Checks the current state of this button using this button's X and Y
	 * position as reference.
	 * 
	 * @param input
	 *            the current user input
	 */
	public void buttonStateCheck(Input input, int butWidth, int butHeight) {
		buttonStateCheck(input, x, y, butWidth, butHeight);
	}

	/**
	 * Draws the button onto the screen at its X and Y position.
	 * 
	 * @param g
	 *            the current graphics context
	 */
	protected void update(Graphics g, int width, int height, Input input) {
		update(g, x, y, width, height, input);
	}

	/**
	 * Get the x location of this component.
	 * 
	 * @return the x position of this object.
	 */
	public int getX() {
		return (int) x;

	}

	/**
	 * Get the y location of this component.
	 * 
	 * @return the y position of this object.
	 */
	public int getY() {
		return (int) y;
	}

	/**
	 * Draws the content onto the screen at this button's x and y position
	 * 
	 * @param g
	 *            the current graphics context.
	 * @param input
	 *            the current user input.
	 */
	public abstract void draw(Graphics g, Input input);
}
