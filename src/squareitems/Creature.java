package squareitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import image.DrawableXY;

/**
 * Since this application is only designed to design a dungeon we don't need to
 * have them moving (automatically atleast), so this object is simply an image
 * with a character sheet.
 * 
 * @author Niklas L
 * @see square.Square
 * 
 */
public class Creature implements DrawableXY, Placeable {
	private Image image;
	private String info = "Default String";
	private String name;

	public Creature(String name, Image image, String info) {
		this.image = image;
		this.info = info;
		this.name = name;
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void put(Placeable placeable) {
		// TODO Auto-generated method stub

	}

	/**
	 * Formats the string to split at given bounds
	 * 
	 * @param g
	 * @param string
	 * @return
	 */
	private String format(Graphics g, String string, int maxWidth) {
		String[] temp = string.split(" ");
		int width = 0;
		int index = 0;
		String product = "";
		boolean running = true;
		while (running) {
			while (g.getFont().getWidth(temp[index]) + width > maxWidth) {
				if(temp[index].contains("\n")){
					width = 0;
				}
				product += temp[index];
				index++;
			}
			if (index >= temp.length) {
				return product;
			}
			product += "\n";
			width = 0;
		}

		return "";
	}

	public int drawInfo(Graphics g, int x1, int y1, int textRow) {

		g.drawString(format(g, info, 300), x1, y1);

		return 0;
	}

}
