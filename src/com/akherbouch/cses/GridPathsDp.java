package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class GridPathsDp {

    private static final int MOD = 1000000007;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        boolean[][] grid = new boolean[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            String line = in.next();
            for (int j = 1; j <= n; j++)
                grid[i][j] = line.charAt(j-1) == '.';
        }

        int[][] dp = new int[n+2][n+2];
        int[] dr = {0, 1};
        int[] dc = {1, 0};

        if (!grid[1][1]) {
            out.println(0);
            return;
        }

        dp[n][n] = 1;
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                for (int d = 0, r, c; d<2; d++) {
                    r = i + dr[d];
                    c = j + dc[d];
                    if (grid[r][c])
                        dp[i][j] = (dp[i][j] +  dp[r][c]) % MOD;
                }
            }
        }
        out.println(dp[1][1]);
    }
}
