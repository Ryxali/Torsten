package core.state;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 * A list of states
 * @author Niklas L
 * @see BasicState
 * @deprecated I have doubts this is useful when we're working with so few states.
 */
public enum StateList {
	BUILD(new BuildState(), 0);
	/**
	 * The state in question
	 */
	private final BasicState state;
	/**
	 * The id of the state
	 */
	private final int id;
	private StateList(BasicState state, int id){
		this.state = state;
		this.id = id;
	}

	public BasicState getState(){
		return state;
	}
	
	public int getID(){
		return id;
	}
	
	/*public static void enterState(StateBasedGame sbg, int stateID){
		StateList[] temp = values();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].id == stateID){
				sbg.enterState(stateID);
			}
		}
	}*/
}
