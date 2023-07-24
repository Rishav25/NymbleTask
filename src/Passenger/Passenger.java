package Passenger;

import java.util.ArrayList;

import Activity.Activity;

// Under passenger superclass there are 3 subclasses where the addActivity and removeActivity logic is different
// in each of the subclasses

public class Passenger {
    // Activites can be added/removed for each passenger
    // When the activites are added we check if there is space available and
    // print a statement if no space is available
    // balance is applicable to Standard and Gold passengers hence balance is a
    // member of these two classes

    // protected variables ensure that the child classes can access them
    protected String name;
    protected String number;
    protected ArrayList<Activity> activities;

    // printing the details of an individual passenger
    // while printing we check what is the instanceOf the current object
    // and based on that we print the activity cost and the balance
    public void printPassengerDetails() {
        System.out.println("Passenger Details : ");
        System.out.println("Name : " + this.name);
        System.out.println("Number : " + this.number);
        for (Activity a : this.activities) {
            System.out.println("Activity Name : " + a.getName());
            System.out.println("Activity Destination : " + a.getDestination().getName());
            if (this instanceof StandardPassenger) {
                StandardPassenger stdPass = (StandardPassenger) this;
                System.out.println("Activity Cost : " + a.getCost());
                System.out.println("Balance : " + stdPass.getBalance());
            }
            if (this instanceof GoldPassenger) {
                GoldPassenger gldPass = (GoldPassenger) this;
                System.out.println("Activity Cost : " + a.getCost() * 0.9);
                System.out.println("Balance : " + gldPass.getBalance());
            }
            if (this instanceof PremiumPassenger) {
                System.out.println("Activity Cost : 0");
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    public static class StandardPassenger extends Passenger {
        private double balance;

        // Constructor
        public StandardPassenger(String name, String number, double balance, ArrayList<Activity> activities) {
            this.name = name;
            this.number = number;
            this.balance = balance;
            this.activities = activities;
        }

        public void addActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            double balance = this.balance;
            if (spacesLeft > 0) {
                double newBalance = balance - activity.getCost();
                if (newBalance >= 0) {
                    this.activities.add(activity);
                    this.balance = newBalance;
                    activity.setSpacesLeft(spacesLeft - 1);
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Activity Full");
            }
        }

        public void removeActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            double balance = this.balance;
            for (Activity a : this.activities) {
                if (a.equals(activity)) {
                    this.activities.remove(activity);
                    double newBalance = balance + activity.getCost();
                    this.balance = newBalance;
                    activity.setSpacesLeft(spacesLeft + 1);
                    return;
                }
            }
        }

        // Standard getter and setter methods

        public double getBalance() {
            return this.balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

    }

    public static class GoldPassenger extends Passenger {
        private double balance;

        // Constructor
        public GoldPassenger(String name, String number, double balance, ArrayList<Activity> activities) {
            this.name = name;
            this.number = number;
            this.balance = balance;
            this.activities = activities;
        }

        public void addActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            double balance = this.balance;
            if (spacesLeft > 0) {
                double newBalance = balance - (0.9 * activity.getCost());
                if (newBalance >= 0) {
                    this.activities.add(activity);
                    this.balance = newBalance;
                    activity.setSpacesLeft(spacesLeft - 1);
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Activity Full");
            }
        }

        public void removeActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            double balance = this.balance;
            for (Activity a : this.activities) {
                if (a.equals(activity)) {
                    this.activities.remove(activity);
                    double newBalance = balance + (0.9 * activity.getCost());
                    this.balance = newBalance;
                    activity.setSpacesLeft(spacesLeft + 1);
                    return;
                }
            }
        }

        // Standard getter and setter methods

        public double getBalance() {
            return this.balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    public static class PremiumPassenger extends Passenger {
        // Constructor
        public PremiumPassenger(String name, String number, ArrayList<Activity> activities) {
            this.name = name;
            this.number = number;
            this.activities = activities;
        }

        public void addActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            if (spacesLeft > 0) {
                this.activities.add(activity);
                activity.setSpacesLeft(spacesLeft - 1);
            } else {
                System.out.println("Activity Full");
            }
        }

        public void removeActivity(Activity activity) {
            int spacesLeft = activity.getSpacesLeft();
            for (Activity a : this.activities) {
                if (a.equals(activity)) {
                    this.activities.remove(activity);
                    activity.setSpacesLeft(spacesLeft + 1);
                    return;
                }
            }
        }
    }

}
