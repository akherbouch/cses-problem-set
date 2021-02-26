package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class ReadingBooks {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long sum = 0;
        int max = 0;
        for (int i = 0, a; i<n; i++) {
            a = in.nextInt();
            sum += a;
            max = Math.max(max, a);
        }
        long ans = Math.max(sum, max * 2);
        out.println(ans);

    }
}
