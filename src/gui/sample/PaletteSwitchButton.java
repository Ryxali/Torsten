package gui.sample;

import gui.Tooltip;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;

/**
 * An Extension of the GButton that allows for it to store a Palette's name and
 * drawing that name on the Tooltip.
 * 
 * @author Niklas L
 * @see Palette
 * @see PaletteStore
 * @see Tooltip
 */
public class PaletteSwitchButton extends GButton {
	/**
	 * The name of the palette
	 */
	private String paletteName;

	/**
	 * Constructs a new PaletteSwitchButton according to the GButton constructor
	 * and stores the palette name specified.
	 * 
	 * @param paletteName the name of the palette this button represents.
	 */
	public PaletteSwitchButton(String paletteName) {
		super();
		this.paletteName = paletteName;
	}
	/**
	 * Draws this button onto the screen as well as the palette name into the Tooltip area should it be active.
	 * @param g the current graphics context.
	 * @param x the x position to draw this button at.
	 * @param y the y position to draw this button at.
	 * @param width the width of this button.
	 * @param height the height of this button.
	 * @param screenWidth the current screen width.
	 * @param screenHeight the current screen height.
	 * @param input the current user input.
	 */
	public void draw(Graphics g, int x, int y, int width, int height,
			int screenWidth, int screenHeight, Input input) {
		super.draw(g, x, y, width, height, input);
		if (getState() == STATE_HOVER || getState() == STATE_PRESSED) {
			Tooltip.get().draw(g, screenWidth, screenHeight, paletteName);
		}
	}
}
