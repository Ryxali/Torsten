package square;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import button.StandardButton;

import squareitems.Creature;
import squareitems.Item;
import squareitems.LootPile;
import squareitems.Obstacle;
import squareitems.Placeable;

import gui.Tooltip;
import image.Drawable;
import image.DrawableXY;
import image.ImageStore;

/**
 * The square is a container of all the various object one can come across in
 * the world. This includes:
 * <ol>
 * <li>The Square Base</li>
 * <li>Creature(s)</li>
 * <li>Terrain Modifiers/Obstacles</li>
 * <li>Loot Pile</li>
 * </ol>
 * Note that it isn't mandatory for the squares to contain objects listed above.
 * <p>
 * While in the game hovering over a square will reveal all its contents.
 * </p>
 * 
 * @author Niklas L
 * @see square.Grid
 * @see squareitems.Creature
 * @see squareitems.LootPile
 * @see squareitems.Obstacle
 */
public class Square extends StandardButton implements DrawableXY {
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
	public Square(ImageStore squareImg, int x, int y) {
		super(x, y, ImageStore.TILE_MARKER_IDLE, ImageStore.TILE_MARKER_HOVER,
				ImageStore.TILE_MARKER_PRESSED);
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
	public Square(ImageStore squareImg, Creature creature, LootPile loot,
			Obstacle obstacle, int x, int y) {
		super(x, y, ImageStore.TILE_MARKER_IDLE, ImageStore.TILE_MARKER_HOVER,
				ImageStore.TILE_MARKER_PRESSED);
		this.x = x;
		this.y = y;
		this.squareImg = squareImg.getImage();
		this.creature = creature;
		this.loot = loot;
		this.obstacle = obstacle;
	}

	public Square(String[] squareInfo, int x, int y) {
		super(x, y, ImageStore.TILE_MARKER_IDLE, ImageStore.TILE_MARKER_HOVER,
				ImageStore.TILE_MARKER_PRESSED);
		this.x = x;
		this.y = y;
		try {
			squareImg = new Image(squareInfo[0]).getScaledCopy(64, 64);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		if (!squareInfo[1].equals("")) {
			String[] c = squareInfo[1].split(", ");
			// Ignore saved type as it's redundant to put in.
			creature = new Creature(c[0], c[1], c[3]);
		}
		if (!squareInfo[2].equals("")) {
			String[] o = squareInfo[1].split(", ");
			// Ignore saved type as it's redundant to put in.
			obstacle = new Obstacle(o[0], o[1], o[3]);
		}
		loot = new LootPile("Lootus", null, "");
		setLoot(squareInfo[3], loot);

	}

	private static void setLoot(String lootInfo, LootPile loot) {
		lootInfo = lootInfo.replace("{", "").replace("}", "");
		if (!lootInfo.equals("")) {
			String[] l = lootInfo.split("; ");
			for (int i = 0; i < l.length; i++) {
				loot.add(getLoot(l[i]));
			}
		}
	}

	private static Item getLoot(String itemInfo) {
		System.out.println(":--__" + itemInfo);
		String[] i = itemInfo.split(", ");
		return new Item(i[0], i[1], i[3]);
	}

	public String concatInfo() {
		String temp = squareImg.getResourceReference() + ": ";
		if (creature != null) {
			temp += creature.getName() + ", " + creature.getRef() + ", "
					+ creature.getType() + ", " + creature.getInfo();
		}
		temp += ": ";
		if (obstacle != null) {
			temp += obstacle.getName() + ", " + obstacle.getRef() + ", "
					+ obstacle.getType() + ", " + obstacle.getInfo();
		}
		temp += ": {";
		if (loot != null) {
			for (int i = 0; i < loot.size(); i++) {
				temp += loot.get(i).getName() + ", " + loot.get(i).getRef()
						+ ", " + loot.get(i).getType() + ", "
						+ loot.get(i).getInfo() + "; ";
			}
		}
		temp += "}# ";
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
	@Override
	public void draw(Graphics g, int baseX, int baseY) {

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
		getStoredImage().draw(baseX + x, baseY + y);

	}

	/**
	 * Draws all of the info text of the square items into a box by the cursor.
	 * 
	 * @param g
	 *            the current graphics context
	 * @param input
	 *            the current user input
	 */
	public void drawTooltip(Graphics g, Input input) {
		Tooltip.get().draw(g, creature, obstacle, loot);

		// g.drawString(x + " :" + y, input.getMouseX(), input.getMouseY());

	}

	/**
	 * Puts the sample provided into the appropriate tile. Any existing objects
	 * of that sample's type will be overridden unless it's an item.
	 * 
	 * @param sample
	 *            the sample provided.
	 */
	public void put(Placeable sample) {
		if (sample instanceof Creature) {
			creature = (Creature) sample;
			return;
		} else if (sample instanceof Item) {
			loot.add((Item) sample);
		} else if (sample instanceof Obstacle) {
			obstacle = (Obstacle) sample;
		}
	}
}
