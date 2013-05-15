package core.image;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
/**
 * A storage center for all images
 * @author Niklas L
 * @see DefaultImage
 */
public class ImageStore {
	/**
	 * The ImageStore
	 */
	private static ImageStore is;
	/**
	 * A HashMap containing String keys to match Image objects.
	 */
	private HashMap<String, Image> store;
	/**
	 * Constructs a new ImageStore
	 */
	private ImageStore(){
		store = new HashMap<String, Image>();
	}
	/**
	 * Fetch the ImageStore
	 * @return is, The ImageStore
	 */
	public static ImageStore get(){
		if(is == null){
			is = new ImageStore();
		}
		return is;
	}
	/**
	 * Fetch an image from the store based on ref. If the image doesn't exist; create one, then return it.
	 * @param ref the image reference.
	 * @return an image matching the reference.
	 */
	public Image getImage(String ref){
		if(!store.containsKey(ref)){
			try {
				store.put(ref, new Image(ref));
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return store.get(ref);
	}
}
