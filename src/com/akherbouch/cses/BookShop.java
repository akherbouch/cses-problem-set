package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class BookShop {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];
        for (int i = 0; i<n; i++)
            prices[i] = in.nextInt();
        for (int i = 0; i<n; i++)
            pages[i] = in.nextInt();
        int[] dp = new int[x+1];
        for (int i = 0; i<n; i++) {
            for (int j = x; j >= prices[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-prices[i]] + pages[i]);
            }
        }
        out.println(dp[x]);
    }
}
