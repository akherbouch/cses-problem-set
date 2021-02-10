package com.akherbouch.cses.utils;

import java.util.Objects;

public class IntegerPair implements Comparable<IntegerPair> {
    private final Integer _first, _second;

    public IntegerPair(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerPair other) {
        if (!this.first().equals(other.first()))
            return this.first() - other.first();
        else
            return this.second() - other.second();
    }

    public Integer first() { return _first; }
    public Integer second() { return _second; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerPair that = (IntegerPair) o;
        return _first.equals(that._first) &&
                _second.equals(that._second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_first, _second);
    }

    public String toString() {
        return "(" + first() + ", " + second() + ")";
    }
}