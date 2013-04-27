package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import squareitems.Placeable;
import button.GButton;

public abstract class Tool extends GButton {
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	public Tool(){
		super();
	}
	

	public void draw(Graphics g, int x, int y, Input input) {
		super.draw(g, x, y, WIDTH, HEIGHT, input);
	}
	
	public abstract Tool getTool();
	
	//public abstract void 
}
