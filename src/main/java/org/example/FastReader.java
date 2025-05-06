package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader
{
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next()
    {
        while(st == null || !st.hasMoreElements())
        {
            try
            {
                String line = br.readLine();
                if (line == null) {
                    throw new IOException("Brak danych wejściowych");
                }
                st = new StringTokenizer(line);
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }
    public long nextLong()
    {
        return Long.parseLong(next());
    }
    public short nextShort()
    {
        return Short.parseShort(next());
    }
}
