package hackathon22;

import java.util.Random;

public enum MState {
	//the 3 different machine states
	AUTO,
	MANUAL,
	FAILURE;
	
	public static MState random() {
		return MState.values()[new Random().nextInt(MState.values().length)];
	}
}
