package gui.tool;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
/**
 * A Toolbar that will base its position at designated anchor points.
 * @author Niklas L
 * @see Toolbar
 */
public class AnchoredToolbar extends Toolbar {
	/**
	 * Corresponds with the "ANCHOR_..." values. It determines at what end of the screen
	 * we want to draw this object from.
	 */
	private byte anchor;
	/**
	 * Represents the anchor at the bottomleftmost part of the screen
	 */
	public static final byte ANCHOR_LEFT_BOT = -4;

	/**
	 * Represents the anchor at the leftmost part of the screen
	 */
	public static final byte ANCHOR_LEFT = -3;

	/**
	 * Represents the anchor at the topleftmost part of the screen
	 */
	public static final byte ANCHOR_LEFT_TOP = -2;

	/**
	 * Represents the anchor at the topmost part of the screen
	 */
	public static final byte ANCHOR_TOP = -1;

	/**
	 * Represents the anchor at the toprightmost part of the screen
	 */
	public static final byte ANCHOR_RIGHT_TOP = 1;

	/**
	 * Represents the anchor at the rightmost part of the screen
	 */
	public static final byte ANCHOR_RIGHT = 2;

	/**
	 * Represents the anchor at the bottomrightmost part of the screen
	 */
	public static final byte ANCHOR_RIGHT_BOT = 3;

	/**
	 * Represents the anchor at the bottommost part of the screen
	 */
	public static final byte ANCHOR_BOT = 4;

	/**
	 * Represents no anchor point at all.
	 */
	public static final byte ANCHOR_FALSE = 0;
	/**
	 * Creates a new AnchoredToolbar.
	 * @param name the name of the AnchoredToolbar.
	 * @param x the x position of the AnchoredToolbar.
	 * @param y the y position of the AnchoredToolbar.
	 * @param width the width of the AnchoredToolbar.
	 * @param height the height of the AnchoredToolbar.
	 * @param anchor the anchor point of the AnchoredToolbar.
	 * @param tools the tools this AnchoredToolbar contains.
	 */
	public AnchoredToolbar(String name, int x, int y, int width, int height,
			byte anchor, Tool... tools) {
		super(name, x, y, width, height, tools);
		this.anchor = anchor;
	}

	@Override
	public void draw(Graphics g, int width, int height, Input input) {
		g.setColor(Color.lightGray);
		g.drawString(width + " : " + height, 400, 400);
		width = determineWidth(width);
		height = determineHeight(height);
		super.draw(g, width + x, height + y, input);
	}
	/**
	 * Determines the width this object should use as offset when drawing.
	 * @param width the width of this object
	 * @return either this object width or 0, depending on anchor point.
	 */
	private int determineWidth(int width) {
		if(ANCHOR_LEFT_BOT <= anchor && anchor <= ANCHOR_LEFT_TOP){
			return 0;
		}
		return width;
	}
	/**
	 * Determines the height this object should use as offset when drawing.
	 * @param height the height of this object.
	 * @return either this object height or 0, depending on anchor point.
	 */
	private int determineHeight(int height) {
		if(ANCHOR_LEFT_TOP <= anchor && anchor <= ANCHOR_RIGHT_TOP){
			return 0;
		}
		return height;
	}
	/**
	 * Checks whether the specified points is within this AnchoredToolbar.
	 * @param pointX the x position to check.
	 * @param pointY the y position to check.
	 * @param screenWidth the current width of the screen.
	 * @param screenHeight the current height of the screen.
	 * @return true if pointX and pointY is within this AnchoredToolbar.
	 */
	public boolean contains(int pointX, int pointY, int screenWidth,
			int screenHeight) {
		screenWidth = determineWidth(screenWidth);
		screenHeight = determineHeight(screenHeight);
		if(screenWidth+x <= pointX && pointX <= screenWidth+x+width){
			if(screenHeight+y <= pointY && pointY <= screenHeight+y+height){
				return true;
			}
		}
		return false;
		
	}

}
