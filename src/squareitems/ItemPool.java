package squareitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * This class reads from an item table file and
 * stores them here. These items can be accessed
 * by name and will reference an Item object.
 * <p>
 * Item table format:<br />
 * ITEM_NAME; IMAGE_REF; ITEM_DESC;
 * </p>
 * 
 * @author Niklas L
 * @see squareitems.Item
 * @see squareitems.LootPile
 *
 */
public class ItemPool extends SquareItem{

	public ItemPool(String name, Image image, String info) {
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
