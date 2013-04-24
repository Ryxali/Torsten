package squareitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import image.DrawableXY;

/**
 * This object represents any form of obstacle on the battle-
 * field; be it a terrain modifier turning the tile to 
 * difficult terrain, or a door barring the way.
 * 
 * @author Niklas L
 *
 */
public class Obstacle extends SquareItem{

	public Obstacle(String name, Image image, String info) {
		super(name, image, info);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		image.draw(x, y);
	}

	@Override
	public void put(Placeable placeable) {
		// TODO Auto-generated method stub
		
	}

}
