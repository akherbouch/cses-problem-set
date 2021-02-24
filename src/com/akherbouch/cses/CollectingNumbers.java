package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Stack;

public class CollectingNumbers {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] p = new int[n];
        for(int i = 0; i<n; i++) {
            int ii = in.nextInt();
            p[ii - 1] = i;
        }
        int ans = 1;
        for (int i = 1; i<n; i++) {
            if (p[i-1] > p[i]) ans++;
        }
        out.println(ans);
    }
}

// 4 1 5 2 3
// 2 4 5 1 3

// 4 3 1 5 2
// 3 5 2 1 4