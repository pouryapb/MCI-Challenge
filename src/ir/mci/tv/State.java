package ir.mci.tv;

public class State {
	
	public static State DEFAULT_STATE = new State(0);
	private int volume;
	
	public State(int volume) {
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}
}
