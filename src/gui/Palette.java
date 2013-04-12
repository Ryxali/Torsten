package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

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
	
	public Palette(String name){
		//this.frameImg = frameImg;
		this.name = name;
	}
	
	public void draw(Graphics g, int x, int y){
		frameImg.draw(x, y);
		for (int i = 0; i < samples.length; i++) {
			samples[i].draw(x, y, g);
		}
	}
	public void add(Sample sample){
		if(samples != null){
			enlarge();
		}
		if(samples[samples.length] != null){
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
