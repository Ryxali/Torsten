package state;

import image.ImageStore;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.GameInput;

public abstract class BasicState extends BasicGameState {
	
	protected double zoom = 1.0;
	public float getScale(){
		return (float) zoom;
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) {
		//makeMouseListener(gc.getInput());
		//sbg.setInput(new GameInput(gc.getScreenHeight()));
	}
	
	@Override
	public void mouseWheelMoved(int change){
		zoom += ((double)change)/3000;
		if(zoom < 0.1){
			zoom = 0.1;
		}
		System.out.println(zoom);
	}

	
}
