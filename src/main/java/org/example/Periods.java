package org.example;

public class Periods
{

    private final short newSeatsValue;
    private final long getFromInclusive;
    private long toExclusive;

    public Periods(long getFromInclusive, long toExclusive, short newSeatsValue)
    {
        this.newSeatsValue = newSeatsValue;
        this.getFromInclusive = getFromInclusive;
        this.toExclusive = toExclusive;
    }

    public short getNewSeatsValue() {
        return newSeatsValue;
    }


    public long getGetFromInclusive() {
        return getFromInclusive;
    }

    public long getToExclusive() {
        return toExclusive;
    }

    public void setToExclusive(long toExclusive) {
        this.toExclusive = toExclusive;
    }
}
