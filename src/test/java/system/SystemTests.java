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
                        "5 7\n" +
                        "1 2 3 2 4\n" +
                        "Q 1 5 2\n" +
                        "Q 2 3 2\n"+
                        "C 2 3\n"+
                        "P 3 5 3\n"+
                        "Q 2 4 4\n"+
                        "A 2 5 6\n"+
                        "Q 1 5 8\n";

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
                        "1 7\n" +
                        "2\n" +
                        "Q 1 1 1\n" +
                        "C 1 1\n"+
                        "A 1 6 2\n"+
                        "Q 1 1 3\n"+
                        "Q 1 1 4\n"+
                        "Q 1 1 7\n"+
                        "Q 1 1 8\n";

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
