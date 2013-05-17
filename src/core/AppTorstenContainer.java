package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;

import core.file.UserFileReader;

/**
 * A simple extension of the AppGameContainer that overrides the start() method.
 * 
 * @author Niklas Lindblad
 * @see AppGameContainer
 */
public class AppTorstenContainer extends AppGameContainer {

	public AppTorstenContainer(Game game) throws SlickException {
		super(game);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Starts the game and queues a few actions upon exiting.
	 */
	public void start() throws SlickException {
		super.start();
		UserFileReader.get().printToFile();
		System.exit(0);
	};
}
