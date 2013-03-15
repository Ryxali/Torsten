package image;

import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 * <p>The storage for all the images in the game. It's 
 * important to note that most (if not all) images 
 * will not be preloaded by default to shorten 
 * startup time.</p>
 * <p>Also, on a side note, since images here are a 
 * single reference; it might be worthwhile to clone
 * these for multiple uses.</p>
 * @author Niklas Lindblad
 *
 */
public enum ImageStore implements Loadable {
	DEFAULT("res/img/Def1.png", fetchImg("res/img/Def1.png"));
	
	/**
	 * The String reference to the image location on disk
	 */
	private final String ref;
	/**
	 * The image itself
	 */
	private Image img;
	/**
	 * Constructor for the enums
	 * @param ref
	 * @param img
	 */
	private ImageStore(String ref, Image img) {
		this.img = img;
		this.ref = ref;
	}
	
	/**
	 * loads the image data to ram
	 */
	public void reload(){
		img = fetchImg(ref);
	}
	
	/**
	 * unloads the image data
	 */
	public void unload(){
		if(img != DEFAULT.img){
			try {
				if(img != null){
					img.destroy();
					img = null;
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
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
	 * @return the ref of the image
	 */
	public String getRef() {
		return ref;
	}
	public float getImageLeftmostX(){
		return getImage().getCenterOfRotationX()-getImage().getWidth()/2;
	}
	public float getImageTopmostY(){
		return getImage().getCenterOfRotationY()-getImage().getHeight()/2;
	}
	public static void unloadAll(){
		ImageStore [] temp = values();
		for(int i = 0; i < temp.length; i++){
			temp[i].unload();
		}
	}

	/**
	 * 
	 * @return the image object
	 */
	public Image getImage() {
		if(img != null){
			return img;
		}else{
			return fetchImg(ref);
		}
		
	}
}
