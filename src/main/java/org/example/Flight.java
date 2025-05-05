package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private final long getFromInclusive;
    private long toExclusive;
    private final short seats;
    private boolean areSeatsChanged = false;
    private long inactiveFrom = 100000000000L;
    private final List<Periods> periods = new ArrayList<>();

    Flight(long from, long to, short seats)
    {
        this.getFromInclusive = from;
        this.toExclusive = to;
        this.seats = seats;
    }

    public void addNewPeriod(long from, long to, short newPeriodSeats)
    {
        Periods newSeat = (new Periods(from, to, newPeriodSeats));

        if(areSeatsChanged)
        {
            periods.stream()
                    .filter(ns -> ns.getGetFromInclusive() <= newSeat.getGetFromInclusive()
                    && ns.getToExclusive() >= newSeat.getToExclusive()
                    )
                    .findFirst()
                    .ifPresent(ns -> ns.setToExclusive(from));
        }
        periods.add(newSeat);
        setPeriodChanged(true);
    }

    public short getPeriodSeats(long day)
    {
        return periods.stream()
                .filter(ns -> ns.getGetFromInclusive() <= day && day < ns.getToExclusive())
                .findFirst()
                .map(Periods::getNewSeatsValue)
                .orElse(seats);
    }
    public long getFromInclusive() {
        return getFromInclusive;
    }

    public long getToExclusive() {
        return toExclusive;
    }

    public void setToExclusive(long toExclusive) {
        this.toExclusive = toExclusive;
    }

    public short getSeats() {
        return seats;
    }

    public long getInactiveFrom() {
        return inactiveFrom;
    }

    public void setInactiveFrom(long inactiveFrom) {
        this.inactiveFrom = inactiveFrom;
    }


    public boolean isPeriodChanged() {
        return areSeatsChanged;
    }

    public void setPeriodChanged(boolean areSeatsChanged) {
        this.areSeatsChanged = areSeatsChanged;
    }
}
