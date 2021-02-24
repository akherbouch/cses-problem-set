package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.*;

public class JosephusProblemI {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i<=n; i++) queue.add(i);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            queue.add(queue.poll());
            ans.add(queue.poll());
        }
        PrintUtil.printArray(out, ans);
    }

}

