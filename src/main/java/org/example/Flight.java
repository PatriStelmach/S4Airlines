package org.example;

public class Flight
{
    private long fromInclusive;
    private long toExclusive;
    private short seats;
    private boolean areSeatsChanged = false;
    private Period period;
    private long allPassengers = 0;


    Flight(long from,short seats)
    {
        this.fromInclusive = from;
        this.seats = seats;
        this.toExclusive = 100000000000L;
    }
    //P
    public void addNewPeriod(long from, short newPeriodSeats)
    {
        allPassengers = (from - fromInclusive) * seats;
        fromInclusive = from;
        seats = newPeriodSeats;
        setPeriodChanged(true);

    }

    public long getFromInclusive() {
        return fromInclusive;
    }

    public long getToExclusive() {
        return toExclusive;
    }

    public void setToExclusive(long toExclusive) {
        this.toExclusive = toExclusive;
    }
    public void setFromInclusive(long toExclusive) {
        this.fromInclusive = fromInclusive;
    }

    public short getSeats()
    {
        return seats;
    }
    public void setSeats(short seats)
    {
        this.seats = seats;
    }


    public boolean isPeriodChanged() {
        return areSeatsChanged;
    }

    public void setPeriodChanged(boolean areSeatsChanged) {
        this.areSeatsChanged = areSeatsChanged;
    }

    public long getAllPassengers() {
        return allPassengers;
    }

    public void setAllPassengers(long allPassengers) {
        this.allPassengers = allPassengers;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
