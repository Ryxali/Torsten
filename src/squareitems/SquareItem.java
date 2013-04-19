package squareitems;

import image.DrawableXY;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class SquareItem implements DrawableXY, Placeable {
	

	/**
	 * The image representation of this creature
	 */
	protected Image image;
	/**
	 * The text info regarding the creature
	 */
	protected String info = "Default String";
	/**
	 * The name of the creature
	 */
	protected String name;
	
	public SquareItem(String name, Image image, String info) {
		this.image = image;
		this.info = info;
		this.name = name;
	}
	
	/**
	 * Formats the string to split at given bounds
	 * 
	 * @param g the current graphics context
	 * @param string the string to split
	 * @param maxWidth the maximum width bounds.
	 * @return a string split to fit within the bounds.
	 */
	private String format(Graphics g, String string, int maxWidth) {
		String[] temp = string.split(" ");
		int width = 0;
		String product = "";
		for (int i = 0; i < temp.length; i++) {
			if ((width + g.getFont().getWidth(temp[i])) < maxWidth) {
				width += g.getFont().getWidth(temp[i]);
				product += temp[i] + " ";
				if (temp[i].contains("\n")) {
					width = 0;
				}
				//System.out.println(width);
			} else {
				width = g.getFont().getWidth(temp[i]);
				product += "\n" + temp[i] + " ";
			}
			
		}
		/*
		 * boolean running = true; while (running) { while
		 * (g.getFont().getWidth(temp[index]) + width > maxWidth) {
		 * if(temp[index].contains("\n")){ width = 0; } product += temp[index];
		 * index++; } if (index >= temp.length) { return product; } product +=
		 * "\n"; width = 0; }
		 */

		return product;
	}
	/**
	 * Draws this objects text info into the text box
	 * @param g
	 * @param x1
	 * @param y1
	 * @param textRow
	 * @return the number of rows this text takes
	 */
	public void drawInfo(Graphics g, int x1, int y1) {
		String temp = name + "\n";
		temp +=format(g, info, 200);
		g.drawString(temp, x1, y1);
		
		//return temp.split("\n").length;
	}
}
