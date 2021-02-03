package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class TrailingZeros {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nextInt();
        long ans = 0;
        for (long i = 10, k = 2; i <= k * n; i *= 10, k *= 2) {
            long q = k * n / i;
            ans += q;
        }
        out.println(ans);
    }
}

// 5 10 15 20 25 30 35 40 45 50 55
// 1  1  1  1  2  1  1  1  1  2  1 = 13
// 2 * 55 / 10 = 11 | 4 * 55 / 100 = 2 (25, 50)