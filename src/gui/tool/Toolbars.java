package gui.tool;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.Main;
import core.state.StateList;
/**
 * An enum containing all the AnchoredToolbars of this application preset with tools.
 * @author Niklas Lindblad
 * @see Toolbar
 * @see AnchoredToolbar
 * @see Tool
 */
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
	/**
	 * The Toolbar in question.
	 */
	private final AnchoredToolbar toolbar;
	/**
	 * Constructs a new enum entry.
	 * @param toolbar the toolbar to add.
	 */
	private Toolbars(AnchoredToolbar toolbar){
		this.toolbar = toolbar;
	}
	/**
	 * Checks whether any of the toolbars in this enum contains the specified points.
	 * @param pointX the x position to check with the toolbars.
	 * @param pointY the y position to check with the toolbars.
	 * @param screenWidth the current screen width.
	 * @param screenHeight the current screen height.
	 * @return true if the given points are within one or more toolbars in this list.
	 */
	public static boolean contains(int pointX, int pointY, int screenWidth, int screenHeight){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].toolbar.contains(pointX, pointY, screenWidth, screenHeight)){
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks all Toolbars in this enum for any Placeable object pickups.
	 * @param pObject the current Placeable object.
	 * @return either the current pObject, or a new one, depending on previous input.
	 */
	public static Placeable getCurrentTool(Placeable pObject){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			pObject = temp[i].toolbar.checkToolPickup(pObject);
		}
		return pObject;
	}
	/**
	 * Draws all the Toolbars in this enum  at their designated position on the screen.
	 * @param g the current Graphics context.
	 * @param screenWidth the current screen width.
	 * @param screenHeight the current screen height.
	 * @param input the current user input.
	 */
	public static void draw(Graphics g, int screenWidth, int screenHeight, Input input){
		Toolbars[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			temp[i].toolbar.draw(g, screenWidth, screenHeight, input);
		}
	}
}
