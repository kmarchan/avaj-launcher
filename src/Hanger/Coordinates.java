package Hanger;

import SimulationException.InputException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;


    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    Coordinates(int longitude, int latitude, int height) throws InputException {
    	this.setHeight(height >= 100 ? 100 : height);
        if (longitude >= 0) {this.setLongitude(longitude);}
        if (latitude >= 0) {this.setLatitude(latitude);}
        else { throw new InputException(longitude + " " + latitude + " " + height + " are invalid coordinates"); }
    }
}