package ir.mci.tv;

public class Control {
	
	private State state;
	
	public Control() {
		this.state = State.DEFAULT_STATE;
	}
	
	public Control(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public void dispatch(Action action) {
		if (action == null) {
			state = State.DEFAULT_STATE;
			return;
		}
		action.setState(state);
		state = action.doAction();
	}
}
