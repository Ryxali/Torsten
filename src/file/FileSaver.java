package file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import square.Grid;
/**
 * Uses Following Structure:
 * <ol>
 * <li>XBoundsxYBounds</li>
 * <li>SquareTile: SquareCreature: SquareObstacle: {SquareItem1; SquareItem...}. SquareTile...</li>
 * <li>SquareTile: SquareCreature: SquareObstacle: {SquareItem1; SquareItem...}. SquareTile...</li>
 * <li>SquareTile: SquareCreature: SquareObstacle: {SquareItem1; SquareItem...}. SquareTile...</li>
 * <li>SquareTile: SquareCreature: SquareObstacle: {SquareItem1; SquareItem...}. SquareTile...</li>
 * </ol>
 * @author freetimer
 *
 */
public class FileSaver {
	public static final String SAVE_PATH = "saves/";
	public static void saveAsDialogue(){
		saveData(getSavePath());
	}
	
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
	
	private static void saveData(String path){
		if(path == null){
			return;
		}
		path = path.replace("/", "").replace("\\", "");
		
		try {
			PrintWriter out = new PrintWriter(SAVE_PATH + path);
			out.println(Grid.get().getCols() + "x"+  Grid.get().rows());
			for(int i = 0; i < Grid.get().rows(); i++){
				out.println(Grid.get().concatRow(i));
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
