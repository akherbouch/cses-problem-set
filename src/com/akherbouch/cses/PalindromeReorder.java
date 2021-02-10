package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.HashMap;

public class PalindromeReorder {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextLine();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'A']++;
        StringBuilder sb = new StringBuilder();
        String mid = "";
        for (int i = 0; i<26; i++) {
            if (freq[i] % 2 == 0) {
                freq[i] /= 2;
                while (freq[i]-- > 0)
                    sb.append((char) (i + 'A'));
                continue;
            }
            if (mid.isEmpty()) {
                mid = (char) (i + 'A') + "";
                freq[i--]--;
                continue;
            }
            out.println("NO SOLUTION");
            return;
        }
        out.println(sb.toString() + mid + sb.reverse().toString());
    }
}
