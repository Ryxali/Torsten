package gui.tool;


import gui.square.item.Placeable;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.button.Button;
import core.button.GButton;
import core.image.Drawable;
import core.image.DrawableXY;



public class Toolbar {
	protected int x;
	protected int y;
	private int width;
	private int height;
	
	private Tool[] pObjects;
	private Tool curTool;
	//private Sample[] samples;

	public Toolbar(String name, int x, int y, int width, int height, Tool... pObjects) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.pObjects =  (Tool[]) pObjects;
	}
	
	public void draw(Graphics g, Input input){
		draw(g, x, y, input);
	}
	
	public void draw(Graphics g, int x, int y, Input input){
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		/*int rows = width/(pObjects.length*64);
		int rowlen = width/(rows*64);
		for (int r = 0; r < rows; r++) {
			for (int i = 0; i < pObjects.length && i*64 < width; i++) {
				pObjects[i].draw(g, x+width*i/pObjects.length, y+rows*64,  input);
			}
		}*/
		
		int row = 0;
		int col = 0;
		for (int i = 0; i < pObjects.length; i++) {
			//System.out.println(i);
			if(pObjects[i] != null){
				//System.out.println(i + " x");
				pObjects[i].draw(g, col+x, row+y, input);//x+widt, y+heigh*samples[i].getStoredImage().getImage().getHeight(), 
				col +=64;
				if(col + 64 > width){
					col = 0;
					row+=64;
				}
			}
		}
		
	}
	
	public Placeable checkToolPickup(Placeable p){
		for (int i = 0; i < pObjects.length; i++) {
			if(pObjects[i].hasBeenClicked() == Button.PRESSED_TRUE){
				return pObjects[i].getTool();
			}
		}
		return p;
	}
	
	public int getY(){
		return y;
	}
}
