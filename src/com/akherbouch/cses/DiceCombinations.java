package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class DiceCombinations {


    private static final int MOD = 1000000007;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] dp = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dp[i] = 0;
            for (int d = 1; d <= 6; d++) {
                if (i - d > 0)
                    dp[i] = (dp[i] + dp[i-d]) % MOD;
                else if (i - d == 0)
                    dp[i] = (dp[i] + 1) % MOD;
            }
        }

        out.println(dp[n]);
    }
}
