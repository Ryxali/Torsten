package core.button;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.image.DefaultImage;

/**
 * A small extention of the StandardButtonXY class that allows a string text to
 * be stored and drawn onto it
 * 
 * @author Niklas L
 * @see StandardButtonXY
 */
public class TextButton extends StandardButtonXY {
	/**
	 * The text to be drawn onto the button
	 */
	private String title;
	/**
	 * Creates a new TextButton
	 * @param title the string to be drawn onto the button
	 * @param x the x position of this button
	 * @param y the y position of this button
	 * @param idleImg the image representation of an idle button for this button
	 * @param hoverImg the image representation of a hovering button for this button
	 * @param pressedImg the image representation of a pressed button for this button
	 */
	public TextButton(String title, int x, int y, DefaultImage idleImg,
			DefaultImage hoverImg, DefaultImage pressedImg) {
		super(x, y, idleImg, hoverImg, pressedImg);
		this.title = title;
	}
	@Override
	public void draw(Graphics g, Input input) {
		super.draw(g, input);
		g.drawString(
				title,
				x + getProperImage().getWidth() / 2
						- g.getFont().getWidth(title) / 2,
				y + getProperImage().getHeight() / 2
						- g.getFont().getHeight(title) / 2);
	}
	/**
	 * get the text string title of this button.
	 * @return title, the text being drawn onto this button.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * set the title of this button.
	 * @param title a new title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
