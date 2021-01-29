package com.akherbouch.cses.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
        st = new StringTokenizer("");
    }

    public String next() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public String nextLine() {
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(next());
    }


}
