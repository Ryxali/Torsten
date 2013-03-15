package core;

import org.newdawn.slick.Input;

public class GameInput extends Input{

	public GameInput(int height) {
		super(height);
		addMouseListener(new MouseInput());
	}

}
