package core;

import core.window.TorstenFrame;
import core.window.TorstenWindow;

public class Main2 extends TorstenFrame {
	
	
	public static void main(String[] args){
		TorstenWindow win = new TorstenWindow(new Main2());
		win.start();
	}

	@Override
	public int getDefaultState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
