package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class DigitQueries {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.nextInt();
        while (q-- > 0) {
            long k = in.nextLong();
            long i = 0;
            long j = 0;
            int d = 1;
            long lev = 1;
            while (k > j + 9*lev*d) {
                i += 9*lev; // 9 99 999 ...
                j += 9*lev*d; // 9 189 2889 ...
                lev *= 10;
                d++;
            }
            long gap = k - j;
            long corGap = (gap + d - 1) / d; // ceil
            long corNumber = i + corGap;
            int digIndex = (int) ((gap-1) % d); // get the digit index
            char ans = Long.toString(corNumber).charAt(digIndex);
            out.println(ans);
        }
    }
}
