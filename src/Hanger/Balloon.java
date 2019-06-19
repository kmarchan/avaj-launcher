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
                if (this.coordinates.getHeight() + 4 > 100) {this.coordinates.setHeight(100);}
                else {this.coordinates.setHeight(this.coordinates.getHeight() + 4);}
                this.coordinates.setLongitude(this.coordinates.getLongitude() +2);
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): What a lovely sunny day");
            case "RAIN":
                if (this.coordinates.getHeight() - 5 <= 0) {
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): It's raining, not a good day to be flying");
            case "FOG":
                if (this.coordinates.getHeight() - 3 <= 0) {
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): Can't see a thing!");
            case "SNOW":
                if (this.coordinates.getHeight() - 15 <= 0) {
                    SimulationReport.addDeregister("Balloon#" + this.name + "(" + this.id + ")");
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 5);}
                SimulationReport.addUpdate("Balloon#" + this.name + "(" + this.id + "): Too cold! going down!");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("Balloon#" +this.name + "(" + this.id + ")");
    }
}
