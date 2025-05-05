package org.example;

import java.util.*;


public class Plane
{

    private List<Period> periods = new ArrayList<>();

    public Plane(short passengers)
    {
        periods.add(new Period(0L, Long.MAX_VALUE, passengers));

    }

    public void changeRoute(long day, short seats)
    {
        periods.getLast().setToExclusive(day);
        periods.add(new Period(day, Long.MAX_VALUE, seats));
    }

    public void changePassengers(long day, short seats)
    {
        periods.getLast().setNewSeatsDay(day);
        periods.getLast().setNewSeatsValue(seats);
        periods.getLast().setNewSeats(true);
    }


    public int getSeatsByDay(long day, long maxDay)
    {
        for (int i = 0; i < 2; i++)
        {
//            System.out.println(periods.get(i).getInactiveFrom());

            if(maxDay > periods.get(i).getInactiveFrom())
            {
                continue;
            }
            if (periods.get(i).getFromInclusive() <= day && day < periods.get(i).getToExclusive() && maxDay <= periods.get(i).getToExclusive())
            {
                return periods.get(i).getSeats();
            }
            if(periods.get(i).isNewSeats() && periods.get(i).getNewSeatsDay() <= day)
            {
                return periods.get(i).getNewSeatsValue();
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
