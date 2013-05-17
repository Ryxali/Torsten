package gui.square;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import core.button.StandardButton;
import core.file.Convention;
import core.image.Drawable;
import core.image.DrawableXY;
import core.image.DefaultImage;
import core.image.ImageStore;

import gui.Tooltip;
import gui.sample.Sample;
import gui.square.item.Creature;
import gui.square.item.Item;
import gui.square.item.LootPile;
import gui.square.item.Obstacle;
import gui.square.item.Placeable;
import gui.square.item.SquareItem;

/**
 * The square is a container of all the various object one can come across in
 * the world. This includes:
 * <ol>
 * <li>The Square Base</li>
 * <li>A Creature</li>
 * <li>An Obstacle</li>
 * <li>The Loot Pile</li>
 * </ol>
 * Note that it isn't mandatory for the squares to contain objects listed above.
 * <p>
 * While in the game hovering over a square will reveal all its contents.
 * </p>
 * 
 * @author Niklas L
 * @see gui.square.Grid
 * @see gui.square.item.Creature
 * @see gui.square.item.LootPile
 * @see gui.square.item.Obstacle
 * @see gui.Tooltip
 */
public class Square extends StandardButton {
	/**
	 * The width and height of any square
	 */
	public static final int SQUARE_DIMENSION = 64;
	/**
	 * the image of the square
	 */
	private Image squareImg;
	/**
	 * The creature in the square
	 */
	private Creature creature;
	/**
	 * The loot in the square
	 */
	private LootPile loot;
	/**
	 * The obstacle in the square
	 */
	private Obstacle obstacle;
	/**
	 * The y position of the square
	 */
	private final int x;
	/**
	 * The x position of the square
	 */
	private final int y;

	// p v SquareIMG
	// p v SquareMOB
	// p v SquareOBS
	// p v SquareITM
	/**
	 * Creates an square with no square items.
	 * 
	 * @param squareImg
	 *            the image for the square
	 * @param x
	 *            the x position of the square
	 * @param y
	 *            the y position of the square
	 */
	public Square(DefaultImage squareImg, int x, int y) {
		super(DefaultImage.TILE_MARKER_IDLE, DefaultImage.TILE_MARKER_HOVER,
				DefaultImage.TILE_MARKER_PRESSED);
		this.x = x;
		this.y = y;
		this.squareImg = squareImg.getImage();
		loot = new LootPile("Loot Pile", null, "");
	}

	/*
	 * public Square(ImageStore squareImg, Creature creature){ this.squareImg =
	 * squareImg.getImage(); this.creature = creature; }
	 * 
	 * public Square(ImageStore squareImg, Creature creature, LootPile loot){
	 * this.squareImg = squareImg.getImage(); this.creature = creature;
	 * this.loot = loot; }
	 */
	/**
	 * Creates a square filled with square items.
	 * 
	 * @param squareImg
	 *            the image for the square.
	 * @param creature
	 *            the creature that exists in the square.
	 * @param loot
	 *            the loot that exists in the square.
	 * @param obstacle
	 *            the obstacle that's in the square.
	 * @param x
	 *            the x position of the square.
	 * @param y
	 *            the y position of the square.
	 */
	public Square(DefaultImage squareImg, Creature creature, LootPile loot,
			Obstacle obstacle, int x, int y) {
		super(DefaultImage.TILE_MARKER_IDLE, DefaultImage.TILE_MARKER_HOVER,
				DefaultImage.TILE_MARKER_PRESSED);
		this.x = x;
		this.y = y;
		this.squareImg = squareImg.getImage();
		this.creature = creature;
		this.loot = loot;
		this.obstacle = obstacle;
	}

	/**
	 * Creates a square based on the savefile information provided.
	 * 
	 * @param squareInfo
	 *            the savefile information representing this square
	 * @param x
	 *            the x position of this square
	 * @param y
	 *            the y positoin of this square
	 */
	public Square(String[] squareInfo, int x, int y) {
		super(DefaultImage.TILE_MARKER_IDLE, DefaultImage.TILE_MARKER_HOVER,
				DefaultImage.TILE_MARKER_PRESSED);
		this.x = x;
		this.y = y;
		squareImg = ImageStore.get().getImage(squareInfo[0])
				.getScaledCopy(64, 64);
		/*
		 * System.out.println("----::::----"); for (int i = 0; i <
		 * squareInfo.length; i++) { System.out.println(squareInfo[i]); }
		 * System.out.println("----_____----" + "");
		 */
		if (!squareInfo[1].equals("")) {
			String[] c = squareInfo[1].split(Convention.LAYER_2);
			// Ignore saved type as it's redundant to put in.
			creature = new Creature(c[0], c[1], c[3]);
		}
		if (!squareInfo[2].equals("")) {
			// System.out.println(squareInfo[2]);
			String[] o = squareInfo[2].split(Convention.LAYER_2);
			// Ignore saved type as it's redundant to put in.
			obstacle = new Obstacle(o[0], o[1], o[3]);
		}
		loot = new LootPile("Lootus", null, "");
		setLoot(squareInfo[3], loot);

	}

	/**
	 * Determine the loot that should be added to the loot pile
	 * 
	 * @param lootInfo
	 *            the information representing the loot of this square.
	 * @param loot
	 *            this square's loot pile
	 */
	private static void setLoot(String lootInfo, LootPile loot) {
		lootInfo = lootInfo.replace("{", "").replace("}", "");
		if (!lootInfo.equals("")) {
			String[] l = lootInfo.split(Convention.LAYER_4);
			for (int i = 0; i < l.length; i++) {
				loot.add(getLoot(l[i]));
			}
		}
	}

	/**
	 * Get a specific item based on save file information provided.
	 * 
	 * @param itemInfo
	 *            the information representing a single item in the loot pile of
	 *            this square.
	 * @return a new item based on the itemInfo provided.
	 */
	private static Item getLoot(String itemInfo) {
		String[] i = itemInfo.split(Convention.LAYER_3);
		for (int j = 0; j < i.length; j++) {
		}
		return new Item(i[0], i[1], i[3]);
	}

	/**
	 * Compacts this square into a line of string usable by the save file
	 * format.
	 * 
	 * @return a string representing this square and all its content
	 */
	public String toPrintable() {
		String temp = squareImg.getResourceReference() + Convention.LAYER_1;
		if (creature != null) {
			temp += creature.getName() + Convention.LAYER_2 + creature.getRef()
					+ Convention.LAYER_2 + creature.getType()
					+ Convention.LAYER_2 + creature.getInfo();
		}
		temp += "#! ";
		if (obstacle != null) {
			temp += obstacle.getName() + Convention.LAYER_2 + obstacle.getRef()
					+ Convention.LAYER_2 + obstacle.getType()
					+ Convention.LAYER_2 + obstacle.getInfo();
		}
		temp += Convention.LAYER_1 + "{";
		if (loot != null) {
			for (int i = 0; i < loot.size(); i++) {
				temp += loot.get(i).getName() + Convention.LAYER_2
						+ loot.get(i).getRef() + Convention.LAYER_2
						+ loot.get(i).getType() + Convention.LAYER_2
						+ loot.get(i).getInfo() + Convention.LAYER_3;
			}
		}
		temp += "}" + Convention.LAYER_0;
		return temp;
	}

	/**
	 * Draws the square and its contenst onto the screen in the following order:
	 * <ol>
	 * <li>The Square</li>
	 * <li>The Obstacle</li>
	 * <li>The Item Pool</li>
	 * <li>The Creature</li>
	 * </ol>
	 */
	public void draw(Graphics g, int baseX, int baseY, Input input) {
		squareImg.draw(baseX + x, baseY + y);
		if (obstacle != null) {
			obstacle.draw(g, baseX + x, baseY + y);
		}
		if (loot != null) {
			loot.draw(g, baseX + x, baseY + y);
		}
		if (creature != null) {
			creature.draw(g, baseX + x, baseY + y);
		}
		super.draw(g, x + baseX, y + baseY, input);
		// getStoredImage().draw(baseX + x, baseY + y);

	}

	/**
	 * Draws all of the info text of the square items into a box at the
	 * bottommost part of the screen.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param input
	 *            the current user input
	 */
	public void drawTooltip(Graphics g, int screenWidth, int screenHeight,
			Input input) {
		Tooltip.get().draw(g, screenWidth, screenHeight, creature, obstacle,
				loot);

		// g.drawString(x + " :" + y, input.getMouseX(), input.getMouseY());

	}

	/**
	 * Puts the sample provided into the appropriate tile. Any existing objects
	 * of that sample's type will be overridden unless it's an item.
	 * 
	 * @param sample
	 *            the sample provided.
	 */
	public void put(SquareItem sample) {
		if (sample instanceof Creature) {
			creature = (Creature) sample;
			return;
		} else if (sample instanceof Item) {
			loot.add((Item) sample);
		} else if (sample instanceof Obstacle) {
			obstacle = (Obstacle) sample;
		}
	}

	/**
	 * Clears this squares of all instances of creatures, obstacles and loot,
	 * creating a fresh pile of loot in the process.
	 */
	public void clear() {
		creature = null;
		loot = new LootPile("Loot:", null, "");
		obstacle = null;
	}

	/**
	 * An override to the button's update method as we don't want it to check
	 * button states automatically.
	 */
	@Override
	protected void update(Graphics g, int x, int y, int width, int height,
			Input input) {
		onClick(input);
	}

	/**
	 * Checks if this square should change state based on user input.
	 * 
	 * @param baseX
	 *            the base x position of the grid containing this square.
	 * @param baseY
	 *            the base y position of the grid containing this square.
	 * @param input
	 *            the current user input.
	 */
	public void buttonStateCheck(int baseX, int baseY, Input input) {
		super.buttonStateCheck(x + baseX, y + baseY, input);
	}
}
