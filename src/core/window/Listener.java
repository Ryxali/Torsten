package core.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Listener implements KeyListener, MouseListener, MouseWheelListener {

	private boolean[] keysPressed;

	public Listener() {
	}

	private void set(int keyCode, boolean value) {
		if (keysPressed.length < keyCode) {
			boolean[] temp = new boolean[keyCode];
			for (int i = 0; i < keysPressed.length; i++) {
				temp[i] = keysPressed[i];
			}
			for (int j = keysPressed.length; j < temp.length; j++) {
				temp[j] = false;
			}
			keysPressed = temp;
		}
		keysPressed[keyCode] = value;
	}

	public int[] getCurrentKeysClicked() {
		int i = 0;
		for (; i < keysPressed.length; i++) {

		}
		int[] temp = new int[i];
		i = 0;
		for (int j = 0; j < keysPressed.length; j++) {
			if (keysPressed[j]) {
				temp[i] = j;
			}
		}
		return temp;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		set(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		set(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
