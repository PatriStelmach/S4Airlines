package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void appCall()
    {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try
        {
            int n = fr.nextInt();
            int q = fr.nextInt();
            validateInputSizes(n, q);

            Plane[] flights = readPlanes(fr, n);
            List<Integer> answer = processCommands(fr, flights, q);

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

    private static void validateInputSizes(int n, int q)
    {
        if (n < 1 || q < 1 || n > 10_000_000 || q > 10_000_000)
        {
            throw new IllegalArgumentException("The number of planes and routes has to be between 1 and 10^7");
        }
    }

    private static Plane[] readPlanes(FastReader fr, int n)
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

    private static List<Integer> processCommands(FastReader fr, Plane[] flights, int q)
    {
        List<Integer> answer = new ArrayList<>();

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

    private static void handleChangePassengers(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        short p = fr.nextShort();
        long t = fr.nextLong();
        flights[i].changePassengers(t, p);
    }

    private static void handleSetInactiveFromDay(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        long t = fr.nextLong();
        flights[i].setInactiveFromDay(t);
    }

    private static void handleChangeRoute(FastReader fr, Plane[] flights)
    {
        int i = fr.nextInt();
        short p = fr.nextShort();
        long t = fr.nextLong();
        flights[i].changeRoute(t, p);
    }


    private static void handleQuery(FastReader fr, Plane[] flights, List<Integer> answer)
    {
        int i = fr.nextInt();
        int j = fr.nextInt();
        long t = fr.nextLong();
        int sum = 0;

        //10^18 XDDDDDDDDDD
        for (int l = 0; l < t; l++)
        {
            for (int m = i; m <= j; m++)
            {
                sum += flights[m].getSeatsByDay(l, t);
            }
        }
        answer.add(sum);
    }

    private static void printAnswers(List<Integer> answer, BufferedWriter bw) throws IOException
    {
        for (Integer integer : answer)
        {
            bw.write(integer.toString());
            bw.newLine();
        }
        bw.flush();
    }
}