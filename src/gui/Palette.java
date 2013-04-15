package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

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
	private Sample[] samples;
	private int sampleIndex;
	private ImageStore frameImg;
	private String name;
	private Rectangle frameRect;
	public static final int X_POS = 600;
	public static final int WIDTH = 200;
	public static final int Y_POS = 0;
	public static final int HEIGHT = 500;
	
	public Palette(String name){
		//this.frameImg = frameImg;
		this.name = name;
		samples = new Sample[5];
	}
	
	public void draw(Graphics g, int x, int y){
		g.fillRect(x-200, 0, 200, 500);
		//frameImg.draw(x-frameImg.getImage().getWidth(), y);
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				samples[i].draw(x-200, y, g);
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
