package unit;

import org.example.Models.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneUnitTest
{
    private Plane plane;
    @BeforeEach
    void setup()
    {
       plane = new Plane((short) 1000);
    }

    @Test
    void testInitialSeats()
    {
        assertEquals(1000,plane.getSeatsByDay(1L));
    }

    @Test
    void testInactivation()
    {
        plane.setInactive(10L);
        assertEquals(0,plane.getSeatsByDay(10L));
    }

    @Test
    void testChangePassengers()
    {
        plane.changePassengers(10L, (short) 100);
        assertEquals(1000+10_000, plane.getSeatsByDay(20L));
    }
    @Test
    void testNewRoute()
    {
        plane.newRoute(10L, (short) 100);
        assertEquals(100*(200-10) ,plane.getSeatsByDay(200L));
    }

    @Test
    void testGetSeatsByDay()
    {
        assertEquals((short)1000 * 1000L, plane.getSeatsByDay(1000L));
    }
}
