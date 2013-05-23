package gui.brush;

public class BrushInfo {
	private int size;
	private boolean shape;
	
	public static final boolean SHAPE_SQUARE = true;
	public static final boolean SHAPE_CIRCLE = false;
	
	public BrushInfo(int size, boolean shape){
		this.size = size;
		this.shape = shape;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean getShape(){
		return shape;
	}
}
