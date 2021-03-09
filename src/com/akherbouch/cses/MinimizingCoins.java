package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;
import com.akherbouch.cses.utils.Math2;

import java.io.PrintWriter;
import java.util.TreeSet;

public class MinimizingCoins {

    private static final int oo = Integer.MAX_VALUE / 3;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i<n; i++)
            coins[i] = in.nextInt();
        int[] dp = new int[x+1];

        dp[0] = 0;
        for (int rem = 1; rem<=x; rem++) dp[rem] = oo;
        for (int rem = 1; rem<=x; rem++) {
            for (int c : coins) {
                if (rem - c < 0) continue;
                dp[rem] = Math.min(dp[rem - c] + 1, dp[rem]);
            }
        }
        out.println(dp[x] >= oo ? -1 :  dp[x]);
    }
}
