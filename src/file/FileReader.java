package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.newdawn.slick.GameContainer;

import square.Grid;

public class FileReader {
	public static void loadDialogue(GameContainer gc){
		load(getLoadPath(), gc);
	}
	
	private static String getLoadPath(){
		String s = JOptionPane.showInputDialog("File Name?");
		return s.replace("/", "").replace("\\", "") + ".grd";
	}
	
	public static void load(String path, GameContainer gc){
		Scanner in;
		try {
			in = new Scanner(new File(FileSaver.SAVE_PATH + path));
			String [] bounds = in.nextLine().split("x");
			Grid.get().setGridBounds(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]), gc);
			//Grid.get().fillTiles();
			int i = 0;
			while(in.hasNextLine()){
				constructRow(in.nextLine(), 0);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void constructRow(String rowData, int row){
		System.out.println("-_-_-_-"+rowData);
		String[] split = rowData.split("# ");
		System.out.println(split[0]);
		for (int i = 0; i < split.length; i++) {
			Grid.get().setSquare(split[i], row, i);
		}
	}
}
