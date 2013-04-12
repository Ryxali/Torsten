package gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import squareitems.Creature;
import squareitems.Item;
import squareitems.Obstacle;
import squareitems.Placeable;
import image.ImageStore;
import button.StandardButton;

/**
 * A Sample is used to act as a display case for a Placeable object. A Sample
 * always belongs in a Palette.
 * 
 * @author Niklas L
 * @see gui.Palette
 * @see squareitems.Placeable
 */
public class Sample extends StandardButton {
	private byte elementPosX;
	private short elementPosY;
	private Placeable pObject;

	public static final String TYPE_CREATURE = "creature";
	public static final String TYPE_ITEM = "item";
	public static final String TYPE_OBSTACLE = "obstacle";

	public Sample(String name, String imageRef, String type, String info) {
		super(ImageStore.TILE_PLAIN, ImageStore.TILE_PLAIN,
				ImageStore.TILE_PLAIN);
		setPlaceableObject(name, imageRef, type, info);
	}

	private void setPlaceableObject(String name, String imageRef, String type,
			String info) {
		try {
			if (name.toLowerCase() == TYPE_CREATURE) {
				pObject = new Creature(name, new Image(imageRef), info);
			}
			if (name.toLowerCase() == TYPE_ITEM) {
				//pObject = new Item(name, new Image(imageRef), info);
			}
			if (name.toLowerCase() == TYPE_OBSTACLE) {
				//pObject = new Obstacle(name, new Image(imageRef), info);
			}
		} catch (SlickException e) {

		}
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
