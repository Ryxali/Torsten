package gui;

import image.ImageStore;
import button.StandardButton;

public class Sample extends StandardButton{
	private byte elementPosX;
	private short elementPosY;
	public Sample(ImageStore idleImg, ImageStore hoverImg, ImageStore pressedImg) {
		super(idleImg, hoverImg, pressedImg);
	}

}
