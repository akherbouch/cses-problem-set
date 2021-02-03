package com.akherbouch.cses.utils;

import java.io.PrintWriter;
import java.util.List;

public final class PrintUtil {

    public static void printArray(PrintWriter out, List<Integer> arr) {
        final StringBuilder buf = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            buf.append(arr.get(i));
            if (i < arr.size()- 1) buf.append(" ");
        }
        out.println(buf.toString());
    }

    public static void printArray(PrintWriter out, int[] arr) {
        final StringBuilder buf = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            buf.append(arr[i]);
            if (i < arr.length- 1) buf.append(" ");
        }
        out.println(buf.toString());
    }

}
