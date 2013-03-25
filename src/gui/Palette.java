package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import image.DrawableXY;
import image.ImageStore;

public abstract class Palette implements DrawableXY{
	private Sample[] samples;
	private ImageStore frameImg;
	
	public Palette(ImageStore frameImg){
		this.frameImg = frameImg;
	}
	
	public void draw(Graphics g, int x, int y){
		
	}
	
	public void update(Input input){
		
	}
}
