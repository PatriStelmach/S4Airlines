package org.example;

public class Period
{
    private long getFromInclusive, toExclusive; // [from, to)
    private short seats;
    private boolean newSeats = false;
    private short newSeatsValue = 0;
    private long newSeatsDay = Long.MAX_VALUE;
    private long inactiveFrom = Long.MAX_VALUE;

    Period(long from, long to, short seats)
    {
        this.getFromInclusive = from;
        this.toExclusive = to;
        this.seats = seats;
    }

    public long getFromInclusive() {
        return getFromInclusive;
    }

    public void setFromInclusive(long fromInclusive) {
        this.getFromInclusive = fromInclusive;
    }

    public long getToExclusive() {
        return toExclusive;
    }

    public void setToExclusive(long toExclusive) {
        this.toExclusive = toExclusive;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(short seats) {
        this.seats = seats;
    }

    public long getInactiveFrom() {
        return inactiveFrom;
    }

    public void setInactiveFrom(long inactiveFrom) {
        this.inactiveFrom = inactiveFrom;
    }

    public boolean isNewSeats() {
        return newSeats;
    }

    public void setNewSeats(boolean newSeats)
    {
        this.newSeats = newSeats;
    }

    public short getNewSeatsValue()
    {
        return newSeatsValue;
    }

    public void setNewSeatsValue(short newSeatsValue)
    {
        this.newSeatsValue = newSeatsValue;
    }

    public long getNewSeatsDay() {
        return newSeatsDay;
    }

    public void setNewSeatsDay(long newSeatsDay) {
        this.newSeatsDay = newSeatsDay;
    }
}
