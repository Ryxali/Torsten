package square;
/**
 * This enum is designed to hold all types of squares for duplication purposes.
 * For instance; if you wish to replace a specific square you can use the
 * copy method of the Square of choice to replace that square.
 * @author Niklas L
 *
 */
public enum SquareType {
	EMPTY(new BasicSquare(), 0);
	public static final int DIMENSION = 32;
	private final Square square;
	private final short id;
	private SquareType(Square square, int id){
		this.square = square;
		this.id = (short)id;
	}
	public short getID(){
		return id;
	}
	public Square getSquare(){
		return square;
	}
	
	public Square copy(){
		return square.copy();
	}
	public static Square getSquareByID(int id){
		SquareType[] squares = values();
		for (int i = 0; i < squares.length; i++) {
			if(squares[i].id == id){
				return squares[i].square;
			}
		}
		return EMPTY.square;
	}
}
