package squareitems;

import image.DrawableXY;

public interface Placeable extends DrawableXY{
	public void put(Placeable placeable);
}
