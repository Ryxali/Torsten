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
		System.out.println("Checkings!");
		while (indata.hasNextLine()) {
			String s = indata.nextLine();
			System.out.println(">>>" + s);
			if(s.contains(";")){
				System.out.println("match");
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
			String[] temp = line.split("; ");
			System.out.println(">-->>>>->" + line.replace(temp[0], ""));
			
			tempPal[curLine] = createPalette(temp[0], line.replace(temp[0]+"; ", ""));
			curLine++;
		}
		return tempPal;
	}

	private Palette createPalette(String name, String creatureData) {
		Palette temp = new Palette(name, 200, 400);
		String[] creatureValues = creatureData.split("; ");
		
		for (int i = 0; i < creatureValues.length; i++) {
			temp.add(readSample(creatureValues[i], i));
		}
		return temp;
	}

	private Sample readSample(String sampleInfo, int curIndex) {
		String[] sampleData = sampleInfo.split(", ");
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

			utdata.print("Creature; ");
			DefaultData[] temp = DefaultData.listOfType("Creature");
			for (int i = 0; i < temp.length; i++) {
				utdata.print(temp[i].getName() + ", " + temp[i].getImgRef()
						+ ", " + temp[i].getType() + ", " + temp[i].getInfo()
						+ "; ");
			}
			utdata.print("\n");
			utdata.print("Obstacle; ");
			DefaultData[] temp2 = DefaultData.listOfType("Obstacle");
			for (int i = 0; i < temp2.length; i++) {
				utdata.print(temp2[i].getName() + ", " + temp2[i].getImgRef()
						+ ", " + temp2[i].getType() + ", " + temp2[i].getInfo()
						+ "; ");
			}
			utdata.print("\n");
			utdata.print("Item; ");
			DefaultData[] temp3 = DefaultData.listOfType("Item");
			for (int i = 0; i < temp3.length; i++) {
				utdata.print(temp3[i].getName() + ", " + temp3[i].getImgRef()
						+ ", " + temp3[i].getType() + ", " + temp3[i].getInfo()
						+ "; ");
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
