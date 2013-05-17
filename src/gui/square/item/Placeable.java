package gui.square.item;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.image.DrawableXY;
import core.image.DrawableXYI;
/**
 * This interface represents an Object that can interact with a square.
 * @author Niklas L
 * @see gui.sample.Sample
 * @see gui.tool.Tool
 */
public interface Placeable extends DrawableXY{
	/**
	 * Triggers the designated action when used on a square for this object.
	 * @param square the square to use this object on.
	 */
	public void onUse(Square square);

}
