package gui.brush;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import gui.square.Grid;
import gui.square.Square;
import gui.square.item.Placeable;
import core.button.GButton;

public class Brush extends GButton {
	private final BrushInfo bInfo;
	public Brush(int brushSize, boolean brushShape){
		super();
		bInfo = new BrushInfo(brushSize, brushShape);
	}
	@Override
	public void draw(Graphics g, int x, int y, int width, int height,
			Input input) {
		super.draw(g, x, y, width, height, input);
	}
	@Override
	public void onClick(Input input) {
		super.onClick(input);
		Grid.get().setBrush(this);
	}
	
	public BrushInfo getBrushDetails(){
		return bInfo;
	}
}
