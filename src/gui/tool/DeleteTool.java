package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class DeleteTool extends Tool{

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
