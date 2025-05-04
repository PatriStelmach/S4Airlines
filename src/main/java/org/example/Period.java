package org.example;

public class Period
{
    private long getFromInclusive, toExclusive; // [from, to)
    private int seats;
    private long inactiveFrom = Long.MAX_VALUE;

    Period(long from, long to, int seats) {
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

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public long getInactiveFrom() {
        return inactiveFrom;
    }

    public void setInactiveFrom(long inactiveFrom) {
        this.inactiveFrom = inactiveFrom;
    }
}
