package com.akherbouch.cses;


import com.akherbouch.cses.ds.IntegerMedianTree;
import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;

public class SlidingCost {


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = in.nextInt();

        var medianTree = new IntegerMedianTree();
        for (int i = 0; i<x-1; i++)
            medianTree.insert(a[i]);


        var buf = new StringBuilder();
        long ans;
        for (int i = 0, j = x-1; j<n; i++, j++) {
            medianTree.insert(a[j]);
            ans = medianTree.getSettlementCost();
            buf.append(ans).append(" ");
            medianTree.remove(a[i]);
        }
        out.println(buf.toString());
    }
}
