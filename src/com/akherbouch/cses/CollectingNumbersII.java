package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.CommonUtils;
import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

public class CollectingNumbersII {

    // \ -> / == -1 || / -> \ == +1
    public int cost(int x1, int y1, int x2, int y2) {
        if (x1 > y1 && x2 <= y2) return -1;
        if (x1 < y1 && x2 >= y2) return 1;
        return 0;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] index = new int[n];
        int[] p = new int[n];
        for (int i = 0; i<n; i++) {
            index[i] = in.nextInt() - 1;
            p[index[i]] = i;
        }
        int ans = 1;
        for (int i = 1; i<n; i++)  {
            if (p[i-1] > p[i]) ans++;
        }
        while (m-- > 0) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int x = Math.min(index[a], index[b]);
            int y = index[a] + index[b] - x;
            if (x != 0) ans += cost(p[x-1], p[x], p[x-1], p[y]);
            if (x != n-1) ans += cost(p[x], p[x+1], p[y], p[x+1]);
            if (y-x != 1 && y != 0) ans += cost(p[y-1], p[y], p[y-1], p[x]);
            if (y != n-1) ans += cost(p[y], p[y+1], p[x], p[y+1]);
            CommonUtils.swap(index, a, b);
            CommonUtils.swap(p, x, y);
            out.println(ans);
        }
    }

}
