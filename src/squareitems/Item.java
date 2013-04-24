package squareitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * This object represents a single item and
 * its primary function is to be called when
 * specific loot information is required.
 * 
 * @author Niklas L
 * @see squareitems.ItemPool
 * @see squareItems.LootPile
 *
 */
public class Item extends SquareItem{

	public Item(String name, Image image, String info) {
		super(name, image, info);
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		image.draw(x, y);
	}

	@Override
	public void put(Placeable placeable) {
		// TODO Auto-generated method stub
		
	}

}
