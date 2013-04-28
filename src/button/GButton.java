package button;

import image.ImageStore;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class GButton extends Button{
	
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
	 * Updates the button state and then draws the button at the given
	 * position with given width and height.
	 * @param g the current graphics context
	 * @param x the x position to draw this button at.
	 * @param y the y position to draw this button at.
	 * @param width the width to draw this button with.
	 * @param height the height to draw this button with.
	 * @param input the current user input.
	 */
	public void draw(Graphics g, int x, int y, int width, int height, Input input){
		update(g, x, y, width, height, input);
		if(getState()==STATE_IDLE){
			g.setColor(Color.gray);
		}else if(getState()==STATE_HOVER){
			g.setColor(Color.lightGray);
		}else if(getState() == STATE_PRESSED){
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
		// TODO Auto-generated method stub
		
	}
	
	/*public void draw(Graphics g, int x, int y, int width, int height){
		
	}*/

	/*@Override
	public void buttonStateCheck(Input input) {
		buttonStateCheck(input, x, y, 100);
	}
	public void buttonStateCheck(Input input, int x, int y, int width) {
		int mX = input.getMouseX();
		int mY = input.getMouseY();
		int farX = x + width;
		int farY = y + 50;
		//System.out.println(x + " < " + mX + " < " + farX);
		//System.out.println(y + " < " + mY + " < " + farY);
		if (pointContains(x, mX, farX) && pointContains(y, mY, farY)) {
			System.out.println("Aye");
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && (getState() == STATE_HOVER || getState()==STATE_PRESSED)) {
				setState(STATE_PRESSED);
				setClicked(true);
			} else {
				if(!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
					setState(STATE_HOVER);
				}else{
					setState(STATE_IDLE);
				}
			}
		} else if (!(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) 
				&& getState() == STATE_PRESSED)) {
			setState(STATE_IDLE);
			setClicked(false);
		}
	}*/

}
