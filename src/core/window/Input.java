package core.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
/**
 * A yet to be implemented class that handles events.
 * @author freetimer
 *
 */
public class Input {
	private Listener list;
	
	public Input(){
		list = new Listener();
	}
	/**
	 * Get the current x position of this cursor
	 */
	public int getMouseX(){
		return 0;
	}
	/**
	 * Get the current y position of this cursor
	 * @return
	 */
	public int getMouseY(){
		return 0;
	}
	/**
	 * Checks whether the specified key is down
	 * @param keyCode the key to check
	 * @return true if the specified key is indeed currently pressed.
	 */
	public boolean isKeyDown(int keyCode){
		int[] temp = list.getCurrentKeysClicked();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] == keyCode){
				return true;
			}
		}
		return false;
	}
	/**
	 * checks if the specified key is down along with the specified
	 * metakeys.
	 * @param keyCode
	 * @param metaKey ALT, CTRL, SHIFT
	 * @return
	 */
	public boolean isKeyDown(int keyCode, int... metaKey){
		return false;
	}
}
