package squareitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import image.DrawableXY;

/**
 * Objects from this pile represents all the loot on
 * a single given tile. The neccessity for this being
 * that several amounts of items can be present on a
 * single square. In practical terms this is very
 * much the representation of a dungeon chest or
 * pile of gold.
 * @author Niklas L
 * @see squareitems.Item
 * @see square.Square
 *
 */
public class LootPile extends SquareItem{

	public LootPile(String name, Image image, String info) {
		super(name, image, info);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void put(Placeable placeable) {
		// TODO Auto-generated method stub
		
	}

}
