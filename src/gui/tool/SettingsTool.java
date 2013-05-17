package gui.tool;

import javax.swing.JOptionPane;

import gui.dialogue.ScreenResolutionDialogue;
import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.state.StateList;

/**
 * This tool, when selected, will open up a new window with application
 * settings.
 * 
 * @author Niklas L
 * 
 */
public class SettingsTool extends Tool {
	/**
	 * Creates a new Tool with the specified title
	 * 
	 * @param text
	 *            the string to be displayed on top of the button.
	 */
	public SettingsTool(String text) {
		super(text);
	}

	@Override
	public Tool getTool() {
		boolean b = true;
		while (b) {
			try {
				String[] newB = ScreenResolutionDialogue.show().split("x");
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
