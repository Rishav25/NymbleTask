// Pacakage activity is used

package Activity;

import Destination.Destination;

public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private int spacesLeft;
    private Destination destination;

    // Constructor
    public Activity(String name, String description, int cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.spacesLeft = capacity;
        this.destination = destination;
    }

    // Standard getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpacesLeft() {
        return this.spacesLeft;
    }

    public void setSpacesLeft(int spacesLeft) {
        this.spacesLeft = spacesLeft;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}