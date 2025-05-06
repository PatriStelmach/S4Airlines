package system;

import org.example.App;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTests
{
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp()
    {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown()
    {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testFirstAppCall()
    {
        // GIven
        String input =
                        """
                        5 7
                        1 2 3 2 4
                        Q 1 5 2
                        Q 2 3 2
                        C 2 3
                        P 3 5 3
                        Q 2 4 4
                        A 2 5 6
                        Q 1 5 8
                        """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        App.appCall();

        // Then
        String[] outputLines = outContent.toString().split(System.lineSeparator());
        assertEquals(4, outputLines.length);
        assertEquals("24", outputLines[0]);
        assertEquals("10", outputLines[1]);
        assertEquals("22", outputLines[2]);
        assertEquals("100", outputLines[3]);

    }

    @Test
    void testSecondsAppCall()
    {
        // GIven
        String input =
                        """
                        1 7
                        2
                        Q 1 1 1
                        C 1 1
                        A 1 6 2
                        Q 1 1 3
                        Q 1 1 4
                        Q 1 1 7
                        Q 1 1 8
                        """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        App.appCall();

        // Then
        String[] outputLines = outContent.toString().split(System.lineSeparator());
        assertEquals(5, outputLines.length);
        assertEquals("2", outputLines[0]);
        assertEquals("6", outputLines[1]);
        assertEquals("12", outputLines[2]);
        assertEquals("30", outputLines[3]);
        assertEquals("36", outputLines[4]);
    }
}
