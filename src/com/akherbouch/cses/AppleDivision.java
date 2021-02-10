package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class AppleDivision {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        long ans = sum;
        for (int mask = 1; mask < 1 << n; mask++) {
            long groupSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1)
                    groupSum += a[i];
            }
            ans = Math.min(ans, Math.abs(sum - 2*groupSum));
        }
        out.println(ans);
    }
}
