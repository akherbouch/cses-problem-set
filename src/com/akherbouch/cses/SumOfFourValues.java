package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;
import com.akherbouch.cses.utils.IntegerTriple;

import java.io.PrintWriter;
import java.util.*;

import static com.akherbouch.cses.utils.PrintUtil.log;

public class SumOfFourValues {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        var a = new int[n+1];
        for (int i = 1; i<=n; i++)
            a[i] = in.nextInt();

        HashMap<Integer, IntegerPair> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            for (int j = i+1; j<=n; j++) {
                int s = a[i] + a[j];
                if (map.containsKey(s)) {
                    IntegerPair p = map.get(s);
                    out.println(i+" "+j+" "+p.first()+" "+p.second());
                    return;
                }
            }
            for (int j = 1; j<i; j++) {
                map.put(x - a[i] - a[j], new IntegerPair(i, j));
            }
        }
        out.println("IMPOSSIBLE");
    }
}
