package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class Permutations {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        if (n == 1) out.println(1);
        else if (n <= 3) out.println("NO SOLUTION");
        else {
            int[] a = new int[n];
            int i = 1;
            int l = 1;
            int r = n;
            while (r > l) {
                a[i++] = r--;
                a[i++ % n] = l++;
            }
            if (r == l) a[0] = l;
            for (int ai : a) out.print(ai+" ");
            out.println();
        }
    }
}