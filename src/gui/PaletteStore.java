package gui;

import file.UserFileReader;

public class PaletteStore {
	
	private static PaletteStore pStore;
	
	public static PaletteStore get(){
		if(pStore == null){
			pStore = new PaletteStore();
		}
		return pStore;
	}
	
	private PaletteStore(){
		palettes = UserFileReader.get().readFile();
	}
	/**
	 * Note that the order of these palettes in the array matters
	 */
	private Palette[] palettes;
	private int activePalette = 0;
	
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
	
	public void set(int index, Palette palette){
		palettes[index] = palette;
	}
	public void setSize(int size){
		palettes = new Palette[size];
	}
	public Palette[] getPalettes(){
		return palettes;
	}
	
	
	public Palette get(int index){
		return palettes[index];
	}
	
	public Palette getActivePalette(){
		return palettes[activePalette];
	}
}
