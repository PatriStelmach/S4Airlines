package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void appCall()
    {
        FastReader fr = new FastReader();

        try
        {
            int n = fr.nextInt();
            int q = fr.nextInt();

            short[] pi = new short[n];
            int[] answer = new int[q];

            for (int i = 0; i < n; i++)
            {
                pi[i] = fr.nextShort();

                if (pi[i] < 0 || pi[i] > 1000)
                {
                    throw new IllegalArgumentException("The number of seats has to be between 0 and 1000");
                }

            }

            List<Plane> flights = new ArrayList<>(n);
            flights.add(new Plane((short) 0));
            for (int i = 0; i < n; i++)
            {
                flights.add(new Plane(pi[i]));
            }

            for (int k = 0; k < q; k++)
            {

                String command = fr.next();

                if(command.startsWith("P"))

                {
                    int i = fr.nextInt();
                    if (i >= 0 && i < flights.size())
                    {
                        short p = fr.nextShort();
                        long t = fr.nextLong();
                        flights.get(i).changePassengers(t, p);
                        answer[k] = -1;
                    }

                }

                else if(command.startsWith("C"))
                {
                    int i = fr.nextInt();
                    if (i >= 0 && i < flights.size())
                    {
                        long t = fr.nextLong();
                        flights.get(i).setInactiveFromDay(t);
                        answer[k] = -1;
                    }

                }

                else if(command.startsWith("A"))
                {
                    int i = fr.nextInt();
                    if (i >= 0 && i < flights.size())
                    {
                        short p = fr.nextShort();
                        long t = fr.nextLong();
                        flights.get(i).changeRoute(t, p);
                        answer[k] = -1;
                    }

                }

                else if(command.startsWith("Q"))
                {
                    int i = fr.nextInt();
                    int j = fr.nextInt();
                    long t = fr.nextLong();

                    for (int l = 0; l < t; l++)
                    {
                        for (int m = i; m <= j; m++)
                        {
                            answer[k] += flights.get(m).getSeatsByDay(l, t);
                        }
                    }

                }



            }
            for(int i = 0; i < q ; i++)
            {
                if(answer[i] != -1) {
                    System.out.println(answer[i]);
                }
            }
        }
        catch (OutOfMemoryError e)
        {
            System.out.println("Not enough memory");
        }
        catch (NegativeArraySizeException e)
        {
            System.out.println("The number of planes and routes has to be between 1 and 10^7");
        }
    }


}
