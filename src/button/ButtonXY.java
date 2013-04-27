package button;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import image.Drawable;

public abstract class ButtonXY extends Button{
	
	protected int x;
	protected int y;

	public ButtonXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	
	public boolean contains(int pointX, int pointY, int buttonWidth, int buttonHeight){
		return contains(pointX, pointY, x, y, x+buttonWidth, y+buttonHeight);
	}
	/**
	 * Checks the current state of this button using this
	 * button's X and Y position as reference.
	 * @param input the current user input
	 */
	public void buttonStateCheck(Input input, int butWidth, int butHeight) {
		buttonStateCheck(input, x, y, butWidth, butHeight);
	}
	
	/**
	 * Draws the button onto the screen at its
	 * X and Y position.
	 * @param g the current graphics context
	 */
	protected void update(Graphics g, int width, int height, Input input) {
		update(g, x, y, width, height, input);
	}
	
	/**
	 * Get the x location of this component.
	 * @return the x position of this object.
	 */
	public int getX(){
		return (int) x;
		
	}
	/**
	 * Get the y location of this component.
	 * @return the y position of this object.
	 */
	public int getY(){
		return (int) y;
	}
	
	public abstract void draw(Graphics g, Input input);
}
