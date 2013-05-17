package gui.sample;

import gui.square.item.Placeable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import core.button.Button;
import core.file.Convention;
import core.image.DrawableXY;
import core.image.DefaultImage;
import core.state.BuildState;

/**
 * A Palette is used to store any number of Samples to place. There can be any
 * number of Palettes at once.
 * 
 * @author Niklas L
 * @see gui.sample.Sample
 */
public class Palette {
	/**
	 * The samples contained in this Palette
	 */
	protected Sample[] samples;
	/**
	 * The current highest index of an existing sample of the samples array
	 */
	private int sampleIndex;
	/**
	 * The name of this Palette
	 */
	private String name;
	/**
	 * The y position of a palette
	 */
	public static final int X_POS = 600;
	/**
	 * The y position of a palette
	 */
	public static final int Y_POS = 50;
	/**
	 * The width of a palette
	 */
	public static final int WIDTH = 200;
	/**
	 * The height of a palette
	 */
	public static final int HEIGHT = 400;

	/**
	 * Constructs a new Palette with the specified name and an empty list of
	 * samples.
	 * 
	 * @param name
	 *            the name of the palette.
	 */
	public Palette(String name) {
		// this.frameImg = frameImg;
		this.name = name;
		samples = new Sample[5];
	}

	/**
	 * Draws the palette onto the screen, fitting the samples within its frame.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param x
	 *            the x position to draw this element at
	 * @param y
	 *            the y position to draw this element at
	 * @param screenWidth
	 *            the current width of the screen
	 * @param screenHeight
	 *            the current hieght of the screen
	 * @param input
	 *            the current user input
	 */
	public void draw(Graphics g, int x, int y, int screenWidth,
			int screenHeight, Input input) {
		g.fillRect(x, y, WIDTH, HEIGHT);
		// frameImg.draw(x-frameImg.getImage().getWidth(), y);
		int row = 0;
		int col = 0;
		for (int i = 0; i < samples.length; i++) {
			// System.out.println(i);
			if (samples[i] != null) {
				// System.out.println(i + " x");
				samples[i].draw(g, col + screenWidth - WIDTH, row + Y_POS,
						screenWidth, screenHeight, input);// x+widt,
															// y+heigh*samples[i].getStoredImage().getImage().getHeight(),
				col += 64;
				if (col + 64 > WIDTH) {
					col = 0;
					row += 64;
				}
			}
		}
	}

	/**
	 * Add a new sample to the palette
	 * 
	 * @param sample
	 *            the sample to add
	 */
	public void add(Sample sample) {
		if (samples == null) {
			enlarge();
		}
		if (sampleIndex >= samples.length) {
			enlarge();
		}
		// System.out.println(name + "["+sampleIndex+"] = " +
		// sample.getSquareItem().getName() + ", " + sample.toString());
		samples[sampleIndex] = sample;
		sampleIndex++;
	}

	/**
	 * Sizes up the samples array to fit 10 more samples.
	 */
	private void enlarge() {
		Sample[] samps = samples;
		samples = new Sample[samps.length + 10];
		sampleIndex = 0;
		if (samps != null) {
			for (int i = 0; i < samps.length; i++) {
				if (samps[i] != null) {
					// System.out.println(name +"["+i+"] = " +
					// samps[i].getSquareItem().getName() + ", " +
					// samps[i].toString());
					samples[i] = samps[i];
					sampleIndex++;
				}
			}
		}
	}

	/**
	 * @deprecated silly method...
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * Does nothing thus far
	 */
	public void update(Input input) {
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] != null) {
			}
		}
	}

	/**
	 * Checks all the samples of this palette and fetches a sample from one of
	 * them if the current user input dictates as such.
	 * 
	 * @param pAble
	 *            the current placeable object
	 * @return either the old sample or a new sample, depending on user input.
	 */
	public Placeable getClickedSample(Placeable pAble) {
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] != null) {
				if (samples[i].hasBeenClicked() == Button.PRESSED_TRUE) {
					return samples[i];
				}
			}
		}
		return pAble;
	}

	/**
	 * get the name of the Palette
	 * 
	 * @return name, the Palette name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get the sample array of this palette
	 * 
	 * @return samples, this Palette's sample array
	 */
	public Sample[] getSamples() {
		// TODO Auto-generated method stub
		return samples;
	}

	/**
	 * Get a sample from the list
	 * 
	 * @param i
	 *            the index of the sample in the list
	 * @return a sample in the specified index
	 */
	public Sample getSample(int i) {
		if (i > sampleIndex) {
			throw new ArrayIndexOutOfBoundsException();
		}
		// TODO Auto-generated method stub
		return samples[i];
	}

	/**
	 * 
	 * @deprecated sillygoose method is redundant...
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * Compacts this Palette's name and sample info to a format compatible with
	 * saves
	 * 
	 * @return a string containing a savefile compatible palette and sample
	 *         info.
	 */
	public String toPrintable() {
		String samps = "";
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] != null) {
				samps += samples[i].getPrintable();
			}
		}
		return name + Convention.LAYER_1 + samps;
	}
}
