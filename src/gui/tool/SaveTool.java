package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.file.FileSaver;

/**
 * This Tool, when selected, will save the currently active grid to a file with a name specified by user prompt.
 * @author Niklas L
 *
 */
public class SaveTool extends Tool{
	/**
	 * Creates a new Tool with the specified title
	 * @param text the string to be displayed on top of the button.
	 */
	public SaveTool(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tool getTool() {
		FileSaver.saveAsDialogue();
		return null;
	}

	@Override
	public void onUse(Square square) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
