package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class WeirdAlgorithm {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nextLong();
        while (n != 1) {
            out.print(n + " ");
            if (n % 2 == 0) n /= 2;
            else n = 3*n + 1;
        }
        out.println(1);
    }
}
