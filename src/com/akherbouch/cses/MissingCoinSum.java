package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class MissingCoinSum {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i<n; i++) x[i] = in.nextInt();
        Algo2.shuffleAndSort(x);
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (s + 1 < x[i]) {
                out.println(s + 1);
                return;
            }
            s += x[i];
        }
        out.println(s + 1);
    }
}