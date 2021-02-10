package com.akherbouch.cses.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Algo2 {


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
