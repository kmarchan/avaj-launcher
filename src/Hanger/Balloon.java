package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        new Aircraft(name, coordinates);
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {

    }
}
