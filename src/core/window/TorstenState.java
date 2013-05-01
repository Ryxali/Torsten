package core.window;

import java.awt.Graphics2D;


public abstract class TorstenState {

	public boolean update(TorstenWindow window, TorstenFrame torstenFrame,
			Input input) {
		// TODO Auto-generated method stub
		return false;
	}

	public void render(TorstenWindow window, TorstenFrame torstenFrame,
			Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract int getID();

}
