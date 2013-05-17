package core.file;

import gui.square.Grid;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * Saves the current world to a save file.
 * Note that this will receive an overhaul as we get a graphical interface going.
 * @author Niklas L
 * @see FileReader
 * @see Grid
 */
public class FileSaver {
	/** 
	 * The default save path for our saves.
	 */
	public static final String SAVE_PATH = "saves/";
	/**
	 * Asks the user what to name their world, then saves the world.
	 */
	public static void saveAsDialogue(){
		saveData(getSavePath());
	}
	/**
	 * Asks the user what the file should be called, then returns the result
	 * @return the file name of the world save
	 */
	private static String getSavePath(){
		String s = "";
		while(s.equals("")){
			s = JOptionPane.showInputDialog("Name your File:");
			//JOptionPane.showMessageDialog(null, s);
			if(s == null){
				return null;
			}
		}
		return s + ".grd";
	}
	/**
	 * saves the world data in a file under specified name
	 * @param path the file name
	 */
	private static void saveData(String path){
		if(path == null){
			return;
		}
		path = path.replace("/", "").replace("\\", "");
		
		try {
			PrintWriter out = new PrintWriter(SAVE_PATH + path);
			out.println(Grid.get().getCols() + "x"+  Grid.get().rows());
			for(int i = 0; i < Grid.get().rows(); i++){
				out.println(Grid.get().toPrintable(i));
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
