package state;

import file.UserFileReader;
import image.ImageStore;

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
		ImageStore.DEFAULT.draw(50, 50);
		square.Grid.get().draw(g, gc.getInput());
		UserFileReader.get().get(0).draw(g, gc.getWidth(), 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		//gc.getInput().setScale((float)zoom, (float)zoom);
		UserFileReader.get().get(0).update(gc.getInput());
		
	}

	@Override
	public int getID() {
		
		return StateList.BUILD.getID();
	}

}
