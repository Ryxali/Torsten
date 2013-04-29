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
	 * @param name
	 * @param image
	 * @param info
	 */
	public Creature(String name, Image image, String info) {
		super(name, image, info);
	}
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
	
	private static Image getImg(String ref){
		try{
			return new Image(ref);
		}catch(Exception e){
			
		}
		return null;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return Sample.TYPE_CREATURE;
	}

	

}
