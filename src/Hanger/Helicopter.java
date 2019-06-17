package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.WeatherTower;

public class Helicopter implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        new Aircraft(name, coordinates);
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {

    }
}
