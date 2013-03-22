package square;

import image.Drawable;
import image.ImageStore;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * The intent of this class is to contain the 2 dimensional
 * array of squares to use for drawing and interaction.
 * @author Niklas L
 *
 */
public class Grid implements Drawable {
	/**
	 * The 2 dimensional array that stores the Squares.
	 */
	private Square[][] squares;
	private static Grid grid;
	
	private int baseX = 0;
	private int baseY = 0;
	
	private Grid(){
		squares  = new Square[50][50];
		fillTiles();
	}
	
	public static Grid get(){
		if(grid == null){
			grid = new Grid();
		}
		return grid;
	}
	/**
	 * Draw the tiles that are present on the screen onto the screen.
	 */
	public void draw(Graphics g){
		for (int x = 0 - baseX/Square.SQUARE_DIMENSION; x < squares.length && x*Square.SQUARE_DIMENSION+baseX < 1200; x++) {
			for (int y = 0 - baseY/Square.SQUARE_DIMENSION; y < squares[x].length && y*Square.SQUARE_DIMENSION+baseY < 1200; y++) {
				squares[x][y].draw(g, baseX+Square.SQUARE_DIMENSION*x, baseY+Square.SQUARE_DIMENSION*y);
			}
		}
	}
	
	public void fillTiles(){
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[x].length; y++) {
				squares[x][y] = new Square(ImageStore.TILE_PLAIN);
			}
		}
	}
	
	public void update(Input input){
		
	}
	
	/**
	 * set the current grid bounds by number of tiles, then
	 * centers the viewpoint to the exact center of the new
	 * grid.
	 * @param xT the number of tiles in width
	 * @param yT the number of tiles in height
	 * @param gc the game container
	 */
	public void setGridBounds(int xT, int yT, GameContainer gc){
		squares = new Square[xT][yT];
		fillTiles();
		baseX = (xT*Square.SQUARE_DIMENSION)/2 + gc.getWidth()/2;
		baseY = (yT*Square.SQUARE_DIMENSION)/2 - gc.getHeight()/2;
	}
	
}
