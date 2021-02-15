package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.TreeSet;

public class RestaurantCustomers {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        TreeSet<IntegerPair> timeLine = new TreeSet<>();
        int[] a = new int[n];
        int[] l = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        // avoid bad input in case 6
        Algo2.shuffle(a);
        Algo2.shuffle(l);
        for (int i = 0; i<n; i++) {
            timeLine.add(new IntegerPair(a[i], 1)); // (2*ai, 1) if arrival and leaving not distinct
            timeLine.add(new IntegerPair(l[i], -1)); // (2*li + 1, -1) if arrival and leaving not distinct
        }
        int ans = 0, cnt = 0;
        for (IntegerPair p : timeLine) {
            cnt += p.second();
            ans = Math.max(ans, cnt);
        }
        out.println(ans);
    }

    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] l = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        Algo2.shuffleAndSort(a);
        Algo2.shuffleAndSort(l);
        int ans = 0;
        int cnt = 0;
        for (int i = 0, j = 0; i<n;) {
            if (a[i] < l[j]) {
                i++;
                cnt++;
            } else {
                j++;
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        out.println(ans);
    }
}
