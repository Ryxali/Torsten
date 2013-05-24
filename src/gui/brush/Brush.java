package gui.brush;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import gui.square.Grid;
import gui.square.Square;
import gui.square.item.Placeable;
import core.button.GButton;
/**
 * A Brush used to determine the size of the area of selection in the grid by the user.
 * @author Niklas L
 * @see BrushInfo
 * @see Brushes
 */
public class Brush extends GButton {
	/**
	 * The BrushInfo of this brush.
	 */
	private final BrushInfo bInfo;
	/**
	 * Constructs a new brush with the given size and shape.
	 * @param brushSize the size of this brush.
	 * @param brushShape the shape of this brush.
	 * @see BrushInfo
	 */
	public Brush(int brushSize, boolean brushShape){
		super();
		bInfo = new BrushInfo(brushSize, brushShape);
	}
	/**
	 * Draws the button of this brush.
	 */
	@Override
	public void draw(Graphics g, int x, int y, int width, int height,
			Input input) {
		super.draw(g, x, y, width, height, input);
	}
	/**
	 * A designated action for when this brush's button has been clicked.
	 */
	@Override
	public void onClick(Input input) {
		super.onClick(input);
		Grid.get().setBrush(this);
	}
	/**
	 * Get the specific details, such as size and shape, of this brush.
	 * @return bInfo, the details of this brush.
	 */
	public BrushInfo getBrushDetails(){
		return bInfo;
	}
	/**
	 * Checks whether the given area intersects with this brush.
	 * @param x the x position of the area to check.
	 * @param y the y position of the area to check.
	 * @param width the width of the area.
	 * @param height the height of the area.
	 * @param input the current user input.
	 * @return true, if the area provided intersects with this brush.
	 */
	public boolean intersects(int x, int y, int width, int height, Input input){
		Rectangle temp = new Rectangle(x, y, width, height);
		return getBrushDimension(input.getMouseX(), input.getMouseY()).intersects(temp);
	}
	/**
	 * Returns a shape representing this brush positioned at given location.
	 * @param x the brush central x position.
	 * @param y the brush central y position.
	 * @return a Shape representing this brush at the given location.
	 */
	public Shape getBrushDimension(int x, int y) {
		if(bInfo.getShape() == BrushInfo.SHAPE_SQUARE){
			return new Rectangle(x-bInfo.getSize()*Square.SQUARE_DIMENSION/2, y-bInfo.getSize()*Square.SQUARE_DIMENSION/2, bInfo.getSize()*Square.SQUARE_DIMENSION, bInfo.getSize()*Square.SQUARE_DIMENSION);
		}else{
			return new Circle(x, y, bInfo.getSize()*Square.SQUARE_DIMENSION/2);
		}
		
	}
}
