// Destination Pacakage is used

package Destination;

import java.util.ArrayList;

import Activity.Activity;

public class Destination {
    private String name;
    private ArrayList<Activity> activities;

    public Destination(String name, ArrayList<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    // Standard getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.removeIf(a -> a.equals(activity));
    }
}