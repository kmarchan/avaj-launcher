package Hanger;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    protected Aircraft(String name, Coordinates coordinates) {
        this.setName(name);
        this.setCoordinates(coordinates);
        this.id = nextId();
    }

    public long nextId() {
        return this.idCounter++;
    }

}