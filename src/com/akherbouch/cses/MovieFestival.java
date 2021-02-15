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
        TreeMap<Integer, Integer> mvs = new TreeMap<>();
        for (int i = 0, e, s; i<n; i++) {
            s = in.nextInt();
            e = in.nextInt();
            mvs.put(e, s);
        }
        int ans = 0, last = 0;
        for (Map.Entry<Integer, Integer> mv : mvs.entrySet()) {
            if (mv.getValue() >= last) {
                last = mv.getKey();
                ans++;
            }
        }
        out.println(ans);
    }

    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        IntegerPair[] mvs = new IntegerPair[n];
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            mvs[i] = new IntegerPair(e, s);
        }
        Arrays.sort(mvs);
        int ans = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (mvs[i].second() >= last) {
                last = mvs[i].first();
                ans++;
            }
        }
        out.println(ans);
    }
}
