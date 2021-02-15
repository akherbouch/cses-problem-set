package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoValues {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            int ai = in.nextInt();
            if (map.containsKey(x - ai)) {
                out.println(map.get(x - ai)+" "+(i+1));
                return;
            }
            map.put(ai, i + 1);
        }
        out.println("IMPOSSIBLE");
    }

    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        IntegerPair[] a = new IntegerPair[n];
        for (int i = 0; i<n; i++) {
            a[i] = new IntegerPair(in.nextInt(), i + 1);
        }
        Arrays.sort(a);
        int l = 0, r = n-1;
        while (l < r) {
            if (a[l].first() + a[r].first() < x) l++;
            else if (a[l].first() + a[r].first() > x) r--;
            else {
                out.println(a[l].second()+" "+a[r].second());
                return;
            }
        }
        out.println("IMPOSSIBLE");

    }
}
