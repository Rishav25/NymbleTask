package Passenger;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import Activity.Activity;
import Destination.Destination;
import Passenger.Passenger.GoldPassenger;
import Passenger.Passenger.StandardPassenger;

import static org.junit.Assert.*;

public class PassengerTest {
    private StandardPassenger stdPassenger;
    private GoldPassenger gldPassenger;

    @Before
    public void setUp() {
        ArrayList<Activity> activites = new ArrayList<Activity>();
        stdPassenger = new StandardPassenger("Sachin Tendulkar", "9933445566", 45000, activites);
        gldPassenger = new GoldPassenger("Sourav Ganguly", "992233445566", 55000, activites);
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Kashmir", null);
        Activity activity = new Activity("Trekking", "Description", 2000, 10, destination);
        stdPassenger.addActivity(activity);

        assertEquals(1, stdPassenger.getActivities().size());
        assertEquals("Trekking", stdPassenger.getActivities().get(0).getName());
    }

    @Test
    public void testPrintPassengerDetails() {
        Destination destination = new Destination("Kashmir", null);
        Activity activity = new Activity("Trekking", "Description", 2000, 10, destination);
        gldPassenger.addActivity(activity);
        assertEquals(53200.0, gldPassenger.getBalance(), 0.0);
    }

}
