package com.akherbouch.cses;

import com.akherbouch.cses.ds.CntMap;
import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;

public class SubarrayDistinctValues {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = in.nextInt();


        CntMap<Integer> freq = new CntMap<>();
        long ans = 0;
        int i = 0, e = 0;
        while (i < n) {
            if (freq.size() <= k) {
                ans += e - i;
                if (e == n) break;
                freq.add(a[e]);
                e++;
            }
            else {
                freq.remove(a[i]);
                i++;
            }
        }
        out.println(ans);
    }
}
