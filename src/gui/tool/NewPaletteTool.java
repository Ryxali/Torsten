package gui.tool;

import javax.swing.JOptionPane;

import gui.sample.Palette;
import gui.sample.PaletteStore;
import gui.square.Square;

import org.newdawn.slick.Graphics;

public class NewPaletteTool extends Tool{

	public NewPaletteTool(String text) {
		super(text);
	}

	@Override
	public void onUse(Square square) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tool getTool() {
		PaletteStore.get().add(new Palette(JOptionPane.showInputDialog("Name of New Palette?")));
		return null;
	}

}
