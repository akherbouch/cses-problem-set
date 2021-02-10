package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.CommonUtils;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.List;

public class ChessboardAndQueens {

    private final char[][] grid = new char[8][8];
    private long ans = 0;

    private boolean isConsistent(int[] a) {
        int n = a.length;
        boolean[] diag = new boolean[2*n - 1]; // max 7+7
        boolean[] rdiag = new boolean[2*n - 1];
        for (int r = 0; r < n; r++) {
            int c = a[r];
            if (grid[r][c] == '*') return false;
            if (diag[r-c+7] || rdiag[r+c]) return false;
            diag[r-c+7] = true;
            rdiag[r+c] = true;
        }
        return true;
    }

    private  void enumerate(int n) {
        int[] a = new int[n];
        while (n-- > 0) a[n] = n;
        enumerate(a, 0);
    }


    private void enumerate(int[] a, int s) {
        if (s == a.length && isConsistent(a)) ans++;
        else for (int i = s; i < a.length; i++) {
            CommonUtils.swap(a, i, s);
            enumerate(a, s+1);
            CommonUtils.swap(a, i, s);
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        for (int i = 0; i<8; i++) {
            String s = in.nextLine();
            for (int j = 0; j<8; j++)
                grid[i][j] = s.charAt(j);
        }
        enumerate(8);
        out.println(ans);
    }
}
