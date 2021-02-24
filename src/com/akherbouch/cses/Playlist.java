package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.HashSet;

public class Playlist {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] k = new int[n];
        for (int i = 0, j = 0; i<n; i++) k[i] = in.nextInt();
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i<n; i++) {
            while (j < n && !set.contains(k[j])) set.add(k[j++]);
            ans = Math.max(j - i, ans);
            set.remove(k[i]);
        }
        out.println(ans);
    }
}
