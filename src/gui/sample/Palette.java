package gui.sample;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import core.button.Button;
import core.image.DrawableXY;
import core.image.DefaultImage;
import core.state.BuildState;



/**
 * A Palette is used to store any number of Samples
 * to place. There can be any number of Palettes at
 * once.
 * @author Niklas L
 * @see gui.sample.Sample
 */
public class Palette{
	protected Sample[] samples;
	private int sampleIndex;
	private DefaultImage frameImg;
	private String name;
	private Rectangle frameRect;
	public static final int X_POS = 600;
	public static final int Y_POS = 50;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 400;
	
	public Palette(String name){
		//this.frameImg = frameImg;
		this.name = name;
		samples = new Sample[5];
	}
	
	public void draw(Graphics g, int x, int y, int screenWidth, int screenHeight, Input input){
		g.fillRect(x, y, WIDTH, HEIGHT);
		//frameImg.draw(x-frameImg.getImage().getWidth(), y);
		int row = 0;
		int col = 0;
		for (int i = 0; i < samples.length; i++) {
			//System.out.println(i);
			if(samples[i] != null){
				//System.out.println(i + " x");
				samples[i].draw(g, col+screenWidth-WIDTH, row+Y_POS, screenWidth, screenHeight, input);//x+widt, y+heigh*samples[i].getStoredImage().getImage().getHeight(), 
				col +=64;
				if(col + 64 > WIDTH){
					col = 0;
					row+=64;
				}
			}
		}
	}
	public void add(Sample sample){
		if(samples == null){
			enlarge();
		}
		if(sampleIndex >= samples.length){
			enlarge();
		}
		//System.out.println(name + "["+sampleIndex+"] = " + sample.getSquareItem().getName() + ", " + sample.toString());
		samples[sampleIndex] = sample;
		sampleIndex++;
	}
	private void enlarge(){
		Sample[] samps = samples;
		samples = new Sample[samps.length + 10];
		sampleIndex = 0;
		if(samps != null){
			for (int i = 0; i < samps.length; i++) {
				if(samps[i] != null){
					//System.out.println(name +"["+i+"] = " + samps[i].getSquareItem().getName() + ", " + samps[i].toString());
					samples[i] = samps[i];
					sampleIndex++;
				}
			}
		}
	}
	public int getHeight(){
		return HEIGHT;
	}
	
	public void update(Input input){
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
			}
		}
	}
	
	public Placeable getClickedSample(Placeable pAble){
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				if(samples[i].hasBeenClicked() == Button.PRESSED_TRUE){
					return samples[i];
				}
			}
		}
		return pAble;
	}

	public String getName() {
		return name;
	}

	public Sample[] getSamples() {
		// TODO Auto-generated method stub
		return samples;
	}

	public Sample getSample(int j) {
		// TODO Auto-generated method stub
		return samples[j];
	}

	public int getWidth() {
		return WIDTH;
	}

	public String toPrintable() {
		// TODO Auto-generated method stub
		String samps = "";
		for (int i = 0; i < samples.length; i++) {
			if(samples[i] != null){
				samps += samples[i].getPrintable();
			}
		}
		return name + "#! " + samps;
	}
}
