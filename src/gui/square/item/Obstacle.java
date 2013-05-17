package gui.square.item;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DrawableXY;

import gui.sample.Sample;
import gui.square.Square;

/**
 * This object represents any form of obstacle on the battle- field; be it a
 * terrain modifier turning the tile to difficult terrain, or a door barring the
 * way.
 * 
 * @author Niklas L
 * 
 */
public class Obstacle extends SquareItem {
	/**
	 * Constructs a new Obstacle with the name, image and info specified.
	 * 
	 * @param name
	 *            the name of the Obstacle
	 * @param image
	 *            the image of the Obstacle
	 * @param info
	 *            the info of the Obstacle
	 */
	public Obstacle(String name, Image image, String info) {
		super(name, image, info);
	}

	/**
	 * Constructs a new Obstacle with the name, image and info specified.
	 * 
	 * @param name
	 *            the name of the Obstacle.
	 * @param imgRef
	 *            the image reference of the Obstacle.
	 * @param info
	 *            the info of the Obstacle.
	 */
	public Obstacle(String name, String imgRef, String info) {
		super(name, imgRef, info);
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		image.draw(x, y);
	}

	@Override
	public String getType() {
		return Sample.TYPE_OBSTACLE;
	}

}
