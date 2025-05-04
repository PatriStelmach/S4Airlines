package org.example;

import java.util.*;


public class Plane
{

    private List<Period> periods = new ArrayList<>();
    private short passengers;

    public Plane(short passengers)
    {
        this.passengers = passengers;
        periods.add(new Period(0L, Long.MAX_VALUE, passengers));

    }

    public void changeRoute(long day, short seats)
    {
        periods.getLast().setToExclusive(day);
        periods.add(new Period(day, Long.MAX_VALUE, seats));
    }

    public void changePassengers(long day, short seats)
    {
        periods.getLast().setToExclusive(day);
        periods.add(new Period(day, Long.MAX_VALUE, seats));
    }


    public int getSeatsByDay(long day, long maxDay)
    {
        for (Period p : periods)
        {
            if (p.getFromInclusive() <= day && day < p.getToExclusive() && maxDay <= p.getToExclusive())
            {
                return p.getSeats();
            }
        }
        return 0;
    }

    public void setInactiveFromDay(long day)
    {
        if(periods.isEmpty()) return;
        Period last = periods.getLast();
        if (last.getToExclusive() > day)
        {
            last.setToExclusive(day);
            last.setInactiveFrom(day);
        }

    }


}
