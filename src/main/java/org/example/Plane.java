package org.example;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Plane
{
    private int id;
    private List<Route> routes;
    private TreeMap<Long, Integer> flights;
    private boolean isActive = true;

    public Plane(int id, Route route, int seats)
    {
        this.id = id;
        this.routes = new ArrayList<>();
        this.flights = new TreeMap<>(Map.of(
                0L, seats,
                1L, seats,
                2L, seats
        ));
        route.assignPlane(this);
        routes.add(route);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public void addFlight(long day, int passengers)
    {
        flights.put(day, passengers);
    }

    public void changeFlight(long day, int passengers)
    {
        flights.replace(day, passengers);
    }

    public int getSeatsByDay(long day)
    {
        return flights.getOrDefault(day, flights.get(day));
    }

    public List<Route> getRoutes()
    {
        return routes;
    }
    public void addRoute(Route route)
    {
        routes.add(route);
    }
    public void removeRoute(Route route)
    {
        routes.remove(route);
    }

//    @Override
//    public String toString()
//    {
//        return String.format("Plane %d", id);
//    }

}
