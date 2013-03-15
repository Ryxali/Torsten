package square;

public class SquareList {
	private Square[] squares;
	
	public SquareList(){
		SquareType[] squareTypes = SquareType.values();
		squares = new Square[squareTypes[squareTypes.length].getID()];
		addSquaresInPlace(squareTypes);
	}
	
	private void addSquaresInPlace(SquareType[] squareTypes){
		for (int i = 0; i < squareTypes.length; i++) {
			squares[squareTypes[i].getID()] = squareTypes[i].getSquare();
		}
	}
	
	public Square getSquareByID(int id){
		return squares[id];
	}
}
