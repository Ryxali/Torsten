package core.state;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.GameInput;
import core.image.ImageStore;

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
	@Override
	public void leave(GameContainer container, StateBasedGame game)
			throws SlickException {
		System.out.println("LELEE");
		super.leave(container, game);
	}
	public void setBounds(int valueOf, int valueOf2) {
		// TODO Auto-generated method stub
		
	}
	
}
