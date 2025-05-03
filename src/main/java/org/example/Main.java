package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        FastReader fr = new FastReader();

            try
            {
                int n = fr.nextInt();
                int q = fr.nextInt();

                short[] pi = new short[n];

                for (int i = 0; i < n; i++)
                {
                    pi[i] = fr.nextShort();

                    if (pi[i] < 0 || pi[i] > 1000)
                    {
                        throw new IllegalArgumentException("The number of seats has to be between 0 and 1000");
                    }

                }

                List<Route> routes = new ArrayList<>(n);
                for (int i = 0; i < n; i++)
                {
                    routes.add(new Route(i));
                }

                List<Plane> flights = new ArrayList<>(routes.size());
                for (Route route : routes)
                {
                    flights.add(new Plane(route.getRouteNr(), route, pi[route.getRouteNr()]));
                    System.out.println(flights
                            .get(route.getRouteNr())
                            .getRoutes()
                            .stream()
                            .map(Route::getRouteNr)
                            .toList());
                }


                int[] answer = new int[q];



                for (int k = 0; k < q; k++)
                {

                    switch (fr.next())
                    {

                        case "P":
                        {
                            int i = fr.nextInt();
                            short p = fr.nextShort();
                            long t = fr.nextLong();
                            flights.get(i).changeFlight(t, p);
                        }

                        case "C":
                        {
                            int i = fr.nextInt();
                            long t = fr.nextLong();
                            flights.get(i).changeFlight(t,0);
                        }

                        case "A":
                        {
                            int i = fr.nextInt();
                            short p = fr.nextShort();
                            long t = fr.nextLong();
                            flights.get(i).ro;
                        }

                        case "Q":
                        {
                            int i = fr.nextInt();
                            int j = fr.nextInt();
                            long t = fr.nextLong();

                            for (int l = 1; l <= t; l++)
                            {
                                for (int m = i; m <= j; m++)
                                {
                                    answer[k] += flights[m];
                                }
                            }
                        }
                    }

                }
                for(int i = 0; i < q ; i++)
                {
                    System.out.println(answer[i]);
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

