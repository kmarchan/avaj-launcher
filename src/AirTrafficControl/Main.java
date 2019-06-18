package AirTrafficControl;

import Hanger.AircraftFactory;
import SimulationException.InputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InputException, FileNotFoundException, UnsupportedEncodingException {

		if (args.length != 1) { throw new InputException ("This program will take one and only one argument");}
		File file = new File(args[0]);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		AircraftFactory factory = new AircraftFactory();
		WeatherTower wTower = new WeatherTower();

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
			if (height <= 0) {throw new InputException("The " + type + ", " + name + " is grounded at height of " + height);}
			factory.newAircraft(type, name, lng, lat, height).registerTower(wTower);
		}
		PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
		for (int i = 0; i < SimulationReport.report.size(); i ++ ) {
			writer.println(SimulationReport.report.get(i));
		}
		writer.close();
	}
}

// run in terminal
// find -name "*.java" > sources.txt
// javac -sourcepath @sources.txt
// java AirTrafficControl.Main.java scenario.txt
