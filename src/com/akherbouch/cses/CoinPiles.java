package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class CoinPiles {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int max = Math.max(a, b);
        b = a + b - max;
        a = max;
        int d = a - b;
        if (a - 2*d == b-d && b-d >= 0 && (b-d) % 3 == 0) {
            out.println("YES");
        } else out.println("NO");
    }
}
