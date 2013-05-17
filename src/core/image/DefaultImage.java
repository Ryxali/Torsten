package core.image;

import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * <p>
 * The storage for all the default used image references in the game.
 * </p>
 * 
 * @author Niklas Lindblad
 * @see ImageStore
 */
public enum DefaultImage {
	DEFAULT(fetchImg("res/img/Default/Def1.png")), TILE_PLAIN(
			fetchImg("res/img/Tile/GravelBlock.png")), SAMPLE_IDLE(
			fetchImg("res/img/sampleButton/SampleIdle.png")), SAMPLE_HOVER(
			fetchImg("res/img/sampleButton/SampleHover.png")), SAMPLE_PRESSED(
			fetchImg("res/img/sampleButton/SamplePressed.png")), TILE_MARKER_IDLE(
			fetchImg("res/img/tileButton/SquareIdle.png")), TILE_MARKER_HOVER(
			fetchImg("res/img/tileButton/SquareHover.png")), TILE_MARKER_PRESSED(
			fetchImg("res/img/tileButton/SquarePressed.png"));
	/**
	 * The image itself
	 */
	private final Image img;

	/**
	 * Constructor for the enums
	 * 
	 * @param ref
	 * @param img
	 */
	private DefaultImage(Image img) {
		this.img = img;
	}

	public void draw(int x, int y) {
		getImage().draw((float) x, (float) y);
	}

	/**
	 * safely fetches an image from the image store based on it's internal
	 * reference
	 * 
	 * @param ref
	 * @return the image
	 */
	private static Image fetchImg(String ref) {
		try {
			return ImageStore
					.get()
					.getImage(ref)
					.getScaledCopy(
							(int) (ImageStore.get().getImage(ref).getWidth()),
							(int) (ImageStore.get().getImage(ref).getHeight()));
		} catch (Exception e) {
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
