package gui.sample;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import core.button.StandardButton;
import core.file.Convention;
import core.image.DefaultImage;
import core.image.ImageStore;

import gui.Tooltip;
import gui.square.Square;
import gui.square.item.Creature;
import gui.square.item.Item;
import gui.square.item.Obstacle;
import gui.square.item.Placeable;
import gui.square.item.SquareItem;

/**
 * A Sample is used to act as a display case for a Placeable object. A Sample
 * always belongs in a Palette.
 * 
 * @author Niklas L
 * @see gui.sample.Palette
 * @see gui.square.item.Placeable
 */
public class Sample extends StandardButton implements Placeable {
	private SquareItem sampleItem;
	/**
	 * The image of this sample's placeable object
	 */
	private Image slotImg;
	/**
	 * The matching value for the squareItem type for creatures.
	 */
	public static final String TYPE_CREATURE = "creature";
	/**
	 * The matching value for the squareItem type for items.
	 */
	public static final String TYPE_ITEM = "item";
	/**
	 * The matching value for the squareItem type for obstacles.
	 */
	public static final String TYPE_OBSTACLE = "obstacle";

	/**
	 * Creates a new Sample with a placeable object
	 * 
	 * @param x
	 *            the x position of this sample
	 * @param y
	 *            the y position of this sample
	 * @param name
	 *            the name of the placeable object
	 * @param imageRef
	 *            the image reference for the placeable object
	 * @param type
	 *            the type of the placeable object
	 * @param info
	 *            the info message of the placeable object
	 */
	public Sample(String name, String imageRef, String type, String info) {
		super(DefaultImage.SAMPLE_IDLE, DefaultImage.SAMPLE_HOVER,
				DefaultImage.SAMPLE_PRESSED);
		slotImg = ImageStore.get().getImage(imageRef).getScaledCopy(64, 64);
		
		setSquareItem(name, imageRef, type, info);
	}

	/**
	 * Creates a squareItem and connects it with this sample.
	 * 
	 * @param name
	 *            the name of the item.
	 * @param imageRef
	 *            the image reference of the item.
	 * @param type
	 *            the type of the item.
	 * @param info
	 *            the info of the item.
	 */
	private void setSquareItem(String name, String imageRef, String type,
			String info) {
		if (type.toLowerCase().equals(TYPE_CREATURE.toLowerCase())) {
			sampleItem = new Creature(name, ImageStore.get().getImage(imageRef)
					.getScaledCopy(64, 64), info);
			System.out.println("CREATURE");
		}
		if (type.toLowerCase().equals(TYPE_ITEM.toLowerCase())) {
			sampleItem = new Item(name, ImageStore.get().getImage(imageRef)
					.getScaledCopy(64, 64), info);
		}
		if (type.toLowerCase().equals(TYPE_OBSTACLE.toLowerCase())) {
			System.out.println("AYE");
			sampleItem = new Obstacle(name, ImageStore.get().getImage(imageRef)
					.getScaledCopy(64, 64), info);
		}

	}

	/**
	 * Retrieve the placeable object this sample is holding.
	 * 
	 * @return pObject the placeable object
	 * @deprecated placeableobject is no longer used in this manner and so this
	 *             method is not proper to use.
	 */
	public SquareItem getPlaceableObject() {
		return sampleItem;
	}

	/**
	 * Get the square item this sample is representing.
	 * 
	 * @return sampleItem the square item this sample is representing.
	 */
	public SquareItem getSquareItem() {
		return sampleItem;
	}
	/**
	 * Draw this sample on the screen
	 * @param g the current graphics context
	 * @param x the x position to draw this sample at
	 * @param y the y position to draw this sample at
	 * @param screenWidth the current screen width
	 * @param screenHeight the current screen height
	 * @param input the current user input
	 */
	public void draw(Graphics g, int x, int y, int screenWidth,
			int screenHeight, Input input) {
		// g.setColor(Color.lightGray);
		// g.drawRect(x, y, 64, 64);
		slotImg.draw(x, y);
		super.draw(g, x, y, input);
		if (getState() == STATE_HOVER || getState() == STATE_PRESSED) {
			Tooltip.get().draw(g, screenWidth, screenHeight, sampleItem);
		}
	}

	/**
	 * Fetch a printable line of string that is primarily used for saving in
	 * palettes.
	 * 
	 * @return a line of string that can be printed/read in a palette.dat file.
	 * @see core.file.UserFileReader
	 */
	public String getPrintable() {
		return sampleItem.getName() + Convention.LAYER_2 + sampleItem.getRef()
				+ Convention.LAYER_2 + sampleItem.getType()
				+ Convention.LAYER_2 + sampleItem.getInfo()
				+ Convention.LAYER_1;
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		slotImg.draw(x - slotImg.getWidth(), y - slotImg.getHeight());
	}

	/**
	 * Puts this sample's content onto the specified square.
	 */
	@Override
	public void onUse(Square square) {
		square.put(sampleItem);

	}

}
