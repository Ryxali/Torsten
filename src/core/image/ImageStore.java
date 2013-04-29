package core.image;

import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 * <p>The storage for all the images in the game. It's 
 * important to note that most (if not all) images 
 * will not be preloaded by default to shorten 
 * startup time.</p>
 * <p>The Images stored here are final since
 * OpenGL 2.0 doesn't allow for dynamic string
 * sources as reference for images.</p>
 * @author Niklas Lindblad
 *
 */
public enum ImageStore {
	DEFAULT(fetchImg("res/img/Default/Def1.png")),
	TILE_PLAIN(fetchImg("res/img/Tile/GravelBlock.png")),
	SAMPLE_IDLE(fetchImg("res/img/sampleButton/SampleIdle.png")),
	SAMPLE_HOVER(fetchImg("res/img/sampleButton/SampleHover.png")),
	SAMPLE_PRESSED(fetchImg("res/img/sampleButton/SamplePressed.png")),
	TILE_MARKER_IDLE(fetchImg("res/img/tileButton/SquareIdle.png")),
	TILE_MARKER_HOVER(fetchImg("res/img/tileButton/SquareHover.png")),
	TILE_MARKER_PRESSED(fetchImg("res/img/tileButton/SquarePressed.png"));
	/**
	 * The image itself
	 */
	private final Image img;
	/**
	 * Constructor for the enums
	 * @param ref
	 * @param img
	 */
	private ImageStore(Image img) {
		this.img = img;
	}
	
	public void draw(int x, int y){
		getImage().draw((float) x, (float) y);
	}
	/**
	 * safely fetches an image based on ref
	 * @param ref
	 * @return the image
	 */
	private static Image fetchImg(String ref) {
		try {
			Image i = new Image(ref);
			return i.getScaledCopy((int)(i.getWidth()),
					(int)(i.getHeight()));
		} catch(Exception e){
			System.out.println(ref);
			e.printStackTrace();
			return DEFAULT.getImage();
		}
	}

	/**
	 * 
	 * @return the image object
	 */
	public Image getImage() {
		return img;
	}
}
