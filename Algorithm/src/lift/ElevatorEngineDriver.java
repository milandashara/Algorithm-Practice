package lift;

public class ElevatorEngineDriver {
	public static void main(String[] args) {
		ElevatorEngine engine = new ElevatorEngine();
		engine.startEngine();
		//start from 0. Got to 1st floor
		engine.pressButton(1);
		sleep();
		engine.pressButton(5);
		engine.pressButton(6);
		engine.pressButton(1);
		engine.pressButton(4);
		sleep();
		sleep();
		sleep();
		engine.pressButton(2);
		engine.pressButton(9);
		engine.pressButton(1);
		sleep();
		engine.stopEngine();
		try {
			engine.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
