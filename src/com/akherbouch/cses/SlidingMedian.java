package com.akherbouch.cses;

import com.akherbouch.cses.ds.AVLTree;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;

public class SlidingMedian {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = in.nextInt();

        AVLTree<IntegerPair> tree = new AVLTree<>();
        for (int i = 0; i<x-1; i++)
            tree.insert(new IntegerPair(a[i], i));

        int[] ans = new int[n-x+1];
        for (int i = 0, j = x-1; j<n; i++, j++) {
            tree.insert(new IntegerPair(a[j], j));
            ans[i] = tree.findKth((x+1)/2).first(); // O(1) cause the median is the root;
            IntegerPair p = new IntegerPair(a[i], i);
            tree.remove(p);
        }
        PrintUtil.printArray(out, ans);
    }
}
