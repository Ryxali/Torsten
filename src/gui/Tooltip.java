package gui;

import gui.square.item.Creature;
import gui.square.item.LootPile;
import gui.square.item.Obstacle;
import gui.square.item.SquareItem;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.image.Drawable;

/**
 * This is a class that is called when tooltip needs to be drawn. Currently only
 * one call can be drawn each render and the content will be drawn on the
 * bottommost part of the screen. The tooltip content will be stretched to match
 * the screen width.
 * 
 * @author Niklas L
 * 
 */
public class Tooltip {
	/**
	 * The X position of this element
	 */
	public static final int X_POS = 0;
	/**
	 * The height of this element
	 */
	public static final int HEIGHT = 150;
	/**
	 * The tooltip
	 */
	private static Tooltip tTip;

	/**
	 * Constructs a new Tooltip
	 */
	private Tooltip() {

	}

	/**
	 * Fetches the Tooltip object
	 * 
	 * @return tTip, the tooltip object
	 */
	public static Tooltip get() {
		if (tTip == null) {
			tTip = new Tooltip();
		}
		return tTip;
	}

	/**
	 * Draws the items' info onto the screen, each item is given a box to be
	 * draw in.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param screenWidth
	 *            the current width of the screen
	 * @param screenHeight
	 *            the current height of the screen
	 * @param items
	 *            the items derive info from.
	 */
	public void draw(Graphics g, int screenWidth, int screenHeight,
			SquareItem... items) {
		g.setColor(Color.lightGray);
		g.fillRect(X_POS, screenHeight - HEIGHT, screenWidth, HEIGHT);
		g.setColor(Color.black);

		for (int i = 0; i < items.length; i++) {

			g.drawRect(X_POS + (screenWidth / items.length) * i, screenHeight
					- HEIGHT, screenWidth, HEIGHT);
			if (items[i] != null) {
				items[i].drawInfo(g, X_POS + 5 + (screenWidth / items.length)
						* i, screenHeight - HEIGHT, screenWidth / items.length
						- 10);
			}
		}
		/*
		 * //Square Tile info
		 * 
		 * //Creature info g.drawRect(X_POS+200, Y_POS-HEIGHT, 200, 150);
		 * //Obstacle info g.drawRect(X_POS+400, Y_POS-150, 200, 150); //Item
		 * info g.drawRect(X_POS+600, Y_POS-150, 200, 150);
		 */

		/*
		 * if(creature != null){ creature.drawInfo(g, X_POS+200, Y_POS); }
		 * if(obstacle != null){ obstacle.drawInfo(g, X_POS+400, Y_POS); }
		 * if(loot != null){ loot.drawInfo(g, X_POS+600, Y_POS); }
		 */

	}

	/**
	 * Draws the String items on the screen. Each item is given a box to be
	 * drawn in
	 * 
	 * @param g
	 *            the current graphics context
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @param items
	 *            the items to draw
	 */
	public void draw(Graphics g, int screenWidth, int screenHeight,
			String... items) {
		g.setColor(Color.lightGray);
		g.fillRect(X_POS, screenHeight - HEIGHT, screenWidth, HEIGHT);
		g.setColor(Color.black);

		for (int i = 0; i < items.length; i++) {

			g.drawRect(X_POS + (screenWidth / items.length) * i, screenHeight
					- HEIGHT, screenWidth, HEIGHT);
			if (items[i] != null) {
				g.drawString(items[i], X_POS + 5 + (screenWidth / items.length)
						* i, screenHeight - HEIGHT);
			}
		}
	}

	/**
	 * Checks whether the specified coordinates is within this Tooltip
	 * 
	 * @param mouseX
	 *            the x position of the mouse
	 * @param mouseY
	 *            the y position of the mouse
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @return true if the chosen coordinates both exist within the tooltip
	 *         bounds
	 */
	public boolean contains(int mouseX, int mouseY, int screenWidth,
			int screenHeight) {
		if (X_POS <= mouseX && mouseX <= X_POS + screenWidth) {
			if (screenHeight >= mouseY && mouseY >= screenHeight - HEIGHT) {
				return true;
			}
		}
		return false;
	}

}
