package square;

public class BasicSquare extends Square{

	@Override
	public Square copy() {
		
		return new BasicSquare();
	}

}
