package core.button;

import java.awt.Point;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DefaultImage;
/**
 * A button using three different images to represent its states.
 * @author Niklas L
 * @see core.button.Button
 *
 */
public class StandardButton extends Button {
	/**
	 * The image displayed when this button is in its idle state.
	 */
	protected Image idleImg;
	/**
	 * The image displayed when this button is in its hover state.
	 */
	protected Image hoverImg;
	/**
	 * The image displayed when this button is in its pressed state.
	 */
	protected Image pressedImg;
	
	/**
	 * Creates a new StandardButton with three images to correspond with its
	 * three states.
	 * @param idleImg the image displayed when this button is in its idle state.
	 * @param hoverImg the image displayed when this button is in its hover state.
	 * @param pressedImg the image displayed when this button is in its pressed state.
	 */
	public StandardButton(DefaultImage idleImg,
			DefaultImage hoverImg, DefaultImage pressedImg) {
		super();
		this.idleImg = idleImg.getImage();
		this.hoverImg = hoverImg.getImage();
		this.pressedImg = pressedImg.getImage();
	}

	/*public StandardButton(ImageStore idleImg, ImageStore hoverImg,
			ImageStore pressedImg) {
		super(0, 0);
		this.idleImg = idleImg.getImage();
		this.hoverImg = hoverImg.getImage();
		this.pressedImg = pressedImg.getImage();
	}*/
	/**
	 * Creates a new StandardButton with three images to correspond with its
	 * three states.
	 * @param idleImg the image displayed when this button is in its idle state.
	 * @param hoverImg the image displayed when this button is in its hover state.
	 * @param pressedImg the image displayed when this button is in its pressed state.
	 */
	public StandardButton(Image idleImg, Image hoverImg,
			Image pressedImg) {
		super();
		this.idleImg = idleImg;
		this.hoverImg = hoverImg;
		this.pressedImg = pressedImg;
	}
	/**
	 * Get the image that matches this button's current state.
	 * @return the proper image to be used based on current state.
	 */
	public Image getProperImage() {
		if (getState() == STATE_IDLE) {
			return idleImg;
		} else if (getState() == STATE_HOVER) {
			return hoverImg;
		} else if (getState() == STATE_PRESSED) {
			return pressedImg;
		}
		return null;
	}

	@Override
	public StandardButton copy() {
		return new StandardButton(idleImg, hoverImg, pressedImg);
	}

	/*@Override
	public void buttonStateCheck(Input input) {
		int mX = input.getMouseX();
		int mY = input.getMouseY();
		int farX = getX() + getStoredImage().getImage().getWidth();
		int farY = getY() + getStoredImage().getImage().getHeight();

		if (pointContains(getX(), mX, farX) && pointContains(getY(), mY, farY)) {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)
					&& (getState() == STATE_HOVER || getState() == STATE_PRESSED)) {
				setState(STATE_PRESSED);
				setClicked(true);
			} else {
				if (!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					setState(STATE_HOVER);
				} else {
					setState(STATE_IDLE);
				}
			}
		} else if (!(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && getState() == STATE_PRESSED)) {
			setState(STATE_IDLE);
			setClicked(false);
		}
	}*/

	@Override
	public int getType() {
		return ButtonStore.MODE_REGULAR;
	}
	/**
	 * updates the button, then draws this button at the specified position.
	 * @param g the current graphics context
	 * @param x the x position to draw at
	 * @param y the y position to draw at
	 * @param input the current user input
	 */
	public void draw(Graphics g, int x, int y, Input input) {
		update(g, x, y, getProperImage().getWidth(), getProperImage().getHeight(), input);
		getProperImage().draw(x, y);
	}
	/**
	 * Checks the provided user input and changes the button state accordingly.
	 * @param x the x position for this button.
	 * @param y the y position for this button.
	 * @param input the current user input.
	 * @return 
	 */
	protected void buttonStateCheck(int x, int y, Input input) {
		buttonStateCheck(input, x, y, getProperImage().getWidth(), getProperImage().getHeight());
	}
	/**
	 * Checks if the given point is within this button's bounds and at the given position.
	 * @param pointX the x position of the point to check.
	 * @param pointY the y position of the point to check.
	 * @param x the x position of this button.
	 * @param y the y position of this button.
	 * @return true if the point is within this button's given bounds.
	 */
	public boolean contains(int pointX, int pointY, int x, int y) {
		return contains(pointX, pointY, x, y, getProperImage().getWidth(),
				getProperImage().getHeight());
	}
	/**
	 * Checks if the given point is within this button's bounds and at the given position.
	 * @param point the point to check.
	 * @param x the x position of this button.
	 * @param y the y position of this button.
	 * @return true if the point is within this button's given bounds.
	 */
	public boolean contains(Point point, int x, int y) {
		return contains((int) point.getX(), (int) point.getY(), x, y);
	}

	@Override
	public void onClick(Input input) {
		// TODO Auto-generated method stub
		
	}
}
