package gui;

import image.Drawable;
import image.DrawableXY;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import button.Button;
import button.GButton;

import squareitems.Placeable;

public class Toolbar {
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Tool[] pObjects;
	private Tool curTool;
	//private Sample[] samples;

	public Toolbar(String name, int x, int y, int width, int height, Tool... pObjects) {
		this.x = x;
		this.y = y;
		this.pObjects =  (Tool[]) pObjects;
	}
	
	public void draw(Graphics g, Input input){
		draw(g, x, y, input);
	}
	
	public void draw(Graphics g, int x, int y, Input input){
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.lightGray);
		g.drawRect(x, y, width, height);
		for (int i = 0; i < pObjects.length; i++) {
			pObjects[i].draw(g, x, y,  input);
		}
	}
	
	public void update(Input input){
		for (int i = 0; i < pObjects.length; i++) {
			if(pObjects[i].hasBeenClicked() == Button.PRESSED_TRUE){
				curTool = pObjects[i].getTool();
			}
		}
	}
	
	public int getY(){
		return y;
	}
}
