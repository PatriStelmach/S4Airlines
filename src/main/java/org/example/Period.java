package org.example;

public class Period
{

    private final short newSeatsValue;
    private final long getFromInclusive;
    private long toExclusive = 100000000000L;

    public Period(long getFromInclusive, short newSeatsValue)
    {
        this.newSeatsValue = newSeatsValue;
        this.getFromInclusive = getFromInclusive;
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
