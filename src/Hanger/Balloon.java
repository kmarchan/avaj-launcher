package Hanger;

import AirTrafficControl.Flyable;
import AirTrafficControl.SimulationReport;
import AirTrafficControl.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): What a lovely sunny day");
                if (this.coordinates.getHeight() + 4 > 100) {this.coordinates.setHeight(100);}
                else {this.coordinates.setHeight(this.coordinates.getHeight() + 4);}
                this.coordinates.setLongitude(this.coordinates.getLongitude() +2);
            case "RAIN":
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): It's raining, not a good day to be flying");
                if (this.coordinates.getHeight() - 5 <= 0) {
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
            case "FOG":
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): Can't see a thing!");
                if (this.coordinates.getHeight() - 3 <= 0) {
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
            case "SNOW":
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): Too cold! going down!");
                if (this.coordinates.getHeight() - 15 <= 0) {
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("Balloon#" +this.name + "(" + this.id + ")");
    }
}
