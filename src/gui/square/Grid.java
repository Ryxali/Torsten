package gui.square;

import java.util.ArrayList;

import gui.AdvancedEdit;
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
import core.image.Drawable;
import core.image.ImageStore;

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

	private int mouseHoldX;
	private int mouseHoldY;
	private boolean dragging = false;

	/**
	 * The y position to base calculations of.
	 */
	private int baseY = 0;

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
	 */
	public void draw(Graphics g, int screenWidth, int screenHeight, Input input) {
		try {
			drawRows(g, input);
			squares[(input.getMouseX() - baseX) / Square.SQUARE_DIMENSION][(input
					.getMouseY() - baseY) / Square.SQUARE_DIMENSION]
					.drawTooltip(g, screenWidth, screenHeight, input);
			g.setColor(Color.lightGray);
			g.drawString(baseX + " " + baseY, 300, 300);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	private void drawRows(Graphics g, Input input) {
		for (int x = getDrawPosX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < 1200; x++) {
			// g.setColor(Color.white);
			drawSquares(g, x, input);

			// System.out.println(x + " x " + baseX);
		}
	}

	private void drawSquares(Graphics g, int x, Input input) {
		for (int y = getDrawPosY(); y < squares[x].length
				&& y * Square.SQUARE_DIMENSION + baseY < 1200; y++) {

			squares[x][y].draw(g, baseX, baseY, input);
			// System.out.println(y + " y " + baseY);
		}
	}

	/**
	 * This method will fill the 2d array of squares with plain empty squares.
	 */
	public void fillTiles() {
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[x].length; y++) {
				squares[x][y] = new Square(ImageStore.TILE_PLAIN,
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
	 * @param sample
	 *            the current sample the user is wielding
	 */
	public void update(Input input, Placeable sample, int screenWidth,
			int screenHeight, ArrayList<Thread> editWins) {
		try {
			/*
			 * input.getMouseX() > Palette.X_POS || input.getMouseY() >
			 * screenWidth-Tooltip.HEIGHT)
			 */
			if (Toolbars.contains(input.getMouseX(), input.getMouseY(),
					screenWidth, screenHeight)
					&& PaletteStore.get().contains(input.getMouseX(),
							input.getMouseY(), screenWidth, screenHeight)) {
				// We don't want to do anything with the grid if we're currently
				// interacting with the palettes.
				// Same is true with tooltips.

				resetSquareStates();
				return;
			}

			if (isDragging(input)) {
				drag(input);
			}
			checkSquareStates(input);
			checkSquareInterraction(input, sample, editWins);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

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

	private void setMouseHoldPos(int x, int y) {
		mouseHoldX = x - baseX;
		mouseHoldY = y - baseY;
	}

	private void drag(Input input) {
		baseX = -(mouseHoldX - input.getMouseX());
		baseY = -(mouseHoldY - input.getMouseY());
	}

	private void resetSquareStates() {
		for (int x = getDrawPosX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < 1200; x++) {
			for (int y = getDrawPosY(); y < squares[x].length
					&& y * Square.SQUARE_DIMENSION + baseY < 1200; y++) {
				squares[x][y].setState(Button.STATE_IDLE);
			}
		}
	}

	private int getDrawPosX() {
		if (-baseX < 0) {
			return 0;
		}
		return (-baseX / Square.SQUARE_DIMENSION);
	}

	private int getDrawPosY() {
		if (-baseY < 0) {
			return 0;
		}
		return (-baseY / Square.SQUARE_DIMENSION);
	}

	private void checkSquareStates(Input input) {
		for (int x = getDrawPosX(); x < squares.length
				&& x * Square.SQUARE_DIMENSION + baseX < 1200; x++) {
			if (x < 0)
				x = 0;
			for (int y = getDrawPosY(); y < squares[x].length
					&& y * Square.SQUARE_DIMENSION + baseY < 1200; y++) {
				if (y < 0)
					y = 0;
				squares[x][y].buttonStateCheck(baseX, baseY, input);

				// if(squares[x][y].hasBeenClicked() ==
				// Button.PRESSED_TRUE)squares[x][y].put(sample);
			}
		}
	}

	private void checkSquareInterraction(Input input, Placeable placeable,
			ArrayList<Thread> editWins) {
		if (squares[(input.getMouseX() - baseX) / Square.SQUARE_DIMENSION][(input
				.getMouseY() - baseY) / Square.SQUARE_DIMENSION]
					.hasBeenClicked() == Button.PRESSED_TRUE) {
			if (placeable == null && input.isKeyDown(Input.KEY_LALT)) {
				editWins.add(AdvancedEdit.getNew(squares[(input.getMouseX() - baseX)
						/ Square.SQUARE_DIMENSION][(input.getMouseY() - baseY)
						/ Square.SQUARE_DIMENSION]));
				editWins.get(editWins.size() - 1).start();
			}
			checkPlaceableAction(placeable, squares[(input.getMouseX() - baseX)
					/ Square.SQUARE_DIMENSION][(input.getMouseY() - baseY)
					/ Square.SQUARE_DIMENSION]);
			/*
			 * squares[(input.getMouseX() - baseX) /
			 * Square.SQUARE_DIMENSION][(input .getMouseY() - baseY) /
			 * Square.SQUARE_DIMENSION] .put(sample);
			 */
		}
	}

	private void checkPlaceableAction(Placeable placeable, Square square) {
		if (placeable == null) {
			return;
		}
		placeable.onUse(square);
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

	public int rows() {
		return squares.length;
	}

	public String concatRow(int index) {
		String s = "";
		for (int i = 0; i < squares[index].length; i++) {
			s += squares[index][i].concatInfo();
		}
		return s;
	}

	public void setSquare(String string, int rowIndex, int colIndex) {
		String[] squareInfo = string.split(": ");
		// System.out.println("___________" + string);
		System.out.println(rowIndex + " x " + colIndex);
		squares[rowIndex][colIndex] = new Square(squareInfo, rowIndex * 64,
				colIndex * 64);
	}

	public int getCols() {
		// TODO Auto-generated method stub
		return squares[0].length;
	}

	public int getBaseX() {
		return baseX;
	}

	public int getBaseY() {
		return baseY;
	}

}
