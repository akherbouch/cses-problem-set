package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class Apartments {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i<n; i++) a[i] = in.nextInt();
        for (int i = 0; i<m; i++) b[i] = in.nextInt();
        Algo2.shuffleAndSort(a);
        Algo2.shuffleAndSort(b);
        int ans = 0;
        for (int i = 0, j = 0; i < n && j < m; i++, j++) {
            if (b[j] + k < a[i]) i--;
            else if (a[i] + k < b[j]) j--;
            else ans++;
        }
        out.print(ans);
    }
}
