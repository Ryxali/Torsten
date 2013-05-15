package gui.dialogue;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * A yet to be properly implemented Dialogue box to be used in various options and settings
 * @author Niklas L
 *
 */
public class MultipleInputDialogue extends JFrame{
	private static MultipleInputDialogue mid;
	private MultipleInputDialogue(){
		super();
		setBounds(100, 100, 300, 100);
		/*JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		
		JScrollPane editorScrollPane = new JScrollPane(editorPane);
		editorScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(250, 145));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		add(editorPane);*/
		setDefaultLookAndFeelDecorated(true);
		add(new JTextField("Width", 5));
		add(new JTextField("Height", 5));
		//add(new JButton("Confirm"));
		//add(new JButton("Cancel"));
	}
	
	public static MultipleInputDialogue get(){
		if(mid == null){
			mid = new MultipleInputDialogue();
		}
		return mid;
	}
	public String[] showMultipleInputDialogue(String title, String... options){
		String [] temp = null;
		setVisible(true);
		
		//editorPane.setVisible(true);
		System.out.println("Derr");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
