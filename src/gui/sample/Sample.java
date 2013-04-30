package gui.sample;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import core.button.StandardButton;
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
	private byte elementPosX;
	private short elementPosY;
	private SquareItem pObject;
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
	 * @param x the x position of this sample
	 * @param y the y position of this sample
	 * @param name the name of the placeable object
	 * @param imageRef the image reference for the placeable object
	 * @param type the type of the placeable object
	 * @param info the info message of the placeable object
	 */
	public Sample(String name, String imageRef, String type, String info) {
		super(ImageStore.SAMPLE_IDLE, ImageStore.SAMPLE_HOVER,
				ImageStore.SAMPLE_PRESSED);
		try {
			slotImg = new Image(imageRef).getScaledCopy(64, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPlaceableObject(name, imageRef, type, info);
	}

	private void setPlaceableObject(String name, String imageRef, String type,
			String info) {
		//System.out.println("WAT");
		try {
			if (type.toLowerCase().equals(TYPE_CREATURE.toLowerCase())) {
				pObject = new Creature(name, new Image(imageRef).getScaledCopy(64, 64), info);
				System.out.println("CREATURE");
			}
			if (type.toLowerCase().equals(TYPE_ITEM.toLowerCase())) {
				pObject = new Item(name, new Image(imageRef).getScaledCopy(64, 64), info);
			}
			if (type.toLowerCase().equals(TYPE_OBSTACLE.toLowerCase())) {
				pObject = new Obstacle(name, new Image(imageRef).getScaledCopy(64, 64), info);
			}
		} catch (SlickException e) {
		}
	}
	/**
	 * Retrieve the placeable object this sample is holding.
	 * @return pObject the placeable object
	 */
	public SquareItem getPlaceableObject(){
		return pObject;
	}
	
	public SquareItem getSquareItem(){
		return pObject;
	}
	
	public void draw(Graphics g, int x, int y, int screenWidth, int screenHeight, Input input) {
		slotImg.draw(x, y);
		super.draw(g, x, y, input);
		if(getState() == STATE_HOVER || getState() == STATE_PRESSED){
			Tooltip.get().draw(g, screenWidth, screenHeight, pObject);
		}
		super.draw(g, x, y, input);
	}

	public String getPrintable() {
		return pObject.getName() + ", " + pObject.getRef() + ", " + pObject.getType() + ", " + pObject.getInfo()+ "; ";
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		slotImg.draw(x-slotImg.getWidth(), y-slotImg.getHeight());
	}

	@Override
	public void onUse(Square square) {
		square.put(pObject);
		
	}

}
