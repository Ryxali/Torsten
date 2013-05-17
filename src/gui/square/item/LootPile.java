package gui.square.item;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DrawableXY;

import gui.sample.Sample;
import gui.square.Square;

/**
 * Objects from this pile represents all the loot on
 * a single given tile. The necessity for this being
 * that several amounts of items can be present on a
 * single square. In practical terms this is very
 * much the representation of a dungeon chest or
 * pile of gold.
 * @author Niklas L
 * @see gui.square.item.Item
 * @see gui.square.Square
 *
 */
public class LootPile extends SquareItem{
	/**
	 * The items this LootPile is containing.
	 */
	private ArrayList<Item> items;
	/**
	 * Constructs a new LootPile with the name, image and info specified and creates a new empty list
	 * of items it can store.
	 * @param name the name of the LootPile
	 * @param image the image of the LootPile
	 * @param info the info regarding the LootPile
	 */
	public LootPile(String name, Image image, String info) {
		super(name, image, info);
		items = new ArrayList<Item>();
	}
	/**
	 * Constructs a new LootPile with only a name and information regarding it. A LootPile created this way will
	 * display all the loot as though it's simply lying on the ground.
	 * @param name the name of the LootPile
	 * @param info the info of the LootPile
	 */
	public LootPile(String name, String info){
		super(name, (Image)null, info);
	}
	

	@Override
	public void draw(Graphics g, int x, int y) {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).draw(g, x, y);
		}
	}
	/**
	 * Get the number of items currently contained.
	 * @return items.size(), the number of items this LootPile currently contains.
	 */
	public int size(){
		return items.size();
	}
	/**
	 * Get a specific item in the LootPile
	 * @param index the index of the item you want to retrieve.
	 * @return the item at the specified index, if any.
	 */
	public Item get(int index){
		return items.get(index);
	}
	/**
	 * Adds a new item to this LootPile's list of items.
	 * @param item the item to add.
	 */
	public void add(Item item) {
		items.add(item);
		//info = name + "\n";
		info = "";
		for (int i = 0; i < items.size(); i++) {
			info += items.get(i).name + "\n";
			//info += items.get(i).info + "\n";
		}
	}

	@Override
	public String getType() {
		return Sample.TYPE_ITEM;
	}


}
