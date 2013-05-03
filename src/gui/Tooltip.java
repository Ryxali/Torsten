package gui;

import gui.square.item.Creature;
import gui.square.item.LootPile;
import gui.square.item.Obstacle;
import gui.square.item.SquareItem;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.image.Drawable;

public class Tooltip {

	public static final int X_POS = 0;
	public static final int HEIGHT = 150;
	private static Tooltip tTip;

	private Tooltip() {

	}

	public static Tooltip get() {
		if (tTip == null) {
			tTip = new Tooltip();
		}
		return tTip;
	}

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
