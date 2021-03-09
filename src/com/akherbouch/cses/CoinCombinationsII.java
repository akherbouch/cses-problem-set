package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class CoinCombinationsII {
    private static final int MOD = 1000000007;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            c[i] = in.nextInt();

        int[] dp = new int[x + 1];
        for (int i = 0; i < n; i++) dp[0] = 1;

        for (int i = 0; i<n; i++) {
            for (int rem = 1; rem <= x; rem++) {
                if (rem - c[i] >= 0)
                    dp[rem] = (dp[rem] + dp[rem - c[i]]) % MOD;
            }
        }

        out.println(dp[x]);
    }
}
