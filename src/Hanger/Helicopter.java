package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.SimulationReport;
import AirTrafficControl.WeatherTower;

public class Helicopter extends  Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("Helicopter#" + this.name + "(" + this.id + ")");

    }
}
