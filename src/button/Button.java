package button;





import java.awt.Point;

import image.DrawableXY;
import image.ImageStore;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.Loadable;



public abstract class Button{
	
	
	private int state = 0;
	private boolean clicked = false;
	
	/**
	 * This value corresponds with value for the button while being idle.
	 */
	public static final int STATE_IDLE = 0;
	/**
	 * This value corresponds with value for the button while being
	 * hovered.
	 */
	public static final int STATE_HOVER = 1;
	/**
	 * This value corresponds with value for the button while being
	 * pressed.
	 */
	public static final int STATE_PRESSED = 2;
	
	/**
	 * When calling the hasBeenClicked() method, it will return
	 * this value if the button indeed has been pressed.
	 */
	public static final int PRESSED_TRUE = 1;
	/**
	 * When calling the hasBeenClicked() method, it will return
	 * this value if the button indeed hasn't been pressed.
	 */
	public static final int PRESSED_FALSE = 0;
	/**
	 * The type value corresponding with a regular button
	 */
	public static final int TYPE_REGULAR = 0;
	/**
	 * The type value corresponding with a dropdown list button
	 */
	public static final int TYPE_DROPDOWN = 1;
	/**
	 * The type value corresponding with a slider button
	 */
	public static final int TYPE_SLIDER = 2;
	
	/**
	 * Constructs a new Button.
	 */
	public Button(){
	}
	/**
	 * Get the current state of this button.
	 * @return STATE_IDLE, STATE_HOVER or STATE_PRESSED
	 */
	public int getState(){
		return state;
	}
	/**
	 * Set the current state of this button.
	 * @param STATE_IDLE, STATE_HOVER or STATE_PRESSED
	 */
	public void setState(int state){
		this.state = state;
	}
	/**
	 * Creates and returns an identical copy of this object.
	 * @return the copy of this button.
	 */
	public abstract Button copy();
	/*/**
	 * Draws this button onto the screen.
	 * @param g the graphics context
	 */
	/*public abstract void draw(Graphics g);*/
	
	/**
	 * checks and sets the state of this button.
	 * @param input the current input
	 * @param butPosX the X position of this button
	 * @param butPosY the Y position of this button
	 * @param butWidth the width of this button
	 * @param butHeight the height of this button
	 */	
	protected void buttonStateCheck(Input input, int butPosX, int butPosY, int butWidth, int butHeight){
		if (contains(input.getMouseX(), input.getMouseY(), butPosX, butPosY, butPosX+butWidth, butPosY+butHeight)) {
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
	}
	
	/**
	 * Checks if the point given is within the bounds of the button.
	 * @param point a Point to check.
	 * @return true if the point's x and y position is within the button area.
	 */
	public boolean contains(int pointX, int pointY, int x, int y, int farX, int farY){
		if(pointContains(x, pointX, farX) && pointContains(y, pointY, farY)){
			return true;
		}
		return false;
	}
	/**
	 * Return a value corresponding to this button type.
	 * <ol> <b>Commonly used button types:</b>
	 * <li>TYPE_REGULAR; a regular button</li>
	 * <li>TYPE_SLIDER; a button with a slider</li>
	 * <li>TYPE_DROPDOWN; a button with a dropdown list</li>
	 * </ol>
	 * @return a type value corresponding with this button
	 */
	public abstract int getType();
	
	/**
	 * 
	 * @return true of this button has been pressed
	 */
	public boolean isClicked(){
		return clicked;
	}
	/**
	 * set whether this button is currently clicked
	 * @param value the new clicked value
	 */
	public void setClicked(boolean value){
		clicked = value;
	}
	
	protected void update(Graphics g, int x, int y, int width, int height, Input input) {
		buttonStateCheck(input, x, y, width, height);
	}
	/**
	 * An action this button has when it has been clicked.
	 * @param input the current user input
	 */
	public abstract void onClick(Input input);
	
	/**
	 * check whether this button has been clicked.
	 * @return PRESSED_TRUE or PRESSED_FALSE
	 */
	public int hasBeenClicked(){
		if(clicked && getState() == STATE_HOVER){
			clicked = false;
			System.out.println("MYES");
			return PRESSED_TRUE;
		}
		return PRESSED_FALSE;
	}
	/**
	 * Retrieve the dropdown list of this button (if any).
	 * @return the DropDown list object associated with this button.
	 */
	/*public DropdownList getDList(){
		return null;
	}*/
	private boolean pointContains(int lBound, int point, int rBound){
		if(lBound <= point && point <= rBound){
			return true;
		}
		return false;
	}
}
