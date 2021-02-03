package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.Math2;

import java.io.PrintWriter;

public class BitStrings {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long ans  = Math2.fastPower(2, n, 1000000007);
        out.println(ans);
    }
}
