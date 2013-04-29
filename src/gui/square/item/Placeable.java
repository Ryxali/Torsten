package gui.square.item;

import gui.square.Square;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.image.DrawableXY;

public interface Placeable extends DrawableXY{
	public void onUse(Square square);

}
