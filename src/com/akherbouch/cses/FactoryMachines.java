package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class FactoryMachines {

    private static final long oo = Long.MAX_VALUE / 3;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int p = in.nextInt();
        int[] m = new int[n];
        for (int i = 0; i<n; i++) m[i] = in.nextInt();
        long high = oo;
        long low = 0;
        while (low < high) {
            long mid = (high + low) / 2;
            long sum = 0;
            for (int i = 0; i<n; i++) {
                sum += mid / m[i];
                if (sum < 0 || sum > oo) {
                    sum = oo;
                    break;
                }
            }
            if (sum < p) low = mid + 1;
            else high = mid;
        }
        out.println(low);
    }
}
