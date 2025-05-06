package unit;

import org.example.Models.Flight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightUnitTests
{

    private Flight flight;

    @BeforeEach
    void setup()
    {
        flight = new Flight(0L, (short) 1000);
    }

    @Test
    void testInitialSeats()
    {
        assertEquals(1000, flight.getSeats());
    }

    @Test
    void testChangeSeats()
    {
        flight.changeSeats(100L, (short)0);
        assertEquals(100L * (short)1000, flight.getAllPassengers());
        assertEquals(0, flight.getSeats());
        assertEquals(100L, flight.getFromInclusive());
    }

    @Test
    void testSetToExclusive()
    {
        flight.setToExclusive(20L);
        assertEquals(20L, flight.getToExclusive());
    }

}
