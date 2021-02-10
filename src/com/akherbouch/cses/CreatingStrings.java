package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class CreatingStrings {

    private final Set<String> ans = new TreeSet<>();

    public void permutation(char[] s, int start) {
        if (start == s.length) {
            ans.add(new String(s));
            return;
        }
        for (int i = start; i < s.length; i++) {
            char tmp = s[i];
            s[i] = s[start];
            s[start] = tmp;

            permutation(s, start + 1);

            tmp = s[i];
            s[i] = s[start];
            s[start] = tmp;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextLine();
        permutation(s.toCharArray(), 0);
        out.println(ans.size());
        for (String res : ans) out.println(res);
    }
}
