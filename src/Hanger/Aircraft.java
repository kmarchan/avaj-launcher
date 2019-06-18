package Hanger;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

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

    public long getId() {
        return id;
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
