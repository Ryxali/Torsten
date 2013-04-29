package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import core.state.BuildState;
import core.state.StateList;


public class Main extends StateBasedGame{
	private static AppTorstenContainer apptc;
	public Main(String name) {
		super(name);
		addStates();
	}
	
	
	public static void setBounds(int width, int height) throws SlickException{
		apptc.setDisplayMode(width, height, false);
	}
	public static int getScreenWidth(){
		return apptc.getWidth();
	}
	public static int getScreenHeight(){
		return apptc.getHeight();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			apptc = new AppTorstenContainer(new Main("TorstenFTW"));
			apptc.setTargetFrameRate(60);
			apptc.setDisplayMode(800, 600, false);
			apptc.setForceExit(false);
			apptc.start();
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
