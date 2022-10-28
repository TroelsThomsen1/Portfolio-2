package com.company;

import java.util.ArrayList;


public class Vertex implements Comparable<Vertex> {

    private String name;
    private ArrayList<Edge> outEdges;
    private Integer distance = Integer.MAX_VALUE;

    public Vertex(String area) {
        this.name = area;
        outEdges = new ArrayList<Edge>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public void addOutEdge(Edge newEdge) {
        outEdges.add(newEdge);
    }


    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance) {
            return -1;
        }
        if (this.distance > o.distance) {
            return 1;
        }
        return 0;
    }
}