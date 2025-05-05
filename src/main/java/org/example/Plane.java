package org.example;

import java.util.*;


public class Plane
{
    private final List<Flight> flights = new ArrayList<>();

    public Plane(short passengers)
    {
        flights.add(new Flight(0L, Long.MAX_VALUE, passengers));
    }

    public void changeRoute(long day, short seats)
    {
        flights.getLast().setToExclusive(day);
        flights.add(new Flight(day, Long.MAX_VALUE, seats));
    }
    public void changePassengers(long day, short seats)
    {
        flights.getLast().addNewPeriod(day, Long.MAX_VALUE, seats);
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
            if  (f.isPeriodChanged())
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
