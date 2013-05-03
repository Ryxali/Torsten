package gui.tool;

import javax.swing.JOptionPane;

import gui.sample.PaletteStore;
import gui.sample.Sample;
import gui.square.Square;

import org.newdawn.slick.Graphics;

public class AddSampleTool extends Tool {

	public AddSampleTool(String text) {
		super(text);
	}

	@Override
	public void onUse(Square square) {
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

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

}
