package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
/**
 * This Tool, when used, will clear squares of SquareItem content.
 * @author Niklas L
 * @see Tool
 * @see gui.square.Square
 */
public class DeleteTool extends Tool{
	/**
	 * Creates a new DeleteTool with the specified title
	 * @param text the text to be displayed on top of the button
	 */
	public DeleteTool(String text) {
		super(text);
	}

	@Override
	public Tool getTool() {
		return this;
	}

	@Override
	public void onUse(Square square) {
		square.clear();
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		g.drawString("DEL", x-g.getFont().getWidth("DEL"), y-g.getFont().getHeight("DEL"));
	}
	
}
