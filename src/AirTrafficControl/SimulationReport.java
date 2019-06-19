package AirTrafficControl;

import java.util.ArrayList;
import java.util.List;

public class SimulationReport {
	static List<String> report = new ArrayList<>();

	public static void addRegistration(String string) {
		report.add("Tower says: " + string + " registered to weather tower.");
	}

	public static void addUpdate(String string) {
		report.add(string);
	}

	public static void addDeregister(String string) {
		landing(string);
		report.add("Tower says: " + string + " unregistered to weather tower.");
	}

	public static void landing(String s) {
		report.add(s +  "landing");
	}

	public static void logLanding(int longitude, int latitude) {
		report.add("Landed at: " + longitude + " " + latitude + " 0");
	}
}