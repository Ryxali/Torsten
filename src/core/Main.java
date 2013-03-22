package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import state.BuildState;
import state.StateList;

public class Main extends StateBasedGame{

	public Main(String name) {
		super(name);
		addStates();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main("TorstenFTW"));
			appgc.setTargetFrameRate(60);
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void addStates(){
		addState(StateList.BUILD.getState());
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		enterState(StateList.BUILD.getID());		
	}

}
