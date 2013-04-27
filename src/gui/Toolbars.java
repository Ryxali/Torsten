package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public enum Toolbars {
	UTILITIES(new Toolbar("Utilites", 0, 0, 800, 64)),
	FILE(new Toolbar("File", 0, 0, 600, 64, new SaveTool("Save"), new LoadTool("Load")));
	private final Toolbar toolbar;
	private Toolbars(Toolbar toolbar){
		this.toolbar = toolbar;
	}
	
	public void update(Input input){
		toolbar.update(input);
	}
	
	public void draw(Graphics g, Input input){
		toolbar.draw(g, input);
	}
}
