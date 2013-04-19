package state;

import file.UserFileReader;
import gui.PaletteStore;
import gui.Sample;
import gui.Toolbar;
import image.ImageStore;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import square.Grid;
import squareitems.Placeable;

import core.MouseInput;

public class BuildState extends BasicState{
	
	private Sample curSample;
	
	private Toolbar toolbar = new Toolbar("Utilities", 0, 0, 800, 64);
	
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 100, 100);
		ImageStore.DEFAULT.draw(50, 50);
		Grid.get().draw(g, gc.getInput());
		PaletteStore.get().get(0).draw(g, gc.getWidth()-200, 0);
		if(curSample != null){
			curSample.getPlaceableObject().draw(g, gc.getInput().getMouseX()-64, gc.getInput().getMouseY()-64);
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		//gc.getInput().setScale((float)zoom, (float)zoom);
		PaletteStore.get().get(0).update(gc.getInput());
		curSample = PaletteStore.get().getActivePalette().getClickedSample(this);
		if(curSample != null){
			Grid.get().update(gc.getInput(), curSample.getPlaceableObject());
		}
	}
	
	public Sample getCurrentSample(){
		return curSample;
	}

	@Override
	public int getID() {
		
		return StateList.BUILD.getID();
	}

}
