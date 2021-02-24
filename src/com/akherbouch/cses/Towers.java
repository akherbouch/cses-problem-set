package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Towers {

    public int upperBound(List<Integer> arr, int value) {
        int low = 0;
        int high = arr.size();
        while (low < high) {
            int mid = (high + low) / 2;
            if (arr.get(mid) <= value) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int ki = in.nextInt();
            int ii = upperBound(list, ki);
            if (ii == list.size()) list.add(ki);
            else if (ii == list.size() - 1) list.set(ii, ki);
        }
        out.println(list.size());
    }
}