package org.example;

import java.util.*;


public class Plane
{

    private Map<Long, Flight> flightsByDay = new HashMap<>();
    private List<Flight> flights = new ArrayList<>();
    private List<Period> periods = new ArrayList<>();
    private short passengers;
    private long inactiveFromDay = Long.MAX_VALUE;
    private long inactiveToDay = -1L;
    private boolean changedPassengers = false;
    private long changedPassengersDay = -1L;
//    private short changedSeats;
    private boolean changedRoute = false;
    private long changedRouteDay = -1L;
//    private short changedRouteSeats;
    private int routeCount = 0;

    public Plane(short passengers)
    {
        this.passengers = passengers;
        Flight initialFlight = new Flight(0L, passengers, routeCount);
        this.flights.add(initialFlight);
        this.flightsByDay.put(0L, initialFlight);
        periods.add(new Period(0L, Long.MAX_VALUE, passengers));

    }

    private Flight findFlightByDay(long day)
    {
        return flightsByDay.get(day);
    }

    public void changeRoute(long day, short seats)
    {
        setInactiveFromDay(day);
        periods.add(new Period(day, Long.MAX_VALUE, seats));
    }

    public void changePassengers(long day, short seats)
    {
        setInactiveFromDay(day);
        periods.add(new Period(day, Long.MAX_VALUE, seats));
    }


    public int getSeatsByDay(long day, long maxDay)
    {
        for (Period p : periods)
        {
            if (p.fromInclusive <= day && day < p.toExclusive && maxDay <= p.toExclusive) {
                return p.seats;
            }
        }
        return 0;
    }



    public void setInactiveFromDay(long day)
    {
        if(periods.isEmpty()) return;
        Period last = periods.getLast();
        if (last.toExclusive > day) {
            last.toExclusive = day;
        }


    }
    public void setInactiveToDay(long day)
    {
        this.inactiveToDay = day;
    }

    public boolean isActiveOnDay(long day)
    {
        return day > inactiveToDay || day < inactiveFromDay;
    }

//    public boolean isChangedSeatsCount() {
//        return changedSeatsCount;
//    }
//
    public void setChangedPassengers(boolean changedPassengers) {
        this.changedPassengers = changedPassengers;
    }
//
//
    public void setChangedPassengersDay(long changedPassengersDay)
    {
        this.changedPassengersDay = changedPassengersDay;
    }
//
//
//    public void setChangedSeats(short changedSeats) {
//        this.changedSeats = changedSeats;
//    }
//
    public void setChangedRoute(boolean changedRoute) {
        this.changedRoute = changedRoute;
    }
//
    public void setChangedRouteDay(long changedRouteDay) {
        this.changedRouteDay = changedRouteDay;
    }
//
//    public void setChangedRouteSeats(short changedRouteSeats) {
//        this.changedRouteSeats = changedRouteSeats;
//    }
}
