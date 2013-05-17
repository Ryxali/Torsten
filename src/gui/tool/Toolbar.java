package gui.tool;

import gui.square.item.Placeable;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;
import core.image.Drawable;
import core.image.DrawableXY;

/**
 * A basic container of Tools.
 * 
 * @author Niklas L
 * 
 */
public class Toolbar {
	/**
	 * The x position of this object
	 */
	protected int x;
	/**
	 * The y position of this object
	 */
	protected int y;
	/**
	 * The width of this object
	 */
	protected int width;
	/**
	 * The height of this object
	 */
	protected int height;
	/**
	 * The tools this Toolbar contains.
	 */
	private Tool[] tools;

	/**
	 * Creates a new Toolbar with a name, x position, y position, width, height
	 * and a set of tools.
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param tools
	 */
	public Toolbar(String name, int x, int y, int width, int height,
			Tool... tools) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tools = (Tool[]) tools;
	}

	/**
	 * Draws this Toolbar and its Tools at its location on the screen and
	 * updates the Tools it contains.
	 * 
	 * @param g
	 *            the current Graphics context.
	 * @param input
	 *            the current user input.
	 */
	public void draw(Graphics g, Input input) {
		draw(g, x, y, input);
	}

	/**
	 * Draws this Toolbar and its Tools at the specified point and updates the
	 * Tools based on this point.
	 * 
	 * @param g the current Graphics context.
	 * @param x the x position to draw this Toolbar at.
	 * @param y the y position to draw this Toolbar at.
	 * @param input the current user input.
	 */
	public void draw(Graphics g, int x, int y, Input input) {
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);

		int row = 0;
		int col = 0;
		for (int i = 0; i < tools.length; i++) {
			if (tools[i] != null) {
				tools[i].draw(g, col + x, row + y, input);
				col += 64;
				if (col + 64 > width) {
					col = 0;
					row += 64;
				}
			}
		}

	}
	/**
	 * Checks if any tools have been selected since the last loop.
	 * @param pObject the current Placeable object held by the user.
	 * @return either the old pObject, or a new one should a Tool have been selected.
	 */
	public Placeable checkToolPickup(Placeable pObject) {
		for (int i = 0; i < tools.length; i++) {
			if (tools[i].hasBeenClicked() == Button.PRESSED_TRUE) {
				return tools[i].getTool();
			}
		}
		return pObject;
	}
	/**
	 * Get the y position of this Toolbar.
	 * @return y, the y position of this Toolbar.
	 */
	public int getY() {
		return y;
	}
}
