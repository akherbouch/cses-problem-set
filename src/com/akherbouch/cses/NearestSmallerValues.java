package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.Stack;

public class NearestSmallerValues {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i<n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i])
                stack.pop();
            if (stack.isEmpty()) ans[i] = 0;
            else ans[i] = stack.peek() + 1;
            stack.add(i);
        }
        PrintUtil.printArray(out, ans);
    }
}
