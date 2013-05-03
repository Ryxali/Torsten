package core.file;

import gui.square.Grid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.newdawn.slick.GameContainer;


public class FileReader {
	public static void loadDialogue(){
		load(getLoadPath());
	}
	
	private static String getLoadPath(){
		String s = "";
		while(s.equals("")){
			s = JOptionPane.showInputDialog("File Name?");
			//JOptionPane.showMessageDialog(null, s);
			if(s == null){
				return null;
			}
		}
		
		return s.replace("/", "").replace("\\", "") + ".grd";
	}
	
	public static void load(String path){
		if(path == null){
			return;
		}
		Scanner in;
		try {
			in = new Scanner(new File(FileSaver.SAVE_PATH + path));
			String [] bounds = in.nextLine().split("x");
			Grid.get().setGridBounds(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]));
			//Grid.get().fillTiles();
			int i = 0;
			while(in.hasNextLine()){
				constructRow(in.nextLine(), i);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void constructRow(String rowData, int row){
		//System.out.println("-_-_-_-"+rowData);
		String[] split = rowData.split(Convention.LAYER_0);
		//System.out.println(split[0]);
		for (int i = 0; i < split.length; i++) {
			Grid.get().setSquare(split[i], row, i);
		}
	}
}
