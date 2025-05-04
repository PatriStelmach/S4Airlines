package org.example;

public class Period
{
    long fromInclusive, toExclusive; // [from, to)
    int seats;

    Period(long from, long to, int seats) {
        this.fromInclusive = from;
        this.toExclusive = to;
        this.seats = seats;
    }

}
