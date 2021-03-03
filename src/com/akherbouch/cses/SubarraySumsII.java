package com.akherbouch.cses;

import com.akherbouch.cses.ds.CntMap;
import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;

public class SubarraySumsII {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        CntMap<Long> psf = new CntMap<>(); //prefixSumFreq
        long sum = 0;
        psf.put(0L, 1);
        long ans = 0;
        for (int i = 0; i<n; i++) {
            int a = in.nextInt();
            sum += a;
            ans += psf.getOrDefault(sum - x, 0);
            psf.add(sum);
        }
        out.println(ans);
    }
}
