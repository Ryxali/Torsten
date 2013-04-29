package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;

import core.file.UserFileReader;


public class AppTorstenContainer extends AppGameContainer{

	public AppTorstenContainer(Game game) throws SlickException {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setForceExit(boolean forceExit) {
		System.out.println("LEL");
		super.setForceExit(forceExit);
	}
	
	public void start() throws SlickException {
		super.start();
		UserFileReader.get().printToFile();
		System.exit(0);
	};
}
