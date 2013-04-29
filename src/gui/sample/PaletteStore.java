package gui.sample;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;
import core.file.UserFileReader;



public class PaletteStore {
	
	private static PaletteStore pStore;
	private GButton[] pButtons;
	public static PaletteStore get(){
		if(pStore == null){
			pStore = new PaletteStore();
		}
		return pStore;
	}
	
	private PaletteStore(){
		palettes = UserFileReader.get().readFile();
		pButtons = new GButton[palettes.length];
		for (int i = 0; i < pButtons.length; i++) {
			pButtons[i] = new GButton();
		}
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
	
	public boolean contains(int pointX, int pointY, int screenWidth, int screenHeight){
		if(screenWidth-200 <= pointX && pointX <= screenWidth){
			if(getActivePalette().getHeight() + Palette.Y_POS <= pointY && pointY <= 0){
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g, int screenWidth, int screenHeight, Input input) {
		
		g.setColor(Color.lightGray);
		g.fillRect(screenWidth-200, Palette.Y_POS-50, getActivePalette().getWidth(), 50);
		for (int i = 0; i < pButtons.length; i++) {
			pButtons[i].draw(g, screenWidth-200+getActivePalette().getWidth()/pButtons.length*i, Palette.Y_POS-50, getActivePalette().getWidth()/pButtons.length, 50, input);
			//g.setColor(Color.black);
			//g.drawRect(Palette.X_POS, Palette.Y_POS-50,getActivePalette().getWidth()/palettes.length*i, 50);
		}
		getActivePalette().draw(g, screenWidth-200, Palette.Y_POS, screenWidth, screenHeight, input);
	}
	
	public void update(Input input){
		for (int i = 0; i < pButtons.length; i++) {
			//pButtons[i].buttonStateCheck(input, Palette.X_POS+getActivePalette().getWidth()/pButtons.length*i, Palette.Y_POS-50, getActivePalette().getWidth()/pButtons.length);
			if(pButtons[i].hasBeenClicked() == Button.PRESSED_TRUE){
				activePalette = i;
			}
		}
		getActivePalette().update(input);
	}
}
