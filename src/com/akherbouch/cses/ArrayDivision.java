package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

import static com.akherbouch.cses.utils.PrintUtil.log;

public class ArrayDivision {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        long mx = 0;
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
            mx = Math.max(mx, a[i]);
        }
        long low = mx;
        long high = Long.MAX_VALUE / 2;
        while (low < high) {
            long max = (low + high) / 2;
            int cnt = 0, i = 0;
            long sum;
            while (i < n) {
                sum = 0;
                while (i < n && sum + a[i] <= max) sum += a[i++];
                cnt++;
            }
            if (cnt <= k) high = max;
            else low = max + 1;
        }
        out.println(low);
    }
}
