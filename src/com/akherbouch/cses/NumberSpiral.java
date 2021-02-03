package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class NumberSpiral {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int row = in.nextInt();
        int col = in.nextInt();
        long ans;
        if (row >= col) {
            col--;
            if (row % 2 == 0) ans = (long) row * row - col;
            else ans = (long) --row * row + 1 + col;
        } else {
            row--;
            if (col % 2 == 1) ans = (long) col * col - row;
            else ans = (long) --col * col + 1 + row;
        }
        out.println(ans);
    }
}
