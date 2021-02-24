package com.akherbouch.cses.utils;

import java.util.Map;

public final class MapUtil {

    public static void increase(Map<Integer, Integer> map, int key, int a) {
        int oldValue = map.getOrDefault(key, 0);
        map.put(key, oldValue + a);
    }

}
