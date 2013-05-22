package core;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import core.state.BuildState;
import core.state.StateList;

/**
 * As the main class of the game, this class is in charge of creating a game
 * instance and getting the ball rolling.
 * 
 * @author Niklas Lindblad
 * @see StateBasedGame
 * @see AppTorstenContainer
 */
public class Main extends StateBasedGame {
	/**
	 * Our game container
	 */
	private static AppTorstenContainer apptc;

	/**
	 * Constructs a StateBasedGame and adds the states to it
	 * 
	 * @param name
	 *            the name of the game
	 */
	public Main(String name) {
		super(name);
		addStates();
	}
	
	/**
	 * sets a new screen size for the game
	 * 
	 * @param width
	 *            the new width of the game window
	 * @param height
	 *            the new height of the game window
	 * @throws SlickException
	 *             if the new DisplayMode is invalid.
	 */
	public static void setBounds(int width, int height) throws SlickException {
		apptc.setDisplayMode(width, height, false);
	}

	public static int getScreenWidth() {
		return apptc.getWidth();
	}

	public static int getScreenHeight() {
		return apptc.getHeight();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			apptc = new AppTorstenContainer(new Main("TorstenFTW"));
			//
			apptc.setDisplayMode(800, 600, false);
			apptc.setForceExit(false);
			apptc.setClearEachFrame(false);
			apptc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * adds all the states we want to use to the container
	 */
	private void addStates() {
		addState(StateList.BUILD.getState());
	}

	/**
	 * calls the various states' init() method, then enters the default state.
	 */
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		enterState(StateList.BUILD.getID());
	}

}
