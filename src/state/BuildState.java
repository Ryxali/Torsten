package state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.MouseInput;

public class BuildState extends BasicState{

	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 100, 100);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		//gc.getInput().setScale((float)zoom, (float)zoom);
		
		
	}

	@Override
	public int getID() {
		
		return 0;
	}

}
