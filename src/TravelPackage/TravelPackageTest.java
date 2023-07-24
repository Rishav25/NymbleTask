package TravelPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Activity.Activity;
import Destination.Destination;
import Passenger.Passenger;
import Passenger.Passenger.StandardPassenger;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @Before
    public void setUp() {
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        travelPackage = new TravelPackage("Summer Vacation", 50, destinations, passengers);
    }

    @Test
    public void testAddDestination() {
        ArrayList<Activity> activities = new ArrayList<Activity>();

        Destination destination = new Destination("Kashmir", activities);
        travelPackage.addDestination(destination);

        assertEquals(1, travelPackage.getDestinations().size());
        assertEquals("Kashmir", travelPackage.getDestinations().get(0).getName());
    }

    @Test
    public void testAddPassenger() {
        Passenger stdPassenger = new StandardPassenger("Anil Kumble", "0987654321", 20000.0, null);

        travelPackage.addPassenger(stdPassenger);

        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals("Anil Kumble", travelPackage.getPassengers().get(0).getName());
    }
}
