package org.example;

import java.util.*;


public class Plane
{
    private final List<Flight> flights = new ArrayList<>();

    public Plane(short passengers)
    {
        flights.add(new Flight(0L, 100000000000L, passengers));
    }

    public void changeRoute(long day, short seats)
    {
        flights.getLast().setToExclusive(day);
        flights.add(new Flight(day, 100000000000L, seats));
    }
    public void changePassengers(long day, short seats)
    {
        flights.getLast().addNewPeriod(day, 100000000000L, seats);
    }

    public short getSeatsByDay(long day, long maxDay)
    {
        for (Flight f : flights)
        {
            //C
            if(maxDay > f.getInactiveFrom())
            {
                continue;
            }
            //P
            if  (f.isPeriodChanged() && f.getFromInclusive() <= day && day < f.getToExclusive())
            {
                    return f.getPeriodSeats(day);
            }
            //A or no changes
            if (f.getFromInclusive() <= day && day < f.getToExclusive() && maxDay <= f.getToExclusive())
            {
                return f.getSeats();
            }

        }
      return 0;
    }

    public void setInactiveFromDay(long day)
    {
        if(flights.isEmpty()) return;
        Flight last = flights.getLast();
        if (last.getToExclusive() > day)
        {
            last.setToExclusive(day);
            last.setInactiveFrom(day);
        }
    }

}
