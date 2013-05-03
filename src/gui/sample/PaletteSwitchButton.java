package gui.sample;

import gui.Tooltip;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;

public class PaletteSwitchButton extends GButton{
	private String paletteName;
	public PaletteSwitchButton(String paletteName){
		super();
		this.paletteName = paletteName;
	}
	public void draw(Graphics g, int x, int y, int width, int height,
			int screenWidth, int screenHeight, 	Input input) {
		super.draw(g, x, y, width, height, input);
		if(getState() == STATE_HOVER || getState() == STATE_PRESSED){
			Tooltip.get().draw(g, screenWidth, screenHeight, paletteName);
		}
	}
}
