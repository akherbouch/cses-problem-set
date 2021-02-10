package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.Math2;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    private List<String> grayCode(int size) {
        if (size == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> tail = grayCode(size-1);
        List<String> res = new ArrayList<>();
        for (String s : tail)
            res.add("0" + s);
        for (int i = tail.size() - 1; i >= 0; i--)
            res.add("1"+tail.get(i));
        return res;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        for (String str : grayCode(n)) out.println(str);
    }
}
