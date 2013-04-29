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
import core.image.ImageStore;

public class BuildState extends BasicState {

	private Placeable curPlaceable;

	private Toolbar toolbar = new Toolbar("Utilities", 0, 0, 800, 64);

	private ArrayList<Thread> advEdits = new ArrayList<Thread>();
	
	private int width = 800;
	private int height = 600;
	private boolean screenSizeChange = false;

	// private GButton saveB = new GButton(10, 10);
	// private GButton loadB = new GButton(110, 10);

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 100,
				100);
		Grid.get().draw(g, width, height, gc.getInput());
		PaletteStore.get().draw(g, width, height, gc.getInput());
		if (curPlaceable != null) {
			curPlaceable.draw(g, gc.getInput().getMouseX() - 64, gc.getInput()
					.getMouseY() - 64);
		}
		Toolbars.draw(g, width, height, gc.getInput());
		// saveB.draw(g);
		// loadB.draw(g);
	}

	public void addWindow(Thread t) {
		advEdits.add(t);
	}

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
		Grid.get().update(gc.getInput(), curPlaceable, height, advEdits);

		Toolbars.update(gc.getInput());
		// saveB.buttonStateCheck(gc.getInput());
		// loadB.buttonStateCheck(gc.getInput());
		/*
		 * if(gc.getInput().isKeyDown(Input.KEY_S) &&
		 * gc.getInput().isKeyDown(Input.KEY_LCONTROL)){
		 * 
		 * System.out.println("HWWWAR"); gc.getInput().removeAllListeners();
		 * FileSaver.saveAsDialogue(); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }else if(gc.getInput().isKeyDown(Input.KEY_L)
		 * && gc.getInput().isKeyDown(Input.KEY_LCONTROL)){
		 * System.out.println("Hwat");
		 * 
		 * FileReader.loadDialogue(gc);
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
	}
	private Placeable getCurrentPlaceable(Placeable p){
		p = PaletteStore.get().getActivePalette()
		.getClickedSample(p);
		p = Toolbars.getCurrentTool(p);
		return p;
	}
	public Placeable getCurrentSample() {
		return curPlaceable;
	}
	
	public void setBounds(int width, int height){
		screenSizeChange = true;
		this.width = width;
		this.height = height;
	}

	@Override
	public int getID() {

		return StateList.BUILD.getID();
	}

}
