package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {


    private final List<IntegerPair> moves = new ArrayList<>();

    private void move(int from, int middle, int to, int disk) {
        if (disk == 1) {
            moves.add(new IntegerPair(from, to));
            return;
        }
        move(from, to, middle, disk - 1);
        move(from, middle, to, 1);
        move(middle, from, to, disk - 1);
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        move(1, 2, 3, n);
        out.println(moves.size());
        for (IntegerPair mv : moves)
            out.println(mv.first()+" "+mv.second());
    }
}
