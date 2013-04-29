package gui.tool;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class AnchoredToolbar extends Toolbar {
	private byte anchor;

	public static final byte ANCHOR_LEFT_BOT = -4;
	public static final byte ANCHOR_LEFT = -3;
	public static final byte ANCHOR_LEFT_TOP = -2;
	public static final byte ANCHOR_TOP = -1;
	public static final byte ANCHOR_RIGHT_TOP = 1;
	public static final byte ANCHOR_RIGHT = 2;
	public static final byte ANCHOR_RIGHT_BOT = 3;
	public static final byte ANCHOR_BOT = 4;
	public static final byte ANCHOR_FALSE = 0;

	public AnchoredToolbar(String name, int x, int y, int width, int height,
			byte anchor, Tool... pObjects) {
		super(name, x, y, width, height, pObjects);
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

	private int determineWidth(int width) {
		if(ANCHOR_LEFT_BOT <= anchor && anchor <= ANCHOR_LEFT_TOP){
			return 0;
		}
		return width;
	}
	private int determineHeight(int height) {
		if(ANCHOR_LEFT_TOP <= anchor && anchor <= ANCHOR_RIGHT_TOP){
			return 0;
		}
		return height;
	}

}
