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
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                if (this.coordinates.getHeight() + 2 > 100) {this.coordinates.setHeight(100);}
                else {this.coordinates.setHeight(this.coordinates.getHeight() + 2);}
                this.coordinates.setLatitude(this.coordinates.getLatitude()+10);
                SimulationReport.addUpdate("JetPlane#" + this.name + "(" + this.id + "): Beautiful day for flying, would you care for more mimosa?");
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude()+5);
                SimulationReport.addUpdate("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lighting.");
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude()+1);
                SimulationReport.addUpdate("JetPlane#" + this.name + "(" + this.id + "): Relying on my autopilot");
            case "SNOW":
                if (this.coordinates.getHeight() - 7 <= 0) {
                    SimulationReport.addDeregister("JetPlane#" + this.name + "(" + this.id + ")");
                    SimulationReport.logLanding(this.coordinates.getLongitude(), this.coordinates.getLatitude());
                    this.weatherTower.unregister(this);
                }
                else {this.coordinates.setHeight(this.coordinates.getHeight() - 7);}
                SimulationReport.addUpdate("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        SimulationReport.addRegistration("JetPlane#" + this.name + "(" + this.id + ")");
    }
}
