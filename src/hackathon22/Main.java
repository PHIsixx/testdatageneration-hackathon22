package hackathon22;

public class Main {
	public static void main(String[] args) {
		Machine m1 = new Machine("MASCHINE_1",MState.FAILURE,2000,1000);
		m1.start();
	}
}
