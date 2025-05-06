package org.example.Models;

public class Flight
{
    private long fromInclusive;
    private long toExclusive;
    private short seats;
    private long allPassengers = 0;

    public Flight(long from,short seats)
    {
        this.fromInclusive = from;
        this.seats = seats;
        this.toExclusive = 100_000_000_001L; // 0 ≤ t ≤10^11
    }
    //P
    public void changeSeats(long from, short newSeats)
    {
        allPassengers = (from - fromInclusive) * seats;
        fromInclusive = from;
        seats = newSeats;
    }

    public long getFromInclusive()
    {
        return fromInclusive;
    }

    public long getToExclusive()
    {
        return toExclusive;
    }

    public void setToExclusive(long toExclusive) {
        this.toExclusive = toExclusive;
    }

    public short getSeats()
    {
        return seats;
    }

    public long getAllPassengers()
    {
        return allPassengers;
    }

}
