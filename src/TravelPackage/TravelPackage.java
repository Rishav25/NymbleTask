package TravelPackage;

import java.util.*;

import Activity.Activity;
import Destination.Destination;
import Passenger.Passenger;

public class TravelPackage {
    private String name;
    private int capacity;
    private int spacesLeft;
    private ArrayList<Destination> destinations;
    private ArrayList<Passenger> passengers;

    // Constructor
    public TravelPackage(String name, int capacity, ArrayList<Destination> destinations,
            ArrayList<Passenger> passengers) {
        this.name = name;
        this.capacity = capacity;
        this.spacesLeft = capacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public void printItinerary() {
        System.out.println("Package Name : " + this.name + "\n");
        System.out.println("Destinations : ");
        for (Destination des : this.destinations) {
            System.out.println("Destination Name : " + des.getName());
            for (Activity act : des.getActivities()) {
                System.out.println("Activity Name " + act.getName());
                System.out.println("Activity Cost " + act.getCost());
                System.out.println("Activity Capacity " + act.getCapacity());
                System.out.println("Activity Description " + act.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Package Name : " + this.name);
        System.out.println("Passenger Capacity : " + this.capacity);
        System.out.println("Passengers Enrolled : " + this.passengers.size() + "\n");
        System.out.println("Passengers : ");
        for (Passenger p : this.passengers) {
            System.out.println("Name : " + p.getName());
            System.out.println("Number : " + p.getNumber() + "\n");
        }
    }

    public void printAvailableActivities() {
        System.out.println("Activities available : " + "\n");
        for (Destination des : this.destinations) {
            for (Activity act : des.getActivities()) {
                if (act.getSpacesLeft() > 0) {
                    System.out.println("Activity Name " + act.getName());
                    System.out.println("Activity Cost " + act.getCost());
                    System.out.println("Activity Capacity " + act.getCapacity());
                    System.out.println("Activity Description " + act.getDescription());
                }
            }
        }
    }

    public void addPassenger(Passenger passenger) {
        int spacesLeft = this.spacesLeft;
        if (spacesLeft > 0) {
            this.passengers.add(passenger);
            this.spacesLeft = spacesLeft - 1;
        } else {
            System.out.println("Package Full");
        }
    }

    public void removePassenger(Passenger passenger) {
        int spacesLeft = this.spacesLeft;
        for (Passenger p : this.passengers) {
            if (p.equals(passenger)) {
                this.passengers.remove(passenger);
                this.spacesLeft = spacesLeft + 1;
                return;
            }
        }
    }

    // Standard getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public ArrayList<Destination> getDestinations() {
        return this.destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    public void removeDestination(Destination destination) {
        this.destinations.removeIf(dest -> (dest.equals(destination)));
    }

    public int getSpacesLeft() {
        return this.spacesLeft;
    }

    public void setSpacesLeft(int spacesLeft) {
        this.spacesLeft = spacesLeft;
    }
}
