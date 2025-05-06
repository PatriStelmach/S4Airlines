package integration;

import org.example.App;
import org.example.FastReader;
import org.example.Models.Flight;
import org.example.Models.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegrationTests
{

    private Plane[] flights;


    @BeforeEach
    void setup()
    {
        flights = new Plane[] {
                new Plane((short) 0),
                new Plane((short) 10),
                new Plane((short) 20),
                new Plane((short) 100)
        };
    }

    @Test
    void testInput()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> App.validateInputSizes(10_000_001, 10_000_001));
    }

    @Test
    void testReadPlanes()
    {
        FastReader mockFr = mock(FastReader.class);
        when(mockFr.nextShort())
                .thenReturn((short) 10)
                .thenReturn((short) 20);

        Plane[] planes = App.readPlanes(mockFr, 2);

        assertEquals(3, planes.length);
        assertEquals(10, planes[1].getSeatsByDay(1));
        assertEquals(20, planes[2].getSeatsByDay(1));
    }


    @Test
    void testP()
    {
        FastReader mockFr = mock(FastReader.class);

        when(mockFr.nextInt())
                .thenReturn(2);
        when(mockFr.nextShort())
                .thenReturn((short) 10);
        when(mockFr.nextLong())
                .thenReturn(10L);
        App.handleChangePassengers(mockFr, flights);
        assertEquals(10 * 10L + 10 * 20, flights[2].getSeatsByDay(20L));

    }

    @Test
    void testC()
    {
        FastReader mockFr = mock(FastReader.class);

        when(mockFr.nextInt())
                .thenReturn(2);
        when(mockFr.nextLong())
                .thenReturn(10L);
        App.handleSetInactiveFromDay(mockFr, flights);
        assertEquals(0, flights[2].getSeatsByDay(10L));
    }

    @Test
    void testA()
    {
        FastReader mockFr = mock(FastReader.class);

        when(mockFr.nextInt())
                .thenReturn(2);
        when(mockFr.nextShort())
                .thenReturn((short) 10);
        when(mockFr.nextLong())
                .thenReturn(10L);
        App.handleChangeRoute(mockFr, flights);
        assertEquals(10 * 10L, flights[2].getSeatsByDay(20L));
    }

    @Test
    void testQ()
    {
        FastReader mockFr = mock(FastReader.class);
        List<Long> answer = new ArrayList<>();

        when(mockFr.nextInt()).thenReturn(1).thenReturn(3);
        when(mockFr.nextLong()).thenReturn(20L);


        App.handleQuery(mockFr, flights, answer);

        assertEquals(1, answer.size());
        assertEquals(10 * 20L + 20 * 20L + 100 * 20L, answer.getFirst());
    }
}
