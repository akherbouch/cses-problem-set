package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class SubarraySumsI {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = in.nextInt();

        long s = 0;
        int ans = 0;
        int i = 0;
        int e = 0;
        while (true) {
            if (s < x) {
                if (e == n) break;
                s += a[e];
                e++;
            }
            else {
                if (s == x) ans++;
                s -= a[i];
                i++;
            }
        }
        out.println(ans);

    }
}
