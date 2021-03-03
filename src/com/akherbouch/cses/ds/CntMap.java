package com.akherbouch.cses.ds;


import java.util.HashMap;

public class CntMap<T> extends HashMap<T, Integer> {

    public void add(T key) {
        Integer count = get(key);
        put(key, count == null ? 1 : count + 1);
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public Integer remove(Object key) {
        if (!containsKey(key)) return null;

        int count = get(key);
        if (count > 1) return put((T) key, count - 1);

        return super.remove(key);
    }
}