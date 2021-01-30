package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class MissingNumber {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long sum = 0;
        for (int i = 0; i<n-1; i++) sum += in.nextInt();
        long ans = 1L*n*(n+1) / 2 - sum;
        out.println(ans);
    }
}