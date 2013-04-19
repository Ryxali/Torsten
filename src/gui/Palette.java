package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import state.BuildState;

import button.Button;

import image.DrawableXY;
import image.ImageStore;
/**
 * A Palette is used to store any number of Samples
 * to place. There can be any number of Palettes at
 * once.
 * @author Niklas L
 * @see gui.Sample
 */
public class Palette implements DrawableXY{
	protected Sample[] samples;
	private int sampleIndex;
	private ImageStore frameImg;
	private String name;
	private Rectangle frameRect;
	public static final int X_POS = 600;
	public static final int WIDTH = 200;
	public static final int Y_POS = 0;
	public static final int HEIGHT = 500;
	
	private int width;
	private int height;
	
	public Palette(String name, int width, int height){
		//this.frameImg = frameImg;
		this.name = name;
		samples = new Sample[5];
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g, int x, int y){
		g.fillRect(x, y, width, height);
		//frameImg.draw(x-frameImg.getImage().getWidth(), y);
		int widt = 0;
		int heigh = 0;
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				samples[i].draw(g);//x+widt, y+heigh*samples[i].getStoredImage().getImage().getHeight(), 
				widt += 64;
				if(widt + 64 > width){
					widt = 0;
					heigh++;
				}
			}
		}
	}
	public void add(Sample sample){
		if(samples != null){
			enlarge();
		}
		if(sampleIndex >= samples.length){
			enlarge();
		}
		samples[sampleIndex] = sample;
		sampleIndex++;
	}
	private void enlarge(){
		Sample[] samps = samples;
		samples = new Sample[samps.length + 10];
		sampleIndex = 0;
		if(samps != null){
			for (int i = 0; i < samps.length; i++) {
				samples[i] = samps[i];
				sampleIndex++;
			}
		}
	}
	
	public void update(Input input){
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				samples[i].buttonStateCheck(input);
			}
		}
	}
	
	public Sample getClickedSample(BuildState bState){
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				if(samples[i].hasBeenClicked() == Button.PRESSED_TRUE){
					return samples[i];
				}
			}
		}
		return bState.getCurrentSample();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sample[] getSamples() {
		// TODO Auto-generated method stub
		return samples;
	}

	public Sample getSample(int j) {
		// TODO Auto-generated method stub
		return samples[j];
	}
}
