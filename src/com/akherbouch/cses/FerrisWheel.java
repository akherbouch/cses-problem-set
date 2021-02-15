package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class FerrisWheel {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i<n; i++) p[i] = in.nextInt();
        Algo2.shuffleAndSort(p);
        int l = 0;
        int r = n-1;
        while (l < r) {
            if (p[l] + p[r] <= x) l++;
            r--;
        }
        out.println(n-l);
    }
}
