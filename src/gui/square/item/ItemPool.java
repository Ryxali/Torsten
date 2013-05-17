package gui.square.item;

import gui.sample.Sample;
import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * This class reads from an item table file and stores them here. These items
 * can be accessed by name and will reference an Item object.
 * 
 * @author Niklas L
 * @see gui.square.item.Item
 * @see gui.square.item.LootPile
 * @deprecated the ItemPool is never used
 */
public class ItemPool extends SquareItem {

	public ItemPool(String name, Image image, String info) {
		super(name, image, info);
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		return Sample.TYPE_ITEM;
	}

}
