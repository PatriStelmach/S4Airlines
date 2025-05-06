package org.example;

import org.example.Models.Plane;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class App
{
    private static long days = 1;
    public static void appCall()
    {
        instruction();

        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try
        {
            int n = fr.nextInt();
            int q = fr.nextInt();
            validateInputSizes(n, q);

            Plane[] flights = readPlanes(fr, n);
            List<Long> answer = processCommands(fr, flights, q);

            printAnswers(answer, bw);
        }
        catch (OutOfMemoryError e)
        {
            throw new OutOfMemoryError("Not enough memory");
        }
        catch (NegativeArraySizeException e)
        {
            throw new NegativeArraySizeException("The number of planes and routes has to be between 1 and 10^7");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void validateInputSizes(int n, int q)
    {   //1≤ n ≤ 10^7 , 1≤ q ≤ 10^7
        if (n < 1 || q < 1 || n > 10_000_000 || q > 10_000_000)
        {
            throw new IllegalArgumentException("The number of planes and routes has to be between 1 and 10^7");
        }
    }

    public static Plane[] readPlanes(FastReader fr, int n)
    {
        Plane[] flights = new Plane[n + 1];
        flights[0] = new Plane((short) 0);

        for (int i = 1; i <= n; i++)
        {
            short value = fr.nextShort();
            if (value < 0 || value > 1000)
            {
                throw new IllegalArgumentException("The number of seats has to be between 0 and 1000");
            }
            flights[i] = new Plane(value);
        }
        return flights;
    }

    public static List<Long> processCommands(FastReader fr, Plane[] flights, int q)
    {
        List<Long> answer = new ArrayList<>();

        for (int k = 0; k < q; k++)
        {
            String command = fr.next();

            switch (command.charAt(0))
            {
                case 'P' -> handleChangePassengers(fr, flights);
                case 'C' -> handleSetInactiveFromDay(fr, flights);
                case 'A' -> handleChangeRoute(fr, flights);
                case 'Q' -> handleQuery(fr, flights, answer);
                default -> throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
        return answer;
    }
    //P
    public static void handleChangePassengers(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        short p = fr.nextShort();
        long t = fr.nextLong();
        if(t < days)
        {
            throw new IllegalArgumentException("Queries must be in chronological order!");
        } days = t;
        flights[i].changePassengers(t, p);
    }
    //C
    public static void handleSetInactiveFromDay(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        long t = fr.nextLong();
        if(t < days)
        {
            throw new IllegalArgumentException("Queries must be in chronological order!");
        } days = t;
        flights[i].setInactive(t);
    }
    //A
    public static void handleChangeRoute(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        short p = fr.nextShort();
        long t = fr.nextLong();
        if(t < days)
        {
            throw new IllegalArgumentException("Queries must be in chronological order!");
        } days = t;
        flights[i].newRoute(t, p);
    }

    //Q
    public static void handleQuery(FastReader fr, Plane[] flights, List<Long> answer)
    {
        int i = fr.nextInt();
        int j = fr.nextInt();
        long t = fr.nextLong();
        if(t < days)
        {
            throw new IllegalArgumentException("Queries must be in chronological order!");
        } days = t;
        long sum = 0;

            for (int m = i; m <= j; m++)
            {
                sum += flights[m].getSeatsByDay(t);
            }

        answer.add(sum);
    }

    public static void printAnswers(List<Long> answer, BufferedWriter bw) throws IOException
    {
        for (Long Long : answer)
        {
            bw.write(Long.toString());
            bw.newLine();
        }
        bw.flush();
    }

    public static void instruction()
    {
        System.out.println(
    """
    ==========================================
      Welcome to S4Airlines Console Manager
    ==========================================
    Manage airline routes and seat availability over time.

    Available commands:
      P i p t  - Increase passengers on plane *i* to *p* at day *t*
      A i p t  - Add a new route with capacity *p* on plane *i* at day *t*
      C i t    - Deactivate the active rout of plane *i* from day *t* onward
      Q i j t  - Sum of available seats on planes *i* to *j* to day *t*

    Please enter the number of planes (1 ≤ n ≤ 10^7) and number of commands (1 ≤ q ≤ 10^7),
    followed by q lines of commands as described above.
    The commands MUST be written in chronological order.
    The number of seats is limited by 0 ≤ pi ≤ 1000 and the number of days is limited by 0 ≤ t ≤ 10^11

    Example:
      3 2
      1 10 3
      P 1 50 4
      Q 1 3 5
    """);
    }
}