package com.akherbouch.cses;

import com.akherbouch.cses.ds.IntegerAVLTree;
import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;


import java.io.PrintWriter;

public class JosephusProblemII {

    private class JPIntegerAVLTree extends IntegerAVLTree {
        public int findKth(int k) {
            Node cur = root;
            int rootLeftSize = getSize(cur.lesser) + 1;
            while (rootLeftSize != k) {
                if (k > rootLeftSize) {
                    cur = cur.greater;
                    k -= rootLeftSize;
                }
                else cur = cur.lesser;
                rootLeftSize = getSize(cur.lesser) + 1;
            }
            return cur.value;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i<n; i++) num[i] = i+1;
        Algo2.shuffle(num);
        JPIntegerAVLTree tree = new JPIntegerAVLTree();
        for (int i = 0; i<n; i++) tree.insert(num[i]);
        int toKill = 1;
        for (int size = n; size > 0; size--) {
            toKill = (toKill + k) % size;
            if (toKill == 0) toKill = size;
            int kth = tree.findKth(toKill);
            tree.remove(kth);
            out.print(kth + " ");
        }

    }



}



