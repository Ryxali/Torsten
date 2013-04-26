package state;

import java.util.ArrayList;

import file.FileReader;
import file.FileSaver;
import file.UserFileReader;
import gui.PaletteStore;
import gui.Sample;
import gui.Toolbar;
import image.ImageStore;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import square.Grid;
import squareitems.Placeable;

import core.MouseInput;

public class BuildState extends BasicState{
	
	private Sample curSample;
	
	private Toolbar toolbar = new Toolbar("Utilities", 0, 0, 800, 64);
	
	private ArrayList<Thread> advEdits = new ArrayList<Thread>();
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 100, 100);
		ImageStore.DEFAULT.draw(50, 50);
		Grid.get().draw(g, gc.getInput());
		PaletteStore.get().draw(g);
		if(curSample != null){
			curSample.getPlaceableObject().draw(g, gc.getInput().getMouseX()-64, gc.getInput().getMouseY()-64);
		}
		
	}
	
	public void addWindow(Thread t){
		advEdits.add(t);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		//gc.getInput().setScale((float)zoom, (float)zoom);
		PaletteStore.get().update(gc.getInput());
		curSample = PaletteStore.get().getActivePalette().getClickedSample(this);
		if(curSample != null){
			if(gc.getInput().isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)){
				curSample = null;
			}else{
				Grid.get().update(gc.getInput(), curSample.getPlaceableObject(), advEdits);
			}
		}else{
			Grid.get().update(gc.getInput(), null, advEdits);
		}
		if(gc.getInput().isKeyDown(Input.KEY_S) && gc.getInput().isKeyDown(Input.KEY_LCONTROL)){
			FileSaver.saveAsDialogue();
		}else if(gc.getInput().isKeyDown(Input.KEY_L) && gc.getInput().isKeyDown(Input.KEY_LCONTROL)){
			FileReader.loadDialogue(gc);
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
