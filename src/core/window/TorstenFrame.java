package core.window;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import core.window.Input;


public abstract class TorstenFrame extends Frame{
	private TorstenState [] tStates;
	private int curState;
	public TorstenFrame(){
		curState = getDefaultState();
	}
	
	public void enterState(int stateID){
		curState = stateID;
	}
	
	public void addState(TorstenState tState){
		TorstenState[] temp = new TorstenState[tStates.length+1];
		for (int i = 0; i < tStates.length; i++) {
			temp[i] = tStates[i];
		}
		temp[temp.length-1] = tState;
		tStates = temp;
	}
	public void update(TorstenWindow window, Graphics2D g, Input input){
		//Graphics2D g = (Graphics2D) window.getGraphics();
		if(tStates[curState].update(window, this, input)){
			render(window, g);
		}
	}
	private void render(TorstenWindow window,
			Graphics2D g) {
		tStates[curState].render(window, this, g);
		
	}

	public abstract int getDefaultState();

}
