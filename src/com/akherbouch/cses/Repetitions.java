package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;

public class Repetitions {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String dna = in.nextLine();
        int ans = 1;
        int cur = 1;
        char prev = dna.charAt(0);
        for (int i = 1; i<dna.length(); i++) {
            if (dna.charAt(i) == prev) cur++;
            else {
                prev = dna.charAt(i);
                cur = 1;
            }
            ans = Math.max(ans, cur);
        }
        out.println(ans);
    }
}
