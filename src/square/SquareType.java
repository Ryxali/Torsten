package square;
/**
 * This enum is designed to hold all types of squares for duplication purposes.
 * For instance; if you wish to replace a specific square you can use the
 * copy method of the Square of choice to replace that square.
 * @author Niklas L
 *
 */
public enum SquareType {
	SEXYTHANG(new BasicSquare());
	public static final int DIMENSION = 32;
	private final Square square;
	private SquareType(Square square){
		this.square = square;
	}
	
	public Square copy(){
		return square.copy();
	}
}
