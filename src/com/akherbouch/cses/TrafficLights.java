package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.PrintUtil;
import com.sun.source.tree.Tree;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TrafficLights {


    // backward
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int x = in.nextInt();
        int n = in.nextInt();
        int[] p = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[n];
        set.add(0);
        set.add(x);
        for (int i = 0; i<n; i++) {
            p[i] = in.nextInt();
            set.add(p[i]);
        }

        int longestPassage = 0, prev = 0;
        for (int pi : set) {
            longestPassage = Math.max(longestPassage, pi - prev);
            ans[n-1] = longestPassage;
            prev = pi;
        }

        for (int i = n-2; i>=0; i--) {
            int pi = p[i+1];
            int low = set.lower(pi);
            int high = set.higher(pi);
            longestPassage = Math.max(longestPassage, high - low);
            set.remove(pi);
            ans[i] = longestPassage;
        }

        PrintUtil.printArray(out, ans);
    }

    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int x = in.nextInt();
        int n = in.nextInt();
        TreeMap<Integer, Integer> disFreq = new TreeMap<>();
        TreeSet<Integer> p = new TreeSet<>();
        p.add(0);
        p.add(x);
        disFreq.put(x, 1);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i<n; i++) {
            int pi = in.nextInt();
            int low = p.lower(pi);
            int high = p.higher(pi);
            decrease(disFreq, high - low);
            increase(disFreq, high - pi);
            increase(disFreq, pi - low);
            buf.append(disFreq.lastKey()).append(' ');
            p.add(pi);
        }
        out.println(buf.toString());
    }

    private void increase(Map<Integer, Integer> map, int key) {
        int a = map.getOrDefault(key, 0);
        map.put(key, a + 1);
    }

    private void decrease(Map<Integer, Integer> map, int key) {
        int a = map.getOrDefault(key, 0);
        if (a > 1) map.put(key, a - 1);
        else if (a == 1) map.remove(key);
    }
}
