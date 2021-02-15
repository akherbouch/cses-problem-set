package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.HashSet;

public class DistinctNumbers {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i<n; i++) set.add(in.nextInt());
        out.println(set.size());
    }
}
