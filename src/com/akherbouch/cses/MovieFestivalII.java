package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;
import java.util.*;

public class MovieFestivalII {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        Movie[] mvs = new Movie[n];
        for (int i = 0; i<n; i++) {
            mvs[i] = new Movie(in.nextInt(), in.nextInt());
        }
        Arrays.sort(mvs);
        TreeMap<Long, Integer> watching = new TreeMap<>();
        int ans = 0;
        long start, end;
        for (int i = 0; i<n; i++) {
            start = (long) mvs[i].start << 32 ;
            end = (long) mvs[i].end << 32;
            var availableWatcher = watching.floorEntry(start + k);
            int watcherId;
            if (availableWatcher != null) {
                watcherId = availableWatcher.getValue();
                watching.remove(availableWatcher.getKey());
            } else watcherId = watching.size() + 1;
            if (watcherId > k) continue;
            watching.put(end + watcherId, watcherId);
            ans++;
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
