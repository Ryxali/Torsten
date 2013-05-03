package core.image;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageStore {
	private static ImageStore is;
	private HashMap<String, Image> store;
	
	private ImageStore(){
		store = new HashMap<String, Image>();
	}
	public static ImageStore get(){
		if(is == null){
			is = new ImageStore();
		}
		return is;
	}
	
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
