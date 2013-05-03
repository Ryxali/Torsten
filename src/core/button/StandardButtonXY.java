package core.button;

import java.awt.Point;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DefaultImage;
/**
 * A StandardButton with an x and y position
 * @author Niklas L
 * @see core.button.StandardButton
 * @see core.button.Button
 */
public class StandardButtonXY extends StandardButton {
	
	protected int x;
	protected int y;
	
	/**
	 * Creates a new StandardButton with three images to correspond with its
	 * three states.
	 * @param x the x position of this button.
	 * @param y the y position of this button.
	 * @param idleImg the image displayed when this button is in its idle state.
	 * @param hoverImg the image displayed when this button is in its hover state.
	 * @param pressedImg the image displayed when this button is in its pressed state.
	 */
	public StandardButtonXY(int x, int y, DefaultImage idleImg,
			DefaultImage hoverImg, DefaultImage pressedImg) {
		super(idleImg, hoverImg, pressedImg);
		this.x = x;
		this.y = y;
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
	 * @param x the x position of this button.
	 * @param y the y position of this button.
	 * @param idleImg the image displayed when this button is in its idle state.
	 * @param hoverImg the image displayed when this button is in its hover state.
	 * @param pressedImg the image displayed when this button is in its pressed state.
	 */
	public StandardButtonXY(int x, int y, Image idleImg, Image hoverImg,
			Image pressedImg) {
		super(idleImg, hoverImg, pressedImg);
	}

	@Override
	public StandardButtonXY copy() {
		return new StandardButtonXY(x, y, idleImg, hoverImg, pressedImg);
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

	public void draw(Graphics g, Input input) {
		//update(g, x, y, getProperImage().getWidth(), getProperImage().getHeight(), input);
		draw(g, x, y, input);
	}

	protected void buttonStateCheck(Input input) {
		buttonStateCheck(x, y, input);
	}

	public boolean contains(int pointX, int pointY) {
		return contains(pointX, pointY, x, y);
	}

	public boolean contains(Point point) {
		return contains((int) point.getX(), (int) point.getY());
	}

	@Override
	public void onClick(Input input) {
		// TODO Auto-generated method stub
		
	}
}
