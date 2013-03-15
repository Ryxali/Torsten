package button;

import image.ImageStore;

import org.newdawn.slick.Graphics;


public class TextButton extends StandardButton{
	private String title;
	public TextButton(String title, int x, int y, ImageStore idleImg, ImageStore hoverImg,
			ImageStore pressedImg) {
		super(x, y, idleImg, hoverImg, pressedImg);
		this.title = title;
	}
	@Override
	public void draw(Graphics g){
		draw(getX(), getY(), g);
	}
	@Override
	public void draw(){
		
	}
	@Override
	public void draw(int x, int y, Graphics g){
		getStoredImage().draw(x, y);
		g.drawString(title,
				x + getStoredImage().getImage().getWidth() /2 -
				g.getFont().getWidth(title),
				y + getStoredImage().getImage().getHeight() /2 -
				g.getFont().getHeight(title));
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

}
