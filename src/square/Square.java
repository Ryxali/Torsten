package square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

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
	
	//p v SquareIMG
	//p v SquareMOB
	//p v SquareOBS
	//p v SquareITM
	
	public Square(ImageStore squareImg){
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
	
	public Square(ImageStore squareImg, Creature creature, LootPile loot, Obstacle obstacle){
		this.squareImg = squareImg.getImage();
		this.creature = creature;
		this.loot = loot;
		this.obstacle = obstacle;
	}


	@Override
	public void draw(Graphics g, int baseX, int baseY) {
		squareImg.draw(baseX, baseY);
		if(creature != null){
			creature.draw(g, baseX, baseY);
		}
		if(loot != null){
			loot.draw(g, baseX, baseY);
		}
		if(obstacle != null){
			obstacle.draw(g, baseX, baseY);
		}
		
	}
}
