package core.state;

import java.util.ArrayList;

import gui.sample.PaletteStore;
import gui.sample.Sample;
import gui.square.Grid;
import gui.square.item.Placeable;
import gui.tool.Toolbar;
import gui.tool.Toolbars;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Main;
import core.MouseInput;
import core.button.Button;
import core.button.GButton;
import core.file.FileReader;
import core.file.FileSaver;
import core.file.UserFileReader;
import core.image.DefaultImage;
/**
 * The state for creating worlds
 * @author Niklas Lindblad
 *
 */
public class BuildState extends BasicState {
	/**
	 * the placeable object the user is currently holding.
	 */
	private Placeable curPlaceable;

	/**
	 * A list of advanced Edits screen.
	 * @see gui.AdvancedEdit
	 */
	private ArrayList<Thread> advEdits = new ArrayList<Thread>();
	/**
	 * The current screen width
	 */
	private int width = 800;
	/**
	 * The current screen height
	 */
	private int height = 600;
	/**
	 * Keeps track whether the screen has changed size lately or not
	 */
	private boolean screenSizeChange = false;

	// private GButton saveB = new GButton(10, 10);
	// private GButton loadB = new GButton(110, 10);
	/**
	 * Renders the content onto the screen
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		boolean doRender = false;
		g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 100,
				100);
		Grid.get().draw(g, width, height, gc.getInput());
		PaletteStore.get().draw(g, width, height, gc.getInput());
		if (curPlaceable != null) {
			curPlaceable.draw(g, gc.getInput().getMouseX(), gc.getInput()
					.getMouseY());
		}
		Toolbars.draw(g, width, height, gc.getInput());
		// saveB.draw(g);
		// loadB.draw(g);
	}

	public void addWindow(Thread t) {
		advEdits.add(t);
	}
	/**
	 * Checks the Grid, Toolbars and Palettes for changes.
	 * @param gc the GameContainer
	 * @param sbg the StateBasedGame
	 * @param delta the time that passed since last loop
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if(screenSizeChange){
			Main.setBounds(width, height);
			screenSizeChange = false;
		}
		// gc.getInput().setScale((float)zoom, (float)zoom);
		PaletteStore.get().update(gc.getInput());
		curPlaceable = getCurrentPlaceable(curPlaceable);
				
				

		if (gc.getInput().isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			curPlaceable = null;
		}
		Grid.get().update(gc.getInput(), curPlaceable, width, height, advEdits);

		//Toolbars.update(gc.getInput());
	}
	/**
	 * Check for a new Placeable object
	 * @param p the current placeable object
	 * @return null, a new placeable object, or the previous object if no change has occured.
	 */
	private Placeable getCurrentPlaceable(Placeable p){
		p = PaletteStore.get().getActivePalette()
		.getClickedSample(p);
		p = Toolbars.getCurrentTool(p);
		return p;
	}
	/**
	 * Get the current placeable object
	 * @return curPlaceable, the current placeable object.
	 */
	public Placeable getCurrentPlaceable() {
		return curPlaceable;
	}
	/**
	 * Sets a new window width and height for the game.
	 * @param width the new screen width.
	 * @param height the new screen height.
	 */
	public void setBounds(int width, int height){
		screenSizeChange = true;
		this.width = width;
		this.height = height;
	}
	/**
	 * Fetch the id of this state.
	 */
	@Override
	public int getID() {

		return StateList.BUILD.getID();
	}

}
