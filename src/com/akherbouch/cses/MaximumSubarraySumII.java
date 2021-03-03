package com.akherbouch.cses;

import com.akherbouch.cses.ds.Multiset;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class MaximumSubarraySumII {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        long[] ps = new long[n+1];
        long sum = 0;
        for (int i = 1; i<=n; i++) {
            sum += in.nextInt();
            ps[i] = sum;
        }

        Multiset<Long> set = new Multiset<>();
        long ans = Long.MIN_VALUE;
        for (int i = a, h=0, t = 0; i <= n; i++ ) {
            set.add(ps[h++]);
            ans = Math.max(ans, ps[i] - set.firstKey());
            if (i >= b) set.remove(ps[t++]);
        }
        out.println(ans);
    }
}
