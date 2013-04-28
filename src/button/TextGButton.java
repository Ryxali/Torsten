package button;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class TextGButton extends GButton{
	/**
	 * The text that is displayed on this button.
	 */
	private String text;
	/**
	 * Creates a new TextGButton.
	 * @param text the text to be displayed on this button.
	 */
	public TextGButton(String text){
		super();
		this.text = text;
	}
	
	
	@Override
	public void draw(Graphics g, int x, int y, int width, int height,
			Input input) {
		super.draw(g, x, y, width, height, input);
		g.drawString(text, x+width/2-g.getFont().getWidth(text)/2,
				y+height/2-g.getFont().getHeight(text)/2);
	}
}
