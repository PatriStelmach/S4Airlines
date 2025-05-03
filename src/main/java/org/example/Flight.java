package org.example;

public class Flight
{
    private short passengers;
    private boolean active;

    public Flight(short passengers, boolean active) {
        this.passengers = passengers;
        this.active = active;
    }



    public short getPassengers() {
        return passengers;
    }

    public void setPassengers(short passengers) {
        this.passengers = passengers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
