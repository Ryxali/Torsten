package gui.tool;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.file.FileReader;

public class LoadTool extends Tool{

	public LoadTool(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tool getTool() {
		FileReader.loadDialogue();
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
