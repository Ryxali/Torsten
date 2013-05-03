package gui.tool;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.Main;
import core.state.StateList;

public enum Toolbars {
	UTILITIES(
			new AnchoredToolbar("Utilites", 0, 64, 64, 600-64-150, AnchoredToolbar.ANCHOR_LEFT_TOP, 
			new DeleteTool("Del.")
			)),
	FILE(new AnchoredToolbar("File", 0, 0, 600, 64, AnchoredToolbar.ANCHOR_LEFT_TOP,
			new NewGridTool("New\nGrid"),
			new SaveTool("Save"),
			new LoadTool("Load"),
			new SettingsTool("Sett-\nings"),
			new NewPaletteTool("New\nPalette"),
			new AddSampleTool("Add\nSample")
			))
	;
	
	private final AnchoredToolbar toolbar;
	private Toolbars(AnchoredToolbar toolbar){
		this.toolbar = toolbar;
	}
	
	public static boolean update(Input input){
		return false;
	}
	public static boolean contains(int pointX, int pointY, int screenWidth, int screenHeight){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].toolbar.contains(pointX, pointY, screenWidth, screenHeight)){
				return true;
			}
		}
		return false;
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
