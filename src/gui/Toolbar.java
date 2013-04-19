package gui;

import org.newdawn.slick.Graphics;

public class Toolbar extends Palette {
	private int x;
	private int y;
	//private Sample[] samples;

	public Toolbar(String name, int x, int y, int width, int height, Sample... samples) {
		super(name, width, height);
		this.x = x;
		this.y = y;
		this.samples = samples;
	}
	
	public void draw(Graphics g){
		draw(g, x, y);
	}

}
