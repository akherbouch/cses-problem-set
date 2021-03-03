package com.akherbouch.cses;

import com.akherbouch.cses.ds.CntMap;
import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;

public class SubarrayDivisibility {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        CntMap<Integer> psf = new CntMap<>();
        long sum = 0;
        psf.put(0, 1);
        long ans = 0;
        for (int i = 0; i<n; i++) {
            int a = in.nextInt();
            sum += a;
            int rem = (int) (sum % n);
            rem = (rem + n) % n;
            ans += psf.getOrDefault(rem, 0);
            psf.add(rem);
        }
        out.println(ans);
    }
}
