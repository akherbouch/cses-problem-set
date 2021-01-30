package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class IncreasingArray {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int prev = in.nextInt();
        long ans = 0;
        for (int i = 1; i<n; i++) {
            final int a = in.nextInt();
            if (prev > a) {
                ans += prev - a;
            } else prev = a;
        }
        out.println(ans);
    }
}
