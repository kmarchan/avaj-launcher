package Hanger;

import AirTrafficControl.Flyable;
import SimulationException.InputException;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int latitude, int longitude, int height) throws InputException {
        Coordinates newCoordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase()) {
            case "balloon":
                return (new Balloon(name, newCoordinates));
            case "helicopter":
                return (new Helicopter(name, newCoordinates));
            case "jetplane":
                return (new JetPlane(name, newCoordinates));
            default:
                throw new InputException("Factory is not fitted to produce flyable of " + type + " type");
        }
    }
}
