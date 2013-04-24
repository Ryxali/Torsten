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
		float width = 0;
		String product = "";
		for (int i = 0; i < temp.length; i++) {
			//g.drawString(((width+g.getFont().getWidth(temp[i]+ " ")) + " : " + maxWidth), 100, i* 15);
			//g.fillRect(5, 400, maxWidth, 50);
			//g.fillRect(width, 300, g.getFont().getWidth(temp[i] + " "), 20);
			if (width + g.getFont().getWidth(temp[i] + " ")*2 < maxWidth) {
				//g.drawString(((width+g.getFont().getWidth(temp[i]+ " ")) + " : " + maxWidth), 220, i* 15);
				width += g.getFont().getWidth(temp[i] + " ");
				product += temp[i];
				if (temp[i].contains("\n")) {
					width = 0;
				}else{
					product += " ";
				}
				//System.out.println(width);
			} else {
				width = g.getFont().getWidth(temp[i] + " ");
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
	 * @param width 
	 * @param textRow
	 * @return the number of rows this text takes
	 */
	public void drawInfo(Graphics g, int x1, int y1, int width) {
		String temp = name + "\n";
		temp +=format(g, info, width);
		g.drawString(temp, x1, y1);
		
		//return temp.split("\n").length;
	}
}
