package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.WeatherTower;

public class JetPlane implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        new Aircraft(name, coordinates);
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {

    }
}
