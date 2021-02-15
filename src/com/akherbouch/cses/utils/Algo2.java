package com.akherbouch.cses.utils;

import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

public final class Algo2 {


    public static void shuffleAndSort(int[] a) {
        shuffle(a);
        Arrays.sort(a);
    }

    public static void shuffle(int[] a) {
        Random r = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(n);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void shuffle(Object[] a) {
        Random r = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(n);
            Object temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static int upperBound(int[] a, int value) {
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] <= value) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int floor(int[] a, int value) {
        int low = -1;
        int high = a.length;
        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (a[mid] <= value) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static List<List<Integer>> permutations(int n, boolean repetition) {
        List<Integer> a = new ArrayList<>(n);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i<n; i++) a.add(i);
        if (repetition)
            permutationsWithRepetition(a, 0, res);
        else
            permutations(a, 0, res);
        return res;
    }

    // O(n!)
    private static void permutations(List<Integer> a, int start, List<List<Integer>> res) {
        if (start == a.size()) {
            res.add(new ArrayList<>(a));
            return;
        }
        for (int i = start; i < a.size(); i++) {
            Collections.swap(a, i, start);
            permutations(a, start + 1, res);
            Collections.swap(a, i, start);
        }
    }
    // O(n**n)
    private static void permutationsWithRepetition(List<Integer> a, int index, List<List<Integer>> res) {
        if (index == a.size()) {
            res.add(new ArrayList<>(a));
            return;
        }
        for (int i = 0; i < a.size(); i++) {
            a.set(index, i);
            permutationsWithRepetition(a, index + 1, res);
        }
    }
}
