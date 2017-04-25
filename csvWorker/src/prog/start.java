package prog;


public class start {

	public static String path = "C:\\Users\\PakaBelly\\eclipseWS\\WorkStuff\\csvWorker\\files\\";

	public static String file = "allTradableInstruments.csv";
	
	public static void main(String[] args) {
		//method 1
		Timer.init();
		Container c = new Container(path + file, path, 0);
		System.out.println("all tasks completed;");
		Timer.now();
	}

}
