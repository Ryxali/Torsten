package gui;

import file.FileReader;

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

}
