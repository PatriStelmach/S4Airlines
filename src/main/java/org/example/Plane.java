package org.example;

import java.util.Map;
import java.util.TreeMap;


public class Plane
{
    private TreeMap<Long, Flight> flights;
    private short seats;
    private long inactiveFromDay = Long.MAX_VALUE;
    private long inactiveToDay = 0L;
    private boolean changed = false;
    private long changedSeatsDay;

    public Plane(short seats)
    {
        this.seats = seats;
        this.flights = new TreeMap<>(Map.of(0L, new Flight(seats, true)));

    }


    public void changeSeatsFromDay(long day, short newSeats)
    {
        if(isActiveOnDay(day))
        {
            flights.put(day + 1, new Flight(newSeats, true));
            setChangedSeatsDay(day + 1);
            setChanged(true);
        }
    }


    public void changeFlight(long day, short passengers)
    {
        if(!isActiveOnDay(day) && day >= inactiveFromDay)
        {
            inactiveToDay = day - 1L;
        }

        if(flights.containsKey(day))
        {
            flights.get(day).setPassengers(passengers);
        }
        else
        {
            flights.put(day, new Flight(passengers, true));
        }

    }


    public short getSeatsByDay(long day)
    {
        if (day >= inactiveFromDay)
        {
            return 0;
        }

        Map.Entry<Long, Flight> entry = flights.floorEntry(day);

        if (entry == null)
        {
            return seats;
        }

        if (!entry.getValue().isActive())
        {
            return 0;
        }

        return entry.getValue().getPassengers();
    }



    public void setInactiveFromDay(long day)
    {
        this.inactiveFromDay = day;
        flights.tailMap(day, true).clear();
        setInactiveToDay(Long.MAX_VALUE);

    }
    public void setInactiveToDay(long day)
    {
        this.inactiveToDay = day;
        flights.get(day).setActive(false);

    }

    public boolean isActiveOnDay(long day)
    {
        return flights.get(day) == null || flights.get(day).isActive();
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public long getChangedSeatsDay() {
        return changedSeatsDay;
    }

    public void setChangedSeatsDay(long changedSeatsDay) {
        this.changedSeatsDay = changedSeatsDay;
    }
}
