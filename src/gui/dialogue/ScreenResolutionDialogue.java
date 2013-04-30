package gui.dialogue;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class ScreenResolutionDialogue {
	public static String show(){
		JOptionPane p = new JOptionPane();
		p.setComponentPopupMenu(new JPopupMenu("LeL"));
		return JOptionPane.showInputDialog(new JPopupMenu("LeL"), "Select new Resolution");
	}
}
