package button;



import image.ImageStore;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * Needs revising
 * @author Niklas L
 *
 */
public class SliderButton extends ButtonXY {

	private Image sliderImg;
	private Image sliderBar;
	private int imgX;
	private int imgY;
	private boolean facing;
	private String sliderVal;
	private double perc;
	public static final boolean ALIGN_HORIZONTAL = true;
	public static final boolean ALIGN_VERTICAL = false;
	private boolean renderBounds = false;

	public SliderButton(int x, int y, ImageStore sliderImg,
			ImageStore sliderBar, boolean facing, String sliderVal) {
		super(x, y);
		perc = 0.5;
		this.sliderImg = sliderImg.getImage();
		this.sliderBar = sliderBar.getImage();
		this.sliderVal = sliderVal;
		this.facing = facing;
		refreshImgPos();
	}

	public SliderButton(int x, int y, Image sliderImg, Image sliderBar,
			boolean facing, String sliderVal) {
		super(x, y);
		perc = 0.5;
		this.sliderImg = sliderImg;
		this.sliderBar = sliderBar;
		this.sliderVal = sliderVal;
		this.facing = facing;
		refreshImgPos();
	}

	private void refreshImgPos() {
		if (facing == ALIGN_HORIZONTAL) {
			imgX = x
					+ toInt(perc, sliderBar.getWidth()
							+ sliderImg.getWidth());
					//- sliderImg.getImage().getWidth();
			imgY = y + sliderBar.getHeight() / 2
					- sliderImg.getHeight() / 2;
		} else {
			imgX = x + sliderBar.getWidth() / 2
					- sliderImg.getWidth() / 2;
			imgY = y
					+ toInt(perc, sliderBar.getHeight()
							+ sliderImg.getHeight());
					//- sliderImg.getImage().getHeight();
		}
	}

	@Override
	public Button copy() {
		return new SliderButton(getX(), getY(), sliderImg, sliderBar, facing,
				sliderVal);
	}
	
	public void setRenderBounds(boolean to){
		renderBounds = true;
	}

	private int toInt(double perc, int dist) {
		return (int) (dist * perc);
	}

	private double toPerc(int value, int dist) {
		
		if(1.0 <= (double)value/(double)dist){
			return 1.0;
		}else if((double)value/(double)dist <= 0.0){
			return 0.0;
		}
		return (double) value / (double) dist;
	}
	private int getImgX(){
		return (int) (imgX);
	}
	private int getImgY(){
		return (int) (imgY);
	}

	/*@Override
	public void buttonStateCheck(Input input) {
		int mX = input.getMouseX();
		int mY = input.getMouseY();

		if (pointContains(getX(), mX, getX() + sliderBar.getWidth())
				&& pointContains(getY(), mY, getY()
						+ sliderBar.getHeight())) {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				setState(STATE_PRESSED);
				setClicked(true);
			} else {
				setState(STATE_HOVER);
			}
		} else if (!(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && getState() == STATE_PRESSED)) {
			setState(STATE_IDLE);
			setClicked(false);
		}
		if (getState() == STATE_PRESSED) {
			if (facing == ALIGN_HORIZONTAL) {
				perc = toPerc(mX - getX() - sliderImg.getWidth()/2
						, sliderBar.getWidth()
						- sliderImg.getWidth());
			} else {
				perc = toPerc(mY - getY() - sliderImg.getWidth()/2
						, sliderBar.getHeight()
						- sliderImg.getHeight());
			}
			refreshImgPos();
		}

	}*/

	public Image getStoredImage() {
		return sliderImg;
	}

	@Override
	public int getType() {
		return ButtonStore.MODE_SLIDER;
	}

	@Override
	public void draw(Graphics g, Input input) {
		if(renderBounds){
			sliderBar.draw(x, y);
		}
		sliderImg.draw(imgX, imgY);
	}

	@Override
	public void onClick(Input input) {
		// TODO Auto-generated method stub
		
	}

}
