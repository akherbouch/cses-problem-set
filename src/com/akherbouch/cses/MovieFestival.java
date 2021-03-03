package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MovieFestival {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Movie[] mvs = new Movie[n];
        for (int i = 0; i < n; i++) {
            mvs[i] = new Movie(in.nextInt(), in.nextInt());
        }
        Arrays.sort(mvs);
        int ans = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (mvs[i].start >= last) {
                last = mvs[i].end;
                ans++;
            }
        }
        out.println(ans);
    }

    private static class Movie implements Comparable<Movie> {
        public int start, end;

        public Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Movie o) {
            return end - o.end;
        }
    }
}
