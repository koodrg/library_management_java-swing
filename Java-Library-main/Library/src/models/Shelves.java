package models;

public class Shelves {
    int id;
    String shelf;
    String floor;

    public Shelves(int id, String shelf, String floor) {
        this.id = id;
        this.shelf = shelf;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
