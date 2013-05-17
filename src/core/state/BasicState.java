package core.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.GameInput;
import core.image.DefaultImage;

/**
 * An extension of the BasicGameState that overrides a few methods from its
 * parent
 * 
 * @author Niklas L
 * 
 */
public abstract class BasicState extends BasicGameState {
	/**
	 * The current zoom factor
	 */
	protected double zoom = 1.0;

	/**
	 * Get the current scale of the program
	 * 
	 * @return zoom, the zoom scale factor
	 */
	public float getScale() {
		return (float) zoom;

	}

	/**
	 * initiates this state.
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) {
		gc.setAlwaysRender(false);
	}

	/**
	 * An override to the mouseWheelMoved event, adding in zooming.
	 */
	@Override
	public void mouseWheelMoved(int change) {
		zoom += ((double) change) / 3000;
		if (zoom < 0.1) {
			zoom = 0.1;
		}
		System.out.println(zoom);
	}

	public void setBounds(int width, int height) {

	}

}
