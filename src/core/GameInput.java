package core;

import org.newdawn.slick.Input;

/**
 * 
 * 
 * @author Niklas L
 * @deprecated unneccessary and no longer used
 */
public class GameInput extends Input {

	public GameInput(int height) {
		super(height);
		addMouseListener(new MouseInput());
	}

}
