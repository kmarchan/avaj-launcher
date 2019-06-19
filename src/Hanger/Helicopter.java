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
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                SimulationReport.addUpdate("Helicopter#" + this.name + "(" + this.id + "): This is hot");
                if (this.coordinates.getHeight() + 2 > 100) {this.coordinates.setHeight(100);}
                else {this.coordinates.setHeight(this.coordinates.getHeight() + 2);}
                this.coordinates.setLongitude(this.coordinates.getLongitude()+10);
            case "RAIN":
                SimulationReport.addUpdate("Helicopter#" + this.name + "(" + this.id + "): I hate the rain!");
                this.coordinates.setLongitude(this.coordinates.getLongitude()+5);
            case "FOG":
                SimulationReport.addUpdate("Helicopter#" + this.name + "(" + this.id + "): Flying blind here!");
                this.coordinates.setLongitude(this.coordinates.getLongitude()+1);
            case "SNOW":
                SimulationReport.addUpdate("Helicopter#" + this.name + "(" + this.id + "): My rotor is going to freeze!");
                if (this.coordinates.getHeight() - 15 <= 0) {
                    SimulationReport.addDeregister("Helicopter#" + this.name + "(" + this.id + ")");
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 12);}
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("Helicopter#" + this.name + "(" + this.id + ")");
    }
}
