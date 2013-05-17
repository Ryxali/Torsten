package core.button;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import core.image.DefaultImage;

/**
 * Contains all the static buttons used by the game. This excludes inventory
 * slots.
 * 
 * @author Niklas Lindblad
 * @deprecated this has yet to see an implementation.
 */
public enum ButtonStore {
	NEW_GAME(null);

	public static final int STATE_IDLE = 0;
	public static final int STATE_HOVER = 1;
	public static final int STATE_PRESSED = 2;

	public static final int MODE_REGULAR = 0;
	public static final int MODE_DROPDOWN = 1;
	public static final int MODE_SLIDER = 2;

	private Button button;

	private ButtonStore(Button button) {
		this.button = button;
	}

	public Button getButton() {
		return button;
	}

}
