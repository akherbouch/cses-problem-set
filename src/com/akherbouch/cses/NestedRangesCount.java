package com.akherbouch.cses;

import com.akherbouch.cses.ds.IntegerFenwickTree;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.*;

public class NestedRangesCount {


    /*
    * from : 1 2 4 7 8 29 1000
    * to : 1 2 3 4 5 6  7
    * */
    int comSize = 1;
    int[] comArr = new int[400010];
    private int compress(int a) {
        int l = -1;
        int r = comSize;
        while(l < r-1) {
            int mid = (l+r)/2;
            if(comArr[mid] <= a) l = mid;
            else r = mid;
        }
        return l;
    }

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
        //HashMap<Integer, Integer> compress = new HashMap<>();
        for (int i = 0, j; i<2*n; i = j) {
            j = i;
            while(j < 2*n && events[i].x() == events[j].x()) {
                j++;
            }
            //compress.put(events[i].x(), comSize++);
            comArr[comSize++] = events[i].x();
        }
        IntegerFenwickTree BIT = new IntegerFenwickTree(comSize);
        IntegerFenwickTree BIT2 = new IntegerFenwickTree(comSize);
        int[] ansContains = new int[n];
        int[] ansContained = new int[n];
        for (Event e : events) {
            int l = compress(e.l);//compress.get(e.l);
            int r = compress(e.r);//compress.get(e.r);
            if (e.isStart) BIT2.update(l, 1);
            else {
                ansContains[e.id] = BIT.query(l, r);
                BIT.update(l, 1);
                BIT2.update(l, -1);
                ansContained[e.id] = BIT2.query(l);
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
            if (x() != other.x()) return x() - other.x();
            if (isStart != other.isStart) return isStart ? -1 : 1;
            if (isStart) return other.r - r;
            return other.l - l;
        }

        public int x() {
            return isStart ? l : r;
        }
    }
}
