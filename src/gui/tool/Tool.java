package gui.tool;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.GButton;
import core.button.TextGButton;

/**
 * A basic Tool to be used in Toolbars.
 * 
 * @author Niklas L
 * 
 */
public abstract class Tool extends TextGButton implements Placeable {
	/**
	 * The width of any Tool.
	 */
	public static final int WIDTH = 64;
	/**
	 * The height of any Tool.
	 */
	public static final int HEIGHT = 64;

	/**
	 * Creates a new Tool with the button text specified.
	 * 
	 * @param text
	 *            the text to be displayed on this button
	 */
	public Tool(String text) {
		super(text);
	}

	/**
	 * Draws and auto updates this Tool at the specified position
	 * 
	 * @param g
	 *            the current Graphics context.
	 * @param x
	 *            the x position to draw and check this button at.
	 * @param y
	 *            the y position to draw and check this button at.
	 * @param input
	 *            the current user input.
	 */
	public void draw(Graphics g, int x, int y, Input input) {
		super.draw(g, x, y, WIDTH, HEIGHT, input);
	}

	/**
	 * This draws the tool itself (not the button) at the specified point.
	 */
	public abstract void draw(Graphics g, int x, int y);

	/**
	 * A method called when this Tool has been selected. It will return either
	 * the tool itself or have some direct action and return null.
	 * 
	 * @return the Tool itself or null, depending on tool.
	 */
	public abstract Tool getTool();

	// public abstract void
}
