package gui.brush;

/**
 * This class stores the size and shape information of a brush.
 * 
 * @see Brush
 * @see Brushes
 */
public class BrushInfo {
	/**
	 * the size of this brush. For rectangles this stands for the width and
	 * height of the brush, for circles it stands for the diameter of the brush.
	 * The brush value stands for size in squares.
	 */
	private int size;
	/**
	 * The shape of the brush, as Specified by the SHAPE_... variables of this class.
	 */
	private boolean shape;
	/**
	 * The value of a Square shaped Brush.
	 */
	public static final boolean SHAPE_SQUARE = true;
	/**
	 * The value of a Circle shaped Brush.
	 */
	public static final boolean SHAPE_CIRCLE = false;
	/**
	 * Constructs a new set of BrushInfo with the given size and shape.
	 * @param size the size of the brush, in squares.
	 * @param shape the shape of the brush.
	 */
	public BrushInfo(int size, boolean shape) {
		this.size = size;
		this.shape = shape;
	}
	/**
	 * Get the size of the brush.
	 * @return size, the size of this brush, in squares.
	 */
	public int getSize() {
		return size - size % 2;
	}
	/**
	 * Get the shape of the brush.
	 * @return shape, the shape of this brush.
	 */
	public boolean getShape() {
		return shape;
	}
}
