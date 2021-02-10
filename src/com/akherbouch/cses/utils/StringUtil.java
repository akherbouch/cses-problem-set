package com.akherbouch.cses.utils;

public final class StringUtil {

    private static String reverse(String str) {
        byte[] byteArr = str.getBytes();
        byte[] output = new byte[byteArr.length];
        for (int i = 0; i < byteArr.length; i++) output[i] = byteArr[byteArr.length - i - 1];
        return new String(output);
    }


}
