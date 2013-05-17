package core.image;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Loadable;

/**
 * <p>
 * The storage for Animations in the game. These, along with the images is
 * initially not loaded to save starting time.
 * </p>
 * 
 * <p>
 * You should also clone the animations when using it on multiple instances
 * (e.g. creatures) to prevent them from walking in unison.
 * </p>
 * 
 * @author Niklas Lindblad
 * @deprecated Animations aren't used
 */
public enum AnimationStore implements Loadable {
	DEFAULT(new AnimatedImage("res/img/Default/", "Def", ".png", 1, 1000,
			false, 1), "res/img/Default/", "Def", ".png", 1, 1000, false);

	/**
	 * The regular animation order
	 */
	public static boolean DIR_REGULAR = true;
	/**
	 * The reverse animation order
	 */
	public static boolean DIR_REVERSE = false;
	/**
	 * The AnimatedImage object of the animation.
	 */
	private AnimatedImage anim;
	/**
	 * The duration of each frame.
	 */
	private int dur;
	/**
	 * The number of frames
	 */
	private byte frames;
	/**
	 * The location of the images
	 */
	private final String filePath;
	/**
	 * the file name
	 */
	private final String fileName;
	/**
	 * .png in most cases.
	 */
	private final String fileEnding;

	private final DefaultImage srcImg;
	/**
	 * Used for checking if the animation is being looped automatically.
	 */
	private boolean autoRefresh;

	private int rev = 1;

	private final boolean usingSpriteSheet;

	/**
	 * Self explanatory builder of the enums. Does nothing special.
	 * 
	 * @param anim
	 * @param filePath
	 * @param fileName
	 * @param fileEnding
	 * @param frames
	 * @param dur
	 * @param autoRefresh
	 */
	private AnimationStore(AnimatedImage anim, String filePath,
			String fileName, String fileEnding, int frames, int dur,
			boolean autoRefresh) {
		this.anim = anim;
		;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileEnding = fileEnding;
		this.frames = (byte) frames;
		this.dur = dur;
		this.srcImg = null;
		this.autoRefresh = autoRefresh;
		usingSpriteSheet = false;
	}

	private AnimationStore(DefaultImage srcImg, int frames, int dur) {
		this.filePath = null;
		this.fileName = null;
		this.fileEnding = null;
		this.srcImg = srcImg;
		this.frames = (byte) frames;
		this.dur = dur;
		this.autoRefresh = true;
		usingSpriteSheet = true;
	}

	/**
	 * Reconstructs the animation for looping backwards or forwards, depending
	 * on input
	 * 
	 * @param dir
	 *            true for regular, false for backwards
	 */
	public void setDir(boolean dir) {
		if (dir) {
			rev = 1;
		} else {
			rev = -1;
		}
		anim = new AnimatedImage(filePath, fileName, fileEnding, frames, dur,
				autoRefresh, rev);
	}

	/**
	 * 
	 * @return true if it's animation is run regularly, false if it's in reverse
	 */
	public boolean isRegularDir() {
		if (rev == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true if the animation is looped automatically.
	 */
	public boolean isAutoRefresh() {
		return autoRefresh;
	}

	/**
	 * Reloads the animation into the memory, fetching the image from disk.
	 */
	public void reload() {
		if (!usingSpriteSheet) {
			anim = new AnimatedImage(filePath, fileName, fileEnding, frames,
					dur, autoRefresh, rev);
		} else {
			anim = new AnimatedImage(srcImg, frames, dur);
		}
	}

	/**
	 * Frees up space by removing the pointers to the animation.
	 */
	public void unload() {
		if (!anim.equals(DEFAULT.anim)) {
			try {
				if (anim != null) {
					anim.destroy();
					anim = null;
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	public static void unloadAll() {
		AnimationStore[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			temp[i].unload();
		}
	}

	/**
	 * Used for creating and returning an array of images.
	 * 
	 * @param path
	 * @param fileBaseName
	 * @param fileType
	 * @param quantity
	 * @return
	 */
	private static Image[] fetchImages(String path, String fileBaseName,
			String fileType, int quantity) {
		Image[] imgs = new Image[quantity];
		for (int i = 0; i < quantity; i++) {
			try {
				imgs[i] = new Image(path + fileBaseName + (i + 1) + fileType);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		return imgs;
	}

	/**
	 * 
	 * @return the duration of each animation image
	 */
	public int getDuration() {
		return dur;
	}

	/**
	 * 
	 * @return returns the animation object
	 */
	public AnimatedImage getAnimation() {
		if (anim != null) {
			return anim;
		} else {
			reload();
			return anim;
		}
	}
}
