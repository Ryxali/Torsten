package gui.square;

import java.util.ArrayList;

import gui.AdvancedEdit;
import gui.HeldItem;
import gui.Tooltip;
import gui.sample.Palette;
import gui.sample.PaletteStore;
import gui.sample.Sample;
import gui.square.item.Placeable;
import gui.tool.DeleteTool;
import gui.tool.Tool;
import gui.tool.Toolbar;
import gui.tool.Toolbars;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.file.Convention;
import core.image.Drawable;
import core.image.DefaultImage;

/**
 * The intent of this class is to contain the 2 dimensional array of squares to
 * use for drawing and interaction.
 * 
 * @author Niklas L
 * @see gui.square.Square
 * @see gui.sample.Sample
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
	 * The x position on the grid that is stored when the user is dragging the
	 * mouse
	 */
	private int mouseHoldX = 0;
	/**
	 * The y position on the grid that is stored when the user is dragging the
	 * mouse
	 */
	private int mouseHoldY = 0;
	/**
	 * Remembers whether we are currently dragging the grid or not.
	 */
	private boolean dragging = false;

	/**
	 * Creates a 50x50 grid filled with plain tiles.
	 */
	private Grid() {
		squares = new Square[50][50];
		fillTiles();
	}

	/**
	 * returns the current grid, creates a new empty one should one not already
	 * exist.
	 * 
	 * @return the current grid
	 */
	public static Grid get() {
		if (grid == null) {
			grid = new Grid();
		}
		return grid;
	}

	/**
	 * Draw the tiles that are present on the screen onto the screen.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @param input
	 *            the current user input
	 */
	public void draw(Graphics g, int screenWidth, int screenHeight, Input input) {
		// determineSquaresToDraw(g, screenWidth, screenHeight, input);
		if(dragging){
			g.fillRect(0, 0, screenWidth, screenHeight);
		}
		try {
			drawRows(g, screenWidth, screenHeight, input);
			squares[(input.getMouseX() - baseX) / Square.SQUARE_DIMENSION][(input
					.getMouseY() - baseY) / Square.SQUARE_DIMENSION]
					.drawTooltip(g, screenWidth, screenHeight, input);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	private void determineSquaresToDraw(Graphics g, int screenWidth,
			int screenHeight, Input input) {
		for (int x = (input.getMouseX() + baseX) / Square.SQUARE_DIMENSION - 2; x < (input
				.getMouseX() + baseX) / Square.SQUARE_DIMENSION + 1; x++) {
			for (int y = (input.getMouseY() + baseY) / Square.SQUARE_DIMENSION
					- 2; y < (input.getMouseY() + baseY)
					/ Square.SQUARE_DIMENSION + 1; y++) {
				try {
					squares[x][y].setShouldRender(true);
				} catch (ArrayIndexOutOfBoundsException ex) {

				}
			}
		}
	}

	/**
	 * Draw the Grid's rows onto the screen
	 * 
	 * @param g
	 *            the current graphics context
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @param input
	 *            the current user input
	 */
	private void drawRows(Graphics g, int screenWidth, int screenHeight,
			Input input) {
		for (int x = getDrawIndexX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < screenWidth; x++) {
			// g.setColor(Color.white);
			drawSquares(g, x, screenHeight, input);

			// System.out.println(x + " x " + baseX);
		}
	}

	/**
	 * Draw the squares of a row onto the screen
	 * 
	 * @param g
	 *            the current graphics context
	 * @param x
	 *            the row to draw
	 * @param screenHeight
	 *            the current screen height
	 * @param input
	 *            the current user input
	 */
	private void drawSquares(Graphics g, int x, int screenHeight, Input input) {
		for (int y = getDrawIndexY(); y < squares[x].length
				&& y * Square.SQUARE_DIMENSION + baseY < screenHeight; y++) {
			// if(baseX != 0 || baseY != 0){
			squares[x][y].setShouldRender(dragging
					|| squares[x][y].shouldRender());
			// }
			squares[x][y].draw(g, baseX, baseY, input);
			// System.out.println(y + " y " + baseY);
		}
	}

	public void forceRenderNext() {
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[x].length; y++) {
				squares[x][y].setShouldRender(true);
			}
		}
	}

	/**
	 * This method will fill the 2d array of squares with plain empty squares.
	 */
	public void fillTiles() {
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[x].length; y++) {
				squares[x][y] = new Square(DefaultImage.TILE_PLAIN,
						+Square.SQUARE_DIMENSION * x, +Square.SQUARE_DIMENSION
								* y);
			}
		}
	}

	/**
	 * Checks if the grid has been interracted by user input.
	 * 
	 * @param input
	 *            the current user input
	 * @param heldItem
	 *            the current sample the user is wielding
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @param editWins
	 *            the active advanced editor windows
	 */
	public void update(Input input, HeldItem heldItem, int screenWidth,
			int screenHeight, ArrayList<Thread> editWins) {
		try {
			/*
			 * input.getMouseX() > Palette.X_POS || input.getMouseY() >
			 * screenWidth-Tooltip.HEIGHT)
			 */
			checkSquareRenderNeccessity(heldItem);
			if (mouseOccupied(screenWidth, screenHeight, input)) {
				resetSquareStates(screenWidth, screenHeight);
				return;
			}

			if (isDragging(input)) {
				drag(input);
			}
			checkSquareStates(screenWidth, screenHeight, input);
			checkSquareInterraction(input, heldItem, editWins);
			
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	/**
	 * Checks whether the mouse is already occupied at Toolbars, Tooltips or the
	 * PaletteStore.
	 * 
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen Height
	 * @param input
	 *            the current user input
	 * @return true if the mouse is within the bounds of any Tooltbar, Tooltip
	 *         or PaletteStore.
	 */
	private boolean mouseOccupied(int screenWidth, int screenHeight, Input input) {
		if (Toolbars.contains(input.getMouseX(), input.getMouseY(),
				screenWidth, screenHeight)) {
			return true;
		}
		if (PaletteStore.get().contains(input.getMouseX(), input.getMouseY(),
				screenWidth, screenHeight)) {
			return true;
		}
		if (Tooltip.get().contains(input.getMouseX(), input.getMouseY(),
				screenWidth, screenHeight)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether we're currently dragging or not
	 * 
	 * @param input
	 *            the current user input
	 * @return true if the mouse is both pressed down and moving
	 */
	private boolean isDragging(Input input) {
		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)
				&& input.isKeyDown(Input.KEY_LSHIFT) && !dragging) {
			dragging = true;
			setMouseHoldPos(input.getMouseX(), input.getMouseY());
		} else if (input.isMouseButtonDown(Input.MOUSE_MIDDLE_BUTTON)
				&& !dragging) {
			dragging = true;
			setMouseHoldPos(input.getMouseX(), input.getMouseY());
			// System.out.println(input.getMouseX());
		} else if ((!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) || !input
				.isKeyDown(Input.KEY_LSHIFT))
				&& !input.isMouseButtonDown(Input.MOUSE_MIDDLE_BUTTON)) {
			dragging = false;
		}
		return dragging;
	}

	/**
	 * sets the position where the mouse was last held before dragging
	 * 
	 * @param x
	 *            the x position on the screen
	 * @param y
	 *            the y position on the screen
	 */
	private void setMouseHoldPos(int x, int y) {
		mouseHoldX = x - baseX;
		mouseHoldY = y - baseY;
	}

	/**
	 * A method called when the user is dragging the mouse that will calculate
	 * how far the grid is supposed to move.
	 * 
	 * @param input
	 *            the current user input.
	 */
	private void drag(Input input) {
		baseX = -(mouseHoldX - input.getMouseX());
		baseY = -(mouseHoldY - input.getMouseY());
	}

	/**
	 * Sets all the squares within the window boundaries' button states in this
	 * grid to Button.IDLE
	 * 
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 */
	private void resetSquareStates(int screenWidth, int screenHeight) {
		for (int x = getDrawIndexX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < screenWidth; x++) {
			for (int y = getDrawIndexY(); y < squares[x].length
					&& y * Square.SQUARE_DIMENSION + baseY < screenHeight; y++) {
				squares[x][y].setState(Button.STATE_IDLE);
			}
		}
	}

	/**
	 * fetch the x index value of the squares to draw from
	 * 
	 * @return an index value corresponding with the leftmost square column to
	 *         draw.
	 */
	private int getDrawIndexX() {
		if (-baseX < 0) {
			return 0;
		}
		return (-baseX / Square.SQUARE_DIMENSION);
	}

	/**
	 * fetch the y index value of the squares to draw from
	 * 
	 * @return an index value corresponding with the topmost square column to
	 *         draw.
	 */
	private int getDrawIndexY() {
		if (-baseY < 0) {
			return 0;
		}
		return (-baseY / Square.SQUARE_DIMENSION);
	}

	/**
	 * checks all the squares within the screen bounds for state changes.
	 * 
	 * @param screenWidth
	 *            the current screen width
	 * @param screenHeight
	 *            the current screen height
	 * @param input
	 *            the current user input
	 */
	private void checkSquareStates(int screenWidth, int screenHeight,
			Input input) {
		for (int x = getDrawIndexX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < screenWidth; x++) {
			if (x < 0)
				x = 0;
			for (int y = getDrawIndexY(); y < squares[x].length
					&& y * Square.SQUARE_DIMENSION + baseY < screenHeight; y++) {
				if (y < 0)
					y = 0;
				squares[x][y].buttonStateCheck(baseX, baseY, input);

				// if(squares[x][y].hasBeenClicked() ==
				// Button.PRESSED_TRUE)squares[x][y].put(sample);
			}
		}
	}

	/**
	 * Check the square the mouse is currently hovering over for any
	 * interraction.
	 * 
	 * @param input
	 *            the current user input.
	 * @param heldItem
	 *            the currently held placeable object
	 * @param editWins
	 *            the list of AdvancedEdit windows currently active
	 */
	private void checkSquareInterraction(Input input, HeldItem heldItem,
			ArrayList<Thread> editWins) {
		int squareX = (input.getMouseX() - baseX) / Square.SQUARE_DIMENSION;
		int squareY = (input.getMouseY() - baseY) / Square.SQUARE_DIMENSION;
		if (squares[squareX][squareY].hasBeenClicked() == Button.PRESSED_TRUE) {
			if (heldItem == null && input.isKeyDown(Input.KEY_LALT)) {
				editWins.add(AdvancedEdit.getNew(squares[squareX][squareY]));
				editWins.get(editWins.size() - 1).start();
			}
			checkPlaceableAction(heldItem, squares[squareX][squareY]);
			/*
			 * squares[(input.getMouseX() - baseX) /
			 * Square.SQUARE_DIMENSION][(input .getMouseY() - baseY) /
			 * Square.SQUARE_DIMENSION] .put(sample);
			 */
		}
		/*for (int x = -2; x < 3; x++) {
			for (int y = -2; y < 3; y++) {
				try {
					squares[squareX - x][squareY - y].setShouldRender(true);
				} catch (ArrayIndexOutOfBoundsException ex) {

				}
			}
		}*/
		
	}
	/**
	 * This method will check if the held item has interfered with visible squares and if they need a rerender.
	 * @param heldItem the currently held item.
	 */
	private void checkSquareRenderNeccessity(HeldItem heldItem){
		if(heldItem.getItem() == null){
			return;
		}
		for (int x = -2; x < 3; x++) {
			for (int y = -2; y < 3; y++) {
				try {
					squares[(heldItem.getLastX()-baseX)/Square.SQUARE_DIMENSION - x][(heldItem.getLastY()-baseY)/Square.SQUARE_DIMENSION - y].setShouldRender(true);
				} catch (ArrayIndexOutOfBoundsException ex) {

				}
			}
		}
	}

	/**
	 * Called when we want to use a placeable object (if any) on a square.
	 * 
	 * @param heldItem
	 *            the current placeable object.
	 * @param square
	 *            the square to use it on.
	 */
	private void checkPlaceableAction(HeldItem heldItem, Square square) {
		if (heldItem == null) {
			return;
		}
		heldItem.onUse(square);
		/*
		 * if(placeable instanceof Sample){ System.out.println();
		 * square.put(((Sample)placeable).getSquareItem()); return; }
		 * if(placeable instanceof Tool){ ((Tool)placeable).onUse(square); }
		 */
	}

	/**
	 * set the current grid bounds by number of tiles, then centers the
	 * viewpoint to the exact center of the new grid.
	 * 
	 * @param xT
	 *            the number of tiles in width
	 * @param yT
	 *            the number of tiles in height
	 * @param gc
	 *            the game container
	 */
	public void setGridBounds(int xT, int yT) {
		squares = new Square[xT][yT];
		fillTiles();
		baseX = -((xT * Square.SQUARE_DIMENSION) / 2);
		baseY = -((yT * Square.SQUARE_DIMENSION) / 2);
	}

	/**
	 * Fetch the number of rows the grid is currently composed of.
	 * 
	 * @return squares.length the number of rows in the squares array
	 */
	public int rows() {
		return squares.length;
	}

	/**
	 * This method will build a string containing the save file printable info
	 * of selected row.
	 * 
	 * @param index
	 *            the row to build
	 * @return a string line containing all needed save file information for
	 *         this row.
	 */
	public String toPrintable(int index) {
		String s = "";
		for (int i = 0; i < squares[index].length; i++) {
			s += squares[index][i].toPrintable();
		}
		return s;
	}

	/**
	 * replaces the Square at the selected indexes with a new square based on
	 * the savefile information provided.
	 * 
	 * @param string
	 *            the save file information representing a square.
	 * @param rowIndex
	 *            the square to replace in the x line
	 * @param colIndex
	 *            the square to replace in the y line
	 */
	public void setSquare(String string, int rowIndex, int colIndex) {
		String[] squareInfo = string.split(Convention.LAYER_1);
		// System.out.println("___________" + string);
		squares[rowIndex][colIndex] = new Square(squareInfo, rowIndex * 64,
				colIndex * 64);
	}

	/**
	 * Fetches the length of the first row in the squares Array.
	 * 
	 * @return squares[0].length, the length of the first row.
	 */
	public int getCols() {
		return squares[0].length;
	}

	/**
	 * Get the base x value of this grid.
	 * 
	 * @return baseX, the base x position of this grid.
	 */
	public int getBaseX() {
		return baseX;
	}

	/**
	 * Get the base y value of this grid.
	 * 
	 * @return baseY, the base y position of this grid.
	 */
	public int getBaseY() {
		return baseY;
	}

}
