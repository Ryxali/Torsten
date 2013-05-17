package gui.tool;

import javax.swing.JOptionPane;

import gui.sample.PaletteStore;
import gui.sample.Sample;
import gui.square.Square;

import org.newdawn.slick.Graphics;
/**
 * This tool will cause the user to go through a new sample creation process, adding the created Sample to the active Palette.
 * @author Niklas L
 * @see Tool
 * @see gui.sample.Sample
 */
public class AddSampleTool extends Tool {
	/**
	 * Creates a new AddSampleTool with the specified text.
	 * @param text the text that is going to be displayed on top of the button.
	 */
	public AddSampleTool(String text) {
		super(text);
	}

	@Override
	public void onUse(Square square) {
	}


	@Override
	public Tool getTool() {
		while (true) {
			try {
				PaletteStore
						.get()
						.getActivePalette()
						.add(new Sample(
								JOptionPane.showInputDialog("Name of Object?"),
								JOptionPane.showInputDialog("ImageRef?"),
								JOptionPane
										.showInputDialog("Type?\n(Creature/Obstacle/Item)"),
								JOptionPane.showInputDialog("Add info:")));
				return null;
			} catch (NullPointerException e) {

			}
		}
	}
	/**
	 * This tool is not selectable, and therefore cannot be drawn this way.
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		return;
	}

}
