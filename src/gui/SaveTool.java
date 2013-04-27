package gui;

import org.newdawn.slick.Graphics;

import file.FileSaver;

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

}
