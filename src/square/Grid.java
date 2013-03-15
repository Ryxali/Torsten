package square;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 * The intent of this class is to contain the 2 dimensional
 * array of squares to use for drawing and interaction.
 * @author Niklas L
 *
 */
public class Grid {
	/**
	 * The 2 dimensional array that stores the Squares.
	 */
	private short[][] squares = new short[50][50];
	private Grid grid;
	
	private int x = 0;
	private int y = 0;
	
	private Grid(){
		
	}
	
	public Grid get(){
		if(grid == null){
			grid = new Grid();
		}
		return grid;
	}
	/**
	 * Draw the tiles on the screen
	 */
	public void draw(){
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				
			}
		}
	}
	
	public void update(Input input){
		
	}
	
	/**
	 * set the current grid bounds by number of tiles
	 * @param xT the number of tiles in width
	 * @param yT the number of tiles in height
	 */
	public void setGridBounds(int xT, int yT, GameContainer gc){
		squares = new short[xT][yT];
		x = (xT*SquareType.DIMENSION)/2 + gc.getWidth()/2;
		y = (yT*SquareType.DIMENSION)/2 - gc.getHeight()/2;
	}
	
}
