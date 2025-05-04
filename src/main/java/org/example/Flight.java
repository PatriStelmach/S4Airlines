package org.example;

public class Flight
{
    private long day;
    private short passengers;
    private int route;

    public Flight(long day, short passengers, int route)
    {
        this.day = day;
        this.passengers = passengers;
        this.route = route;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public short getPassengers() {
        return passengers;
    }

    public void setPassengers(short passengers) {
        this.passengers = passengers;
    }

    public int getRoute() {
        return route;
    }
    public void setRoute(int route) {
        this.route = route;
    }


}