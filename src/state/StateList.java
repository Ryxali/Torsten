package state;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public enum StateList {
	BUILD(new BuildState(), 0);
	
	private final BasicState state;
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
