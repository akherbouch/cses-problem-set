package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class StickLengths {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i<n; i++) p[i] = in.nextInt();
        Algo2.shuffleAndSort(p);
        int median = p[n/2];
        long sx = 0;
        for (int i = 0; i<n; i++) sx += Math.abs(p[i] - median);
        out.println(sx);
    }
}