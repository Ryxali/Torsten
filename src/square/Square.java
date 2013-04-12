package square;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import squareitems.Creature;
import squareitems.LootPile;
import squareitems.Obstacle;

import image.Drawable;
import image.DrawableXY;
import image.ImageStore;
/**
 * The square is a container of all the various object one can come
 * across in the world. This includes:
 * <ol>
 * <li>The Square Base</li>
 * <li>Creature(s)</li>
 * <li>Terrain Modifiers/Obstacles</li>
 * <li>Loot Pile</li>
 * </ol>
 * Note that it isn't mandatory for the squares to contain objects listed
 * above.
 * <p>
 * While in the game hovering over a square will reveal all its contents.
 * </p>
 * @author Niklas L
 * @see square.Grid
 * @see squareitems.Creature
 * @see squareitems.LootPile
 * @see squareitems.Obstacle
 */
public class Square implements DrawableXY{
	public static final int SQUARE_DIMENSION = 64;
	
	private Image squareImg;
	private Creature creature;
	private LootPile loot;
	private Obstacle obstacle;
	
	private final int x;
	private final int y;
	
	//p v SquareIMG
	//p v SquareMOB
	//p v SquareOBS
	//p v SquareITM
	
	public Square(ImageStore squareImg, int x, int y){
		this.x = x;
		this.y = y;
		this.squareImg = squareImg.getImage();
	}
	/*
	public Square(ImageStore squareImg, Creature creature){
		this.squareImg = squareImg.getImage();
		this.creature = creature;
	}
	
	public Square(ImageStore squareImg, Creature creature, LootPile loot){
		this.squareImg = squareImg.getImage();
		this.creature = creature;
		this.loot = loot;
	}*/
	
	public Square(ImageStore squareImg, Creature creature, LootPile loot, Obstacle obstacle, int x, int y){
		this.x = x;
		this.y = y;
		this.squareImg = squareImg.getImage();
		this.creature = creature;
		this.loot = loot;
		this.obstacle = obstacle;
	}


	@Override
	public void draw(Graphics g, int baseX, int baseY) {
		squareImg.draw(baseX + x, baseY + y);
		if(creature != null){
			creature.draw(g, baseX + x, baseY + y);
		}
		if(loot != null){
			loot.draw(g, baseX + x, baseY + y);
		}
		if(obstacle != null){
			obstacle.draw(g, baseX + x, baseY + y);
		}
		
	}

	public void drawTooltip(Graphics g, Input input) {
		int x1 = input.getMouseX();
		int y1 = input.getMouseY();
		g.setColor(Color.lightGray);
		g.fillRect(x1, y1, 180, 300);
		g.setColor(Color.black);
		g.drawRect(x1, y1, 180, 300);
		int textRow = 1;
		if(creature != null){
			textRow += creature.drawInfo(g, x1, y1, textRow);
		}
		if(loot != null){
			textRow += loot.drawInfo(g, x1, y1, textRow);
		}
		if(obstacle != null){
			textRow += obstacle.drawInfo(g, x1, y1, textRow);
		}
		g.drawString(x + " :" + y, input.getMouseX(), input.getMouseY());
		
	}
}
