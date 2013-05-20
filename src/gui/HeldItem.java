package gui;

import org.newdawn.slick.Graphics;

import gui.square.Grid;
import gui.square.Square;
import gui.square.item.Placeable;

public class HeldItem {
	private int lastX;
	private int lastY;

	private Placeable item;

	private static HeldItem hI;

	private HeldItem() {

	}

	public static HeldItem get() {
		if (hI == null) {
			hI = new HeldItem();
		}
		return hI;
	}

	public void draw(Graphics g, int x, int y) {
		if (item == null) {
			return;
		}
		lastX = x;
		lastY = y;
		item.draw(g, x, y);

	}

	public Placeable getItem() {
		return item;
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void onUse(Square square) {
		if (item == null) {
			return;
		}
		item.onUse(square);
	}

	public void setItem(Placeable item) {
		this.item = item;
	}
}
