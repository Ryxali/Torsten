package gui.brush;
/**
 * An enum containing the brushes used in this application.
 * @author Niklas L
 *
 */
public enum Brushes {
	SQUARE_1(new Brush(1, BrushInfo.SHAPE_SQUARE)),
	SQUARE_2(new Brush(2, BrushInfo.SHAPE_SQUARE)),
	SQUARE_3(new Brush(3, BrushInfo.SHAPE_SQUARE)),
	SQUARE_4(new Brush(4, BrushInfo.SHAPE_SQUARE)),
	SQUARE_5(new Brush(5, BrushInfo.SHAPE_SQUARE)),
	CIRCLE_1(new Brush(1, BrushInfo.SHAPE_CIRCLE)),
	CIRCLE_2(new Brush(2, BrushInfo.SHAPE_CIRCLE)),
	CIRCLE_3(new Brush(3, BrushInfo.SHAPE_CIRCLE)),
	CIRCLE_4(new Brush(4, BrushInfo.SHAPE_CIRCLE)),
	CIRCLE_5(new Brush(5, BrushInfo.SHAPE_CIRCLE));
	/**
	 * The Brush object this enum stores.
	 */
	private final Brush brush;
	/**
	 * Constructs a new Brush entry.
	 * @param brush the brush to add
	 */
	private Brushes(Brush brush){
		this.brush = brush;
	}
	/**
	 * Get the Brush stored by this enum.
	 * @return brush, the brush stored by this enum.
	 */
	public Brush getBrush(){
		return brush;
	}
}
