package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import squareitems.Creature;
import squareitems.LootPile;
import squareitems.Obstacle;
import squareitems.SquareItem;

import image.Drawable;

public class Tooltip {
	
	public static final int X_POS = 0;
	public static final int Y_POS = 450;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 150;
	private static Tooltip tTip;
	
	private Tooltip(){
		
	}
	public static Tooltip get(){
		if(tTip == null){
			tTip = new Tooltip();
		}
		return tTip;
	}
	
	public void draw(Graphics g, SquareItem... items) {
		g.setColor(Color.lightGray);
		g.fillRect(X_POS, Y_POS, WIDTH, HEIGHT);
		g.setColor(Color.black);
		
		for (int i = 0; i < items.length; i++) {
			
			g.drawRect(X_POS + (WIDTH/items.length)*i, Y_POS, WIDTH, HEIGHT);
			if(items[i] != null){
				items[i].drawInfo(g, X_POS + 5 + (WIDTH/items.length)*i, Y_POS, WIDTH/items.length - 10);
			}
		}
		/*
		//Square Tile info
		
		//Creature info
		g.drawRect(X_POS+200, Y_POS-HEIGHT, 200, 150);
		//Obstacle info
		g.drawRect(X_POS+400, Y_POS-150, 200, 150);
		//Item info
		g.drawRect(X_POS+600, Y_POS-150, 200, 150);*/
		
		/*if(creature != null){
			creature.drawInfo(g, X_POS+200, Y_POS);
		}
		if(obstacle != null){
		 obstacle.drawInfo(g, X_POS+400, Y_POS);
		}
		if(loot != null){
			loot.drawInfo(g, X_POS+600, Y_POS);
		}*/
		
	}
	
	
}
