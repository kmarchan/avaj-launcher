package AirTrafficControl;

import java.util.ArrayList;
import java.util.List;

public class SimulationReport {
	static List<String> report = new ArrayList<>();

	public static void addRegistration(String string) {
		report.add("Tower says: " + string + " registered to weather tower.");
		}
	}
