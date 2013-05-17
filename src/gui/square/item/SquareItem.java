package gui.square.item;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.image.DrawableXY;
import core.image.ImageStore;

public abstract class SquareItem implements DrawableXY {

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

	/**
	 * Constructs a new SquareItem with the name, image and info specified.
	 * 
	 * @param name
	 *            the name of the SquareItem.
	 * @param image
	 *            the image of the SquareItem.
	 * @param info
	 *            the info of the SquareItem.
	 */
	public SquareItem(String name, Image image, String info) {
		this.image = image;
		this.info = info;
		this.name = name;
	}

	/**
	 * Constructs a new SquareItem with the name, image and info specified.
	 * 
	 * @param name
	 *            the name of the SquareItem.
	 * @param imgRef
	 *            the image reference for the SquareItem.
	 * @param info
	 *            the info of the SquareItem.
	 */
	public SquareItem(String name, String imgRef, String info) {
		this.image = ImageStore.get().getImage(imgRef);
		this.info = info;
		this.name = name;
	}

	/**
	 * Formats the string to split at given bounds
	 * 
	 * @param g
	 *            the current graphics context
	 * @param string
	 *            the string to split
	 * @param maxWidth
	 *            the maximum width bounds.
	 * @return a string split to fit within the bounds.
	 */
	private String format(Graphics g, String string, int maxWidth) {
		String[] temp = string.split(" ");
		float width = 0;
		String product = "";
		for (int i = 0; i < temp.length; i++) {
			// g.drawString(((width+g.getFont().getWidth(temp[i]+ " ")) + " : "
			// + maxWidth), 100, i* 15);
			// g.fillRect(5, 400, maxWidth, 50);
			// g.fillRect(width, 300, g.getFont().getWidth(temp[i] + " "), 20);
			if (width + g.getFont().getWidth(temp[i] + " ") * 2 < maxWidth) {
				// g.drawString(((width+g.getFont().getWidth(temp[i]+ " ")) +
				// " : " + maxWidth), 220, i* 15);
				width += g.getFont().getWidth(temp[i] + " ");
				product += temp[i];
				if (temp[i].contains("\n")) {
					width = 0;
				} else {
					product += " ";
				}
				// System.out.println(width);
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
	 * Get the info of this SquareItem.
	 * 
	 * @return info, the info of this object.
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Get the name of this SquareItem.
	 * 
	 * @return name, the name of this object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A method that returns a value corresponding with this creature's creature
	 * type.
	 * 
	 * @see gui.sample.Sample
	 */
	public abstract String getType();

	/**
	 * Get the image reference of this SquareItem.
	 * 
	 * @return the resource reference of the image of this object.
	 */
	public String getRef() {
		return image.getResourceReference();
	}

	/**
	 * Draws this objects text info at the point specified formatted to fit the
	 * specified width.
	 * 
	 * @param g
	 *            the current graphics context.
	 * @param x
	 *            the x position to draw this string at.
	 * @param y
	 *            the y position to draw this string at.
	 * @param width
	 *            the maximum width the drawn string may occupy.
	 */
	public void drawInfo(Graphics g, int x, int y, int width) {
		String temp = name + "\n";
		temp += format(g, info, width);
		g.drawString(temp, x, y);

		// return temp.split("\n").length;
	}
}
