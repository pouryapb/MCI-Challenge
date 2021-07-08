package ir.mci.tv;

public class Action {
	
	private State state;
	private String action;
	private Object volume;
	
	public Action(String action, Object volume) {
		this.action = action;
		this.volume = volume;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State doAction() {
		
		switch (action) {
		case "inc_volume":
			if (state.getVolume() == 100) {
				return state;
			}
			return new State(state.getVolume() + 1);
		case "dec_volume":
			if (state.getVolume() == 0) {
				return state;
			}
			return new State(state.getVolume() - 1);
		case "set_volume":
			if ((int)volume < 0 || (int)volume > 100) {
				throw new IllegalArgumentException("Unexpected value: " + volume);
			}
			return new State((int) volume);
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
}
