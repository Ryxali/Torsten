package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import gui.Palette;
import gui.Sample;

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
		readFile();
	}

	/**
	 * Note that the order of these palettes in the array matters
	 */
	private Palette[] palettes;
	public static final String USER_DATA_PATH = "userData/palettes.dat";

	/**
	 * Swaps the position in the array between one palette and another.
	 * 
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2) {
		Palette temp = palettes[index1];
		palettes[index1] = palettes[index2];
		palettes[index2] = temp;
	}
	
	public Palette[] getPalettes(){
		return palettes;
	}
	
	public Palette get(int index){
		return palettes[index];
	}

	/**
	 * Reads the palette info from base file.
	 * 
	 */
	private void readFile() {
		try {
			Scanner indata = new Scanner(new File(USER_DATA_PATH));
			int lines = 0;
			while (indata.hasNextLine()) {
				lines++;
				indata.nextLine();
			}
			palettes = new Palette[lines];
			int curLine = 0;
			indata.close();
			indata = new Scanner(new File(USER_DATA_PATH));
			while (indata.hasNextLine()) {

				String line = indata.nextLine();
				System.out.println(line);
				String[] temp = line.split("; ");
				palettes[curLine] = new Palette(temp[0]);
				int sampleCol = 0;
				int sampleRow = 0;
				for (int i = 1; i < temp.length; i++) {
					String[] sampleData = temp[i].split(", ");
					for (int j = 0; j < sampleData.length; j++) {
						System.out.println(sampleData[j] + " " + j);
					}
					if(sampleCol > 3){
						sampleCol = 0;
						sampleRow++;
					}
					palettes[curLine].add(new Sample(Palette.X_POS + sampleCol*64, Palette.Y_POS + sampleRow*64, sampleData[0],
							sampleData[1], sampleData[2], sampleData[3]));
					sampleCol++;
				}
				curLine++;
			}
			indata.close();
		} catch (FileNotFoundException e) {
			System.out.println("makingDefaultfile");
			makeDefFile();
			readFile();
		}
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
						+ "; \n");
			}
			utdata.print("Obstacle; ");
			DefaultData[] temp2 = DefaultData.listOfType("Obstacle");
			for (int i = 0; i < temp.length; i++) {
				utdata.print(temp[i].getName() + ", " + temp[i].getImgRef()
						+ ", " + temp[i].getType() + ", " + temp[i].getInfo()
						+ "; \n");
			}
			utdata.print("Item; ");
			DefaultData[] temp3 = DefaultData.listOfType("Item");
			for (int i = 0; i < temp.length; i++) {
				utdata.print(temp[i].getName() + ", " + temp[i].getImgRef()
						+ ", " + temp[i].getType() + ", " + temp[i].getInfo()
						+ "; \n");
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
		PrintWriter utdata;
		try {
			utdata = new PrintWriter(new BufferedWriter(new FileWriter(
					USER_DATA_PATH)));

			for (int i = 0; i < palettes.length; i++) {
				utdata.print(palettes[i].getName() + "; ");
				for (int j = 0; j < palettes[i].getSamples().length; j++) {
					utdata.print(palettes[i].getSample(j).getName() + ", "
							+ palettes[i].getSample(j).getType() + ", "
							+ palettes[i].getSample(j).getInfo() + ";");
				}
				utdata.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
