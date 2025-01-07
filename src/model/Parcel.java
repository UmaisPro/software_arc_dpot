package model;

public class Parcel {
    private String id;
    private double weight;
    private String destination;

    public Parcel(String id, double weight, String destination) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return destination;
    }
}
