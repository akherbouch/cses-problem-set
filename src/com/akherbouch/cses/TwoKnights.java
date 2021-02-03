package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class TwoKnights {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        for (int i = 1; i<=n; i++) {
            long ii = (long) i * i;
            long ans = ii*(ii - 1) / 2 - 4*ii + 12*i - 8;
            out.println(ans);
        }
    }
}
