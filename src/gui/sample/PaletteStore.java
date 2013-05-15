package gui.sample;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;
import core.file.UserFileReader;


/**
 * Contains all the Palettes that is used within the program.
 * @author Niklas L
 *
 */
public class PaletteStore {
	/**
	 * The PaletteStore
	 */
	private static PaletteStore pStore;
	/**
	 * The buttons used to switch between palettes
	 */
	private PaletteSwitchButton[] pButtons;
	/**
	 * The height of the pButtons
	 */
	public static final int HEIGHT = 50;
	/**
	 * get the PaletteStore
	 * @return pStore, the PaletteStore
	 */
	public static PaletteStore get(){
		if(pStore == null){
			pStore = new PaletteStore();
		}
		return pStore;
	}
	/**
	 * Creates a new PaletteStore using the current user file as a reference as to what palettes to feature.
	 */
	private PaletteStore(){
		palettes = UserFileReader.get().readFile();
		pButtons = new PaletteSwitchButton[palettes.length];
		for (int i = 0; i < pButtons.length; i++) {
			pButtons[i] = new PaletteSwitchButton(palettes[i].getName());
		}
	}
	/**
	 * The Palettes in the store
	 */
	private Palette[] palettes;
	/**
	 * The currently active Palette
	 */
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
	/**
	 * Sets a palette at a specific position to another palette
	 * @param index the index at the Palette array
	 * @param palette the new palette
	 */
	public void set(int index, Palette palette){
		palettes[index] = palette;
	}
	/**
	 * Flushes the palette and sets a new size for it
	 * @param size the new size of the palette
	 */
	public void setSize(int size){
		palettes = new Palette[size];
	}
	/**
	 * 
	 * @return
	 */
	public Palette[] getPalettes(){
		return palettes;
	}
	
	/**
	 * Get the Palette at the specified index
	 * @param index the index in the palettes array
	 * @return a Palette in the specified index in the palettes array
	 */
	public Palette get(int index){
		return palettes[index];
	}
	/**
	 * Get the currently active Palette
	 * @return the currently active Palette
	 */
	public Palette getActivePalette(){
		return palettes[activePalette];
	}
	/**
	 * Checks whether two coordinates are within this element
	 * @param pointX the x coordinate to check
	 * @param pointY the y coordinate to check
	 * @param screenWidth the current screen width
	 * @param screenHeight the current screen height
	 * @return true if the coordinates are within this element bounds
	 */
	public boolean contains(int pointX, int pointY, int screenWidth, int screenHeight){
		if(screenWidth-getActivePalette().getWidth() <= pointX && pointX <= screenWidth){
			if(getActivePalette().getHeight() + Palette.Y_POS >= pointY && pointY >= 0){
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @deprecated a silly method with a silly purpose
	 */
	public int getY(){
		return Palette.Y_POS-HEIGHT;
	}

	public void draw(Graphics g, int screenWidth, int screenHeight, Input input) {
		
		g.setColor(Color.lightGray);
		g.fillRect(screenWidth-getActivePalette().getWidth(), getY(), getActivePalette().getWidth(), 50);
		for (int i = 0; i < pButtons.length; i++) {
			pButtons[i].draw(g, screenWidth-getActivePalette().getWidth()+getActivePalette().getWidth()/pButtons.length*i, Palette.Y_POS-HEIGHT, getActivePalette().getWidth()/pButtons.length, HEIGHT, screenWidth, screenHeight, input);
			//g.setColor(Color.black);
			//g.drawRect(Palette.X_POS, Palette.Y_POS-50,getActivePalette().getWidth()/palettes.length*i, 50);
		}
		getActivePalette().draw(g, screenWidth-getActivePalette().getWidth(), Palette.Y_POS, screenWidth, screenHeight, input);
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

	public void add(Palette palette) {
		Palette[] temp = new Palette[palettes.length+1];
		for (int i = 0; i < palettes.length; i++) {
			temp[i] = palettes[i];
		}
		temp[temp.length-1] = palette;
		palettes = temp;
		pButtons = new PaletteSwitchButton[palettes.length];
		for (int i = 0; i < pButtons.length; i++) {
			pButtons[i] = new PaletteSwitchButton(palettes[i].getName());
		}
	}
}
