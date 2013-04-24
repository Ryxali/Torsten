package button;

import image.ImageStore;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GButton extends Button{
	public GButton(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public GButton() {
		super(0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Button copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		draw(g, x, y, 50, 50);
	}
	
	public void draw(Graphics g, int x, int y, int width, int height){
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
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ImageStore getStoredImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
