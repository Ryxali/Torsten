package gui;

import java.awt.Frame;

import javax.swing.JOptionPane;

import square.Square;
/**
 * I intend for this to be an XML using editor for a specific square
 * @author freetimer
 *
 */
public class AdvancedEdit extends Frame implements Runnable{

	private AdvancedEdit(Square square){
		setBounds(100, 100, 300, 500);
	}

	public static Thread getNew(Square square){
		return new Thread(new AdvancedEdit(square), "AdvancedEdit");
	}
	
	public void run(){
		//JOptionPane.showMessageDialog(null, "Huzzah");
		setVisible(true);
	}
}
