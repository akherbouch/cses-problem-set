package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.Arrays;

public class TasksAndDeadlines {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        IntegerPair[] tasks = new IntegerPair[n];
        for (int i = 0; i<n; i++)
            tasks[i] = new IntegerPair(in.nextInt(), in.nextInt());
        Arrays.sort(tasks);
        long t = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            t += tasks[i].first();
            ans += tasks[i].second() - t;
        }
        out.println(ans);
    }
}
