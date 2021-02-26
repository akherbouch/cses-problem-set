package com.akherbouch.cses.ds;

public class IntegerFenwickTree {
    int size;
    int[] bit;

    public IntegerFenwickTree(int size) {
        this.size = size;
        this.bit = new int[size + 1];
    }

    public void update(int start, int delta) {
        while (start <= size) {
            bit[start] += delta;
            start += -start & start;
        }
    }

    public int query(int end) {
        int sum = 0;
        while (end > 0) {
            sum += bit[end];
            end -= -end & end;
        }
        return sum;
    }

    public int query(int start, int end) {
        return query(end) - query(start - 1);
    }

}
