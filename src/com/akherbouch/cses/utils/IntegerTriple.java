package com.akherbouch.cses.utils;

import java.util.Objects;

public class IntegerTriple implements Comparable<IntegerTriple> {
    private final Integer _first, _second, _third;

    public IntegerTriple(Integer f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(IntegerTriple other) {
        if (!this.first().equals(other.first()))
            return this.first() - other.first();
        else if (!this.second().equals(other.second()))
            return this.second() - other.second();
        else
            return this.third() - other.third();
    }

    public Integer first() { return _first; }
    public Integer second() { return _second; }
    public Integer third() { return _third; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerTriple that = (IntegerTriple) o;
        return _first.equals(that._first) &&
                _second.equals(that._second) &&
                _third.equals(that._third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_first, _second, _third);
    }

    public String toString() {
        return "(" + first() + ", " + second() + "," + third() + ")";
    }
}
