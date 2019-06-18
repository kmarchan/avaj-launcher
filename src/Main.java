import AirTrafficControl.Tower;
import AirTrafficControl.WeatherTower;
import Hanger.AircraftFactory;
import SimulationException.InputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InputException {

		if (args.length != 1) { throw new InputException ("This program will take one and only one argument");}
		File file = new File(args[0]);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		AircraftFactory factory = new AircraftFactory();
		WeatherTower wtower = new WeatherTower();

		String type;
		String name;
		int lng;
		int lat;
		int height;
		int repeat = sc.nextInt();
		while (sc.hasNext()) {
			type = sc.next();
			name = sc.next();
			lng = sc.nextInt();
			lat = sc.nextInt();
			height = sc.nextInt();
			factory.newAircraft(type, name, lng, lat, height).registerTower(wtower);
		}
	}
}

// run in terminal
// javac -sourcepath @sources.txt
// java Main.java scenario.txt
// java Main.java scenario.txt
