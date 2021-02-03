package com.akherbouch.cses.utils;

public final class Math2 {

    public static long fastPower(long a, long p) {
        if (p == 0) return 1;
        long half = fastPower(a, p/2);
        if (p % 2 == 0) return half*half;
        else return a*half*half;
    }

    public static long fastPower(long a, long p, long mod) {
        if (p == 0) return 1;
        long half = fastPower(a, p/2, mod);
        if (p % 2 == 0) return mul(half, half, mod);
        else return mul(a, mul(half, half, mod), mod);
    }

    public static long mul(long a, long b, long mod) {
        return a * b % mod;
    }



}
