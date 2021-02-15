package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class MaximumSubarraySum {

    private static final long oo = Long.MAX_VALUE / 3;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long ans = -oo;
        long ac = -oo;
        for (int i = 0; i<n; i++) {
            long ai = in.nextLong();
            ac = Math.max(ai, ai + ac);
            ans = Math.max(ans, ac);
        }
        out.println(ans);
    }
}
