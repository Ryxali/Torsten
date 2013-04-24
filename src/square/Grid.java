package square;

import java.util.ArrayList;

import gui.AdvancedEdit;
import gui.Palette;
import gui.PaletteStore;
import gui.Toolbar;
import gui.Toolbars;
import gui.Tooltip;
import image.Drawable;
import image.ImageStore;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import squareitems.Placeable;

import button.Button;

/**
 * The intent of this class is to contain the 2 dimensional
 * array of squares to use for drawing and interaction.
 * @author Niklas L
 * @see square.Square
 * @see gui.Sample
 */
public class Grid {
	/**
	 * The 2 dimensional array that stores the Squares.
	 */
	private Square[][] squares;
	/**
	 * The grid itself.
	 */
	private static Grid grid;
	/**
	 * The x position to base calculations of.
	 */
	private int baseX = 0;
	/**
	 * The y position to base calculations of.
	 */
	private int baseY = 0;
	/**
	 * Creates a 50x50 grid filled with plain tiles.
	 */
	private Grid(){
		squares  = new Square[50][50];
		fillTiles();
	}
	/**
	 * returns the current grid, creates a new empty one should one not already exist.
	 * @return the current grid
	 */
	public static Grid get(){
		if(grid == null){
			grid = new Grid();
		}
		return grid;
	}
	/**
	 * Draw the tiles that are present on the screen onto the screen.
	 */
	public void draw(Graphics g, Input input){
		for (int x = 0 - baseX/Square.SQUARE_DIMENSION; x < squares.length && x*Square.SQUARE_DIMENSION+baseX < 1200; x++) {
			for (int y = 0 - baseY/Square.SQUARE_DIMENSION; y < squares[x].length && y*Square.SQUARE_DIMENSION+baseY < 1200; y++) {
				squares[x][y].draw(g, baseX, baseY);
			}
		}
		squares[(input.getMouseX()-baseX)/Square.SQUARE_DIMENSION][(input.getMouseY()-baseY)/Square.SQUARE_DIMENSION].drawTooltip(g, input);
	}
	/**
	 * This method will fill the 2d array of squares with plain empty squares.
	 */
	public void fillTiles(){
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[x].length; y++) {
				squares[x][y] = new Square(ImageStore.TILE_PLAIN, baseX+Square.SQUARE_DIMENSION*x, baseY+Square.SQUARE_DIMENSION*y);
			}
		}
	}
	/**
	 * Checks if the grid has been interracted by user input.
	 * @param input the current user input
	 * @param sample the current sample the user is wielding
	 */
	public void update(Input input, Placeable sample, ArrayList<Thread> editWins){
		if(input.getMouseX() > Palette.X_POS || input.getMouseY() > Tooltip.Y_POS){
			//We don't want to do anything with the grid if we're currently interacting with the palettes.
			//Same is true with tooltips.
			for (int x = 0 - baseX/Square.SQUARE_DIMENSION; x < squares.length && x*Square.SQUARE_DIMENSION+baseX < 1200; x++) {
				for (int y = 0 - baseY/Square.SQUARE_DIMENSION; y < squares[x].length && y*Square.SQUARE_DIMENSION+baseY < 1200; y++) {
					squares[x][y].setState(Button.STATE_IDLE);
				}
			}
			return;
		}
		for (int x = 0 - baseX/Square.SQUARE_DIMENSION; x < squares.length && x*Square.SQUARE_DIMENSION+baseX < 1200; x++) {
			for (int y = 0 - baseY/Square.SQUARE_DIMENSION; y < squares[x].length && y*Square.SQUARE_DIMENSION+baseY < 1200; y++) {
				squares[x][y].buttonStateCheck(input);
				
				//if(squares[x][y].hasBeenClicked() == Button.PRESSED_TRUE)squares[x][y].put(sample);
			}
		}
		if(squares[(input.getMouseX()-baseX)/Square.SQUARE_DIMENSION][(input.getMouseY()-baseY)/Square.SQUARE_DIMENSION].hasBeenClicked()==Button.PRESSED_TRUE){
			if(sample == null){
				editWins.add(AdvancedEdit.getNew(squares[(input.getMouseX()-baseX)/Square.SQUARE_DIMENSION][(input.getMouseY()-baseY)/Square.SQUARE_DIMENSION]));
				editWins.get(editWins.size()-1).start();
			}
			squares[(input.getMouseX()-baseX)/Square.SQUARE_DIMENSION][(input.getMouseY()-baseY)/Square.SQUARE_DIMENSION].put(sample);
		}
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
