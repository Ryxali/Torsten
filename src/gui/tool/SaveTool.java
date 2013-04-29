package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.file.FileSaver;


public class SaveTool extends Tool{

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
