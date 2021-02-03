package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.akherbouch.cses.utils.PrintUtil.printArray;

public class TwoSets {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        boolean ans = false;
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        if (n % 4 == 0) {
            ans = true;
            for (int i = 1; i<= n/2; i+=2) {
                a1.add(i);
                a1.add(n-i+1);
                a2.add(i+1);
                a2.add(n-i);
            }
        } else if ((n-3) % 4 == 0) {
            ans = true;
            a1.add(1); a1.add(2); a2.add(3);
            for (int i = 4; i<= (n+3)/2; i+=2) {
                a1.add(i);
                a1.add(n+3-i+1);
                a2.add(i+1);
                a2.add(n+3-i);
            }
        }

        if (ans) {
            out.println("YES");
            out.println(a1.size());
            printArray(out, a1);
            out.println(a2.size());
            printArray(out, a2);
        } else out.println("NO");
    }
}
