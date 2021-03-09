package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class RemovingDigits {

    private static final int oo = Integer.MAX_VALUE / 3;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i<=n; i++) dp[i] = oo;
        for (int i = 1; i<=n; i++) {
            for (int r = i; r>0; r/=10) {
                int d = r % 10;
                dp[i] = Math.min(dp[i], dp[i-d] + 1);
            }
        }
        out.println(dp[n]);
    }
}
