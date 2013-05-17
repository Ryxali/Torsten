package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.file.FileReader;

/**
 * This tool, when selected, will load a new Grid as specified by a user prompt.
 * 
 * @author Niklas L
 * @see Tool
 * @see gui.square.Grid
 */
public class LoadTool extends Tool {
	/**
	 * Creates a new LoadTool with the specified title
	 * 
	 * @param text
	 *            the text to be displayed on the button of this tool.
	 */
	public LoadTool(String text) {
		super(text);
	}

	@Override
	public Tool getTool() {
		FileReader.loadDialogue();
		return null;
	}

	/**
	 * Won't do anything as this tool is not interactive.
	 */
	@Override
	public void onUse(Square square) {

	}

	/**
	 * Won't do anything as this tool is not interactive.
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
	}

}
