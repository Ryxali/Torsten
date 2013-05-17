package gui.square.item;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DrawableXY;

import gui.sample.Sample;
import gui.square.Square;

/**
 * Since this application is only designed to design a dungeon we don't need to
 * have them moving (automatically atleast), so this object is simply an image
 * with a character sheet.
 * 
 * @author Niklas L
 * @see gui.square.Square
 * @see gui.sample.Sample
 */
public class Creature extends SquareItem {
	/**
	 * Creates a new creature to exist in either a square or as a sample
	 * piece.
	 * @param name the name of this Creature.
	 * @param image the image representing this creature.
	 * @param info the information associated with this creature.
	 */
	public Creature(String name, Image image, String info) {
		super(name, image, info);
	}
	/**
	 * Creates a new creature using a string as image reference rather than
	 * an actual image.
	 * @param name the name of this Creature.
	 * @param imgRef the path of the image for this Creature.
	 * @param info the information associated with this Creature.
	 */
	public Creature(String name, String imgRef, String info) {
		super(name, imgRef, info);
	}
	/**
	 * Draws this creature onto the screen at the specified point.
	 * @param g the current graphics context
	 * @param x the x position to draw at
	 * @param y the y position to draw at
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		image.draw(x, y);

	}
	
	@Override
	public String getType() {
		return Sample.TYPE_CREATURE;
	}

	

}
