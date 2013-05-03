package core.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import gui.sample.Palette;
import gui.sample.PaletteStore;
import gui.sample.Sample;

/**
 * Contains and handles Palette and Sample data.
 * 
 * <p>
 * brief explanation of file system:
 * <ul>
 * <li>Palette1 Name; Sample1Name, Sample1ImageRef, Sample1Type, Sample1Info;
 * Sample2...</li>
 * <li>Palette2 Name; Sample1Name, Sample1ImageRef, Sample1Type, Sample1Info;
 * Sample2...</li>
 * </ul>
 * </p>
 * 
 * @author Niklas L
 * 
 */
public class UserFileReader {

	private static UserFileReader ufr;

	public static UserFileReader get() {
		if (ufr == null) {
			ufr = new UserFileReader();
		}
		return ufr;
	}

	public UserFileReader() {
		
	}
	
	public static final String USER_DATA_PATH = "userData/palettes.dat";

	/**
	 * Reads the palette info from base file.
	 * 
	 */
	public Palette[] readFile() {
		Palette[] tempPal = null;
		try {
			//Scanner indata = new Scanner(new File(USER_DATA_PATH));
			//indata = new Scanner(new File(USER_DATA_PATH));
			tempPal = readContent(USER_DATA_PATH);
			//indata.close();
		} catch (Exception e) {
			System.out.println("makingDefaultfile");
			makeDefFile();
			try {
				tempPal = readContent(USER_DATA_PATH);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.exit(0);
			}
		}
		return tempPal;
	}
	
	private int checkNumbPalettes(Scanner indata) {
		int lines = 0;
		while (indata.hasNextLine()) {
			String s = indata.nextLine();
			if(s.contains(Convention.LAYER_1)){
				lines++;
			}
		}
		indata.close();
		return lines;
	}

	private Palette[] readContent(String fPath) throws FileNotFoundException{
		Palette[] tempPal = new Palette[checkNumbPalettes(new Scanner(new File(fPath)))];
		int curLine = 0;
		Scanner indata = new Scanner(new File(fPath));
		while (indata.hasNextLine()) {
			String line = indata.nextLine();
			System.out.println(line);
			String[] temp = line.split(Convention.LAYER_1);
			
			tempPal[curLine] = createPalette(temp[0], line.replace(temp[0]+Convention.LAYER_1, ""));
			curLine++;
		}
		return tempPal;
	}

	private Palette createPalette(String name, String creatureData) {
		Palette temp = new Palette(name);
		String[] creatureValues = creatureData.split(Convention.LAYER_1);
		
		for (int i = 0; i < creatureValues.length; i++) {
			temp.add(readSample(creatureValues[i], i));
		}
		return temp;
	}

	private Sample readSample(String sampleInfo, int curIndex) {
		String[] sampleData = sampleInfo.split(Convention.LAYER_2);
		return new Sample(sampleData[0],
				sampleData[1], sampleData[2], sampleData[3]);
	}

	/**
	 * Creates a fresh data file
	 */
	private void makeDefFile() {
		try {
			PrintWriter utdata = new PrintWriter(new BufferedWriter(new FileWriter(
					USER_DATA_PATH)));

			utdata.print("Creature" + Convention.LAYER_1);
			DefaultData[] temp = DefaultData.listOfType("Creature");
			for (int i = 0; i < temp.length; i++) {
				utdata.print(temp[i].getName() + Convention.LAYER_2 + temp[i].getImgRef()
						+ Convention.LAYER_2 + temp[i].getType() + Convention.LAYER_2 + temp[i].getInfo()
						+ Convention.LAYER_1);
			}
			utdata.print("\n");
			utdata.print("Obstacle"+ Convention.LAYER_1);
			DefaultData[] temp2 = DefaultData.listOfType("Obstacle");
			for (int i = 0; i < temp2.length; i++) {
				utdata.print(temp2[i].getName() + Convention.LAYER_2 + temp2[i].getImgRef()
						+ Convention.LAYER_2 + temp2[i].getType() + Convention.LAYER_2 + temp2[i].getInfo()
						+ Convention.LAYER_1);
			}
			utdata.print("\n");
			utdata.print("Item"+ Convention.LAYER_1);
			DefaultData[] temp3 = DefaultData.listOfType("Item");
			for (int i = 0; i < temp3.length; i++) {
				utdata.print(temp3[i].getName() + Convention.LAYER_2 + temp3[i].getImgRef()
						+ Convention.LAYER_2 + temp3[i].getType() + Convention.LAYER_2 + temp3[i].getInfo()
						+ Convention.LAYER_1);
			}
			utdata.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Prints the current User data to file.
	 */
	public void printToFile() {
		//System.exit(0);
		PrintWriter utdata;
		try {
			utdata = new PrintWriter(new BufferedWriter(new FileWriter(
					USER_DATA_PATH)));

			for (int i = 0; i < PaletteStore.get().getPalettes().length; i++) {
				utdata.print(PaletteStore.get().get(i).toPrintable());
				utdata.println();
			}
			utdata.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
