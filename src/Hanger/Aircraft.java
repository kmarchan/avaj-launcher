package Hanger;

import AirTrafficControl.Coordinates;

public class Aircraft {

    protected int id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected Aircraft(String name, Coordinates coordinates) {
        this.setName(name);
        this.setCoordinates(coordinates);
    }

    public long nextId() {
        return this.idCounter++;
    }

}
