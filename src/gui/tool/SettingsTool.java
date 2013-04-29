package gui.tool;

import javax.swing.JOptionPane;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.state.StateList;

public class SettingsTool extends Tool {

	public SettingsTool(String text) {
		super(text);
	}

	@Override
	public Tool getTool() {
		boolean b = true;
		while (b) {
			try {
				String[] newB = JOptionPane.showInputDialog(
						"New Screen Size (RESxRES)").split("x");
				StateList.BUILD.getState().setBounds(Integer.valueOf(newB[0]),
						Integer.valueOf(newB[1]));
				b = false;
			} catch (Exception e) {

			}
		}
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
