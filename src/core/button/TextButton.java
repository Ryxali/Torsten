package core.button;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.image.ImageStore;


public class TextButton extends StandardButtonXY{
	private String title;
	public TextButton(String title, int x, int y, ImageStore idleImg, ImageStore hoverImg,
			ImageStore pressedImg) {
		super(x, y, idleImg, hoverImg, pressedImg);
		this.title = title;
	}
	
	@Override
	public void draw(Graphics g, Input input) {
		super.draw(g, input);
		g.drawString(title,
				x + getProperImage().getWidth() /2 -
				g.getFont().getWidth(title)/2,
				y + getProperImage().getHeight() /2 -
				g.getFont().getHeight(title)/2);
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

}
