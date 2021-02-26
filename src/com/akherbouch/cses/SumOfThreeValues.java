package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.*;

import static com.akherbouch.cses.utils.PrintUtil.log;

public class SumOfThreeValues {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i<=n; i++)
            a[i] = in.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            for (int j = i + 1, s; j<=n; j++) {
                s = a[i] + a[j];
                if (map.containsKey(s)) {
                    out.println(i+" "+j+" "+map.get(s));
                    return;
                }
            }
            map.put(x - a[i], i);
        }
        out.println("IMPOSSIBLE");
    }
}
