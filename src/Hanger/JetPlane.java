package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.SimulationReport;
import AirTrafficControl.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {

        super(name, coordinates);
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("JetPlane#" + this.name + "(" + this.id + ")");
    }
}
