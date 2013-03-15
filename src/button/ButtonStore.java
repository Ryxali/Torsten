package button;

import image.ImageStore;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * Contains all the static buttons used by the game.
 * This excludes inventory slots.
 * @author Niklas Lindblad
 *
 */
public enum ButtonStore {
	NEW_GAME(new StandardButton(247, 333,
			null, null, null));
	
	public static final int STATE_IDLE = 0;
	public static final int STATE_HOVER = 1;
	public static final int STATE_PRESSED = 2;
	
	public static final int MODE_REGULAR = 0;
	public static final int MODE_DROPDOWN = 1;
	public static final int MODE_SLIDER = 2;
	
	private Button button;
	
	private ButtonStore(Button button){
		this.button = button;
	}
	
	public Button getButton(){
		return button;
	}
	/**
	 * Unloads all Image based resources used by these buttons.
	 */
	public static void unloadAll(){
		ButtonStore[] temp = values();
		for(int i = 0; i < temp.length; i++){
			temp[i].getButton().unload();
		}
	}
	
	
}
