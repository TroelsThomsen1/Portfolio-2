package com.company;

public class Edge {

    Vertex from;
    Vertex to;
    Integer volumen;

    public Edge(Vertex from, Vertex to, Integer volumen) {
        this.from = from;
        this.to = to;
        this.volumen = volumen;
        this.from.addOutEdge(this);
    }

    public Vertex getFromVertex() {
        return from;
    }

    public Vertex getToVertex() {
        return to;
    }

    public Integer getWeight() {
        return volumen;
    }
}