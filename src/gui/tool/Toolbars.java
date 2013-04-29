package gui.tool;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.Main;
import core.state.StateList;

public enum Toolbars {
	UTILITIES(new AnchoredToolbar("Utilites", 0, 64, 64, 600-64-150, AnchoredToolbar.ANCHOR_LEFT_TOP, new DeleteTool("Del."), new DeleteTool("Del."))),
	FILE(new AnchoredToolbar("File", 0, 0, 600, 64, AnchoredToolbar.ANCHOR_LEFT_TOP, new NewGridTool("New\nGrid"), new SaveTool("Save"), new LoadTool("Load"), new SettingsTool("Sett-\nings")));
	private final AnchoredToolbar toolbar;
	private Toolbars(AnchoredToolbar toolbar){
		this.toolbar = toolbar;
	}
	
	public static void update(Input input){
		
	}
	
	public static Placeable getCurrentTool(Placeable p){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			p = temp[i].toolbar.checkToolPickup(p);
		}
		return p;
	}
	
	public static void draw(Graphics g, int screenWidth, int screenHeight, Input input){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			temp[i].toolbar.draw(g, screenWidth, screenHeight, input);
		}
	}
}
