package org.example.Models;


public class Plane
{
    private Flight flight;

    public Plane(short passengers)
    {
        flight = new Flight(0L, passengers);
    }
    //A
    public void newRoute(long day, short seats)
    {
        flight = new Flight(day, seats);
    }
    //P
    public void changePassengers(long day, short seats)
    {
        if(flight.getToExclusive() <= day) return;
        flight.changeSeats(day, seats);
    }

    //Q
    public long getSeatsByDay(long maxDay)
    {
        if(flight.getToExclusive() <= maxDay) return 0;

        return flight.getAllPassengers() + (flight.getSeats() * (maxDay - flight.getFromInclusive()));
    }

    //C
    public void setInactive(long day)
    {
        flight.setToExclusive(day);
    }

}
