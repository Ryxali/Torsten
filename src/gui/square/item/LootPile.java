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
 * a single given tile. The neccessity for this being
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
	private ArrayList<Item> items = new ArrayList<Item>();
	public LootPile(String name, Image image, String info) {
		super(name, image, info);
	}
	

	@Override
	public void draw(Graphics g, int x, int y) {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).draw(g, x, y);
		}
	}
	public int size(){
		return items.size();
	}
	public Item get(int index){
		return items.get(index);
	}
	public void add(Item sample) {
		items.add(sample);
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
