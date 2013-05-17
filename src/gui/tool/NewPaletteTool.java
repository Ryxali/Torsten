package gui.tool;

import javax.swing.JOptionPane;

import gui.sample.Palette;
import gui.sample.PaletteStore;
import gui.square.Square;

import org.newdawn.slick.Graphics;
/**
 * This tool, when selected, will Create a new empty Palette with the name specified by user prompt.
 * @author Niklas L
 *
 */
public class NewPaletteTool extends Tool{
	/**
	 * Creates a new Tool with the specified title
	 * @param text the string to be displayed on top of the button.
	 */
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
