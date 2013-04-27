package button;

import image.ImageStore;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;


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
				x + getStoredImage().getWidth() /2 -
				g.getFont().getWidth(title),
				y + getStoredImage().getHeight() /2 -
				g.getFont().getHeight(title));
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

}
