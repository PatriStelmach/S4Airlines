package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next()
    {
        while(st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
                return st.nextToken();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    short nextShort()
    {
        return Short.parseShort(next());
    }

    String nextLine()
    {
        String str ="";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return str;
    }

}
