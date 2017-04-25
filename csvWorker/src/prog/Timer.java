package prog;

import java.sql.Timestamp;

public class Timer {

	static long last_time;
	static Timestamp timestamp;
	static long time = System.nanoTime();
	static double delta_time = ((time - last_time) / 1000000);

	public static void init() {
		last_time = System.nanoTime();
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Timer init: " + timestamp);
	}

	public static void now() {
		time = System.nanoTime();
		delta_time = ((time - last_time) / 1000000);
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Current Time: " + timestamp + "\nTimeDiff: " + delta_time / 1000d);
		last_time = time;
	}

}
