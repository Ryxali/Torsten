package gui.square.item;

import gui.sample.Sample;
import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * This object represents a single item in the loot pile
 * 
 * @author Niklas L
 * @see gui.square.item.ItemPool
 * @see squareItems.LootPile
 *
 */
public class Item extends SquareItem{
	/**
	 * Creates a new item with name, image and info specified.
	 * @param name the name of the item.
	 * @param image the image of the item.
	 * @param info the info of the item.
	 */
	public Item(String name, Image image, String info) {
		super(name, image, info);
	}
	/**
	 * Creates a new item with name, image (based on reference) and info specified.
	 * @param name the name of the item.
	 * @param imgRef the image reference of the item.
	 * @param info the info of the item.
	 */
	public Item(String name, String imgRef, String info) {
		super(name, imgRef, info);
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		image.draw(x, y);
	}

	@Override
	public String getType() {
		return Sample.TYPE_ITEM;
	}

}
