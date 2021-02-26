package com.akherbouch.cses;

import com.akherbouch.cses.ds.IntegerFenwickTree;
import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.PrintUtil;
import com.jwetherell.algorithms.data_structures.FenwickTree;
import com.sun.source.tree.Tree;

import java.io.PrintWriter;
import java.util.*;

public class NestedRangesCheck {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Event[] events = new Event[2*n];
        for (int i = 0, l, r; i<n; i++) {
            l = in.nextInt();
            r = in.nextInt();
            events[2*i] = new Event(true, i, l, r);
            events[2*i + 1] = new Event(false, i, l, r);
        }
        Arrays.sort(events);
        int[] ansContains = new int[n];
        int[] ansContained = new int[n];
        int maxLeft = -1;
        int maxRight = -1;
        for (int i = 0; i < events.length; i++) {
            Event e = events[i];
            if (e.isStart) {
                if (e.r <= maxRight) ansContained[e.id] = 1;
                else maxRight = e.r;
            }
            else {
                if (e.l <= maxLeft) ansContains[e.id] = 1;
                else maxLeft = e.l;
            }
        }
        PrintUtil.printArray(out, ansContains);
        PrintUtil.printArray(out, ansContained);
    }

    private static class Event implements Comparable<Event> {
        boolean isStart;
        int id, l, r;

        public Event(boolean isStart, int id, int l, int r) {
            this.isStart = isStart;
            this.id = id;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Event other) {
            int x = isStart ? l : r;
            int o = other.isStart ? other.l : other.r;
            if (x != o) return x - o;
            if (isStart != other.isStart) return isStart ? -1 : 1;
            if (isStart) return other.r - r;
            return other.l - l;
        }
    }




}


