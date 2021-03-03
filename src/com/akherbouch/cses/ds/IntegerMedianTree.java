package com.akherbouch.cses.ds;


public class IntegerMedianTree {
    private Integer median = null;
    private final Multiset<Integer> lesser = new Multiset<>();
    private final Multiset<Integer> greater = new Multiset<>();
    private long lesserSum = 0;
    private long greaterSum = 0;



    public void insert(Integer value) {
        if (median == null) median = value;
        else if(value.compareTo(median) < 0) addToLesser(value);
        else if(value.compareTo(median) >= 0) addToGreater(value);
        balance();
    }

    public void remove(Integer value) {
        if (median == null) return;
        if (value.compareTo(median) < 0) removeFromLesser(value);
        else if(value.compareTo(median) > 0) removeFromLGreater(value);
        else if (greater.size() > 0) {
            median = greater.firstKey();
            removeFromLGreater(median);
        } else median = null;
        balance();
    }

    private void balance() {
        if (lesser.size() > greater.size()) {
            addToGreater(median);
            median = lesser.lastKey();
            removeFromLesser(median);
        }
        if (lesser.size() + 1 < greater.size()) {
            addToLesser(median);
            median = greater.firstKey();
            removeFromLGreater(median);
        }
    }

    private void addToLesser(Integer ip) {
        lesser.add(ip);
        lesserSum += ip;
    }

    private void addToGreater(Integer ip) {
        greater.add(ip);
        greaterSum += ip;
    }

    private void removeFromLesser(Integer ip) {
        lesser.remove(ip);
        lesserSum -= ip;
    }

    private void removeFromLGreater(Integer ip) {
        greater.remove(ip);
        greaterSum -= ip;
    }

    public Integer getMedian() {
        return median;
    }

    public long getSettlementCost() {
        long res = greaterSum - (long) greater.size() * median;
        res += (long) lesser.size() * median - lesserSum;
        return res;
    }


    @Override
    public String toString() {
        return "SimpleHybridTree{" +
                "root=" + median +
                ", lesser=" + lesser +
                ", greater=" + greater +
                '}';
    }
}
