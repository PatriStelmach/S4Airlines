package org.example;

public class Route
{
    private Plane plane;
    private int routeNr;

    public Route(int routeNr)
    {
        this.routeNr = routeNr;
    }

    public void assignPlane(Plane plane)
    {
        if (this.plane != null)
        {
            this.plane.removeRoute(this);
        }
        this.plane = plane;
        if (plane != null)
        {
            plane.addRoute(this);
        }
    }

    public Plane getPlane()
    {
        return plane;
    }

    public int getRouteNr()
    {
        return this.routeNr;
    }

    public void setRouteNr(int routeNr)
    {
        this.routeNr = routeNr;
    }

}
