package com.company;

public class Pair implements Comparable<Pair> {
    Integer distance;
    Integer index;

    public Pair(Integer distance, Integer index) {
        this.distance = distance;
        this.index = index;
    }

    @Override
    public int compareTo(Pair pair) {
        return this.distance.compareTo(pair.distance);
    }
}