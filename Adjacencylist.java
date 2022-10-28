package com.company;

import java.util.Arrays;
import java.util.ArrayList;

public class Adjacencylist {

    private ArrayList<Vertex> vertices;

    public Adjacencylist() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer weight) {
        if (!(vertices.contains(from) && vertices.contains(to))) {
            System.out.println("Vertex does not exist");
            return;
        }
        // both variables below are used to create undirected edges between vertices and implementing their weight
        Edge newEdge = new Edge(from, to, weight);
        Edge newEdgeReverse = new Edge(to, from, weight);
    }


    public void Prim(){
        int[] distance = new int[vertices.size()];
        String[] predecessor = new String[vertices.size()];
        boolean[] visited = new boolean[vertices.size()];
        MinHeap<Pair> minHeap =new MinHeap<>();


        ArrayList<Pair> vertexPairs =new ArrayList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor,"N/A");
        Arrays.fill(visited,false);
        if (vertices.size()>0)
            distance[0]=0;
        for(int i=0; i <vertices.size(); i++) {
            vertexPairs.add(new Pair(distance[i], i));
            minHeap.Insert(vertexPairs.get(i));
        }

        // pseudocode for prims while loop

        /*
        while Q is not empty do
            Let u be the value of the entry returned by Q.removeMin().
                Connect vertex u to T using edge connect(e).
        for each edge e′ = (u,v) such that v is in Q do
        {check if edge (u,v) better connects v to T}
        if w(u,v) < D[v] then
        D[v] = w(u,v)
        connect(v) = e′
.
        Change the key of vertex v in Q to D[v].
        return the tree T
         */


        Vertex currentV;
        Edge currentE;
        int MST = 0;
        while(!minHeap.isEmpty()){
            Pair u=minHeap.extractMin();
            for(int i=0; i <vertices.size(); i++){
                currentV = vertices.get(i);

                for (int j = 0; j < currentV.getOutEdges().size(); j++) {
                    currentE = currentV.getOutEdges().get(j);
                    if (currentV.getOutEdges().size() > 0 && currentE.getWeight() < distance[i]) {
                        predecessor[i] = currentE.getToVertex().getName();
                        distance[i] = currentE.getWeight();
                        vertexPairs.get(i).distance = currentE.getWeight();
                        int position = minHeap.getPosition(vertexPairs.get(i));
                        minHeap.decreasekey(position);
                    }
                }
            }
            MST+= distance[u.index];
        }
        System.out.println("Minimum volume TEU: " + MST);
    }



    public void printPrim() {
        Vertex currentVertex;
        for (int i = 0; i < vertices.size(); i++) {
            currentVertex = vertices.get(i);
            System.out.println("Edges from Vertex: " + currentVertex.getName());
            for (int j = 0; j < currentVertex.getOutEdges().size(); j++) {
                Edge currentEdge = currentVertex.getOutEdges().get(j);
                System.out.println("To " + currentEdge.getToVertex().getName() + " volume TEU " + currentEdge.getWeight());
            }
            System.out.println(" ");
        }
    }
}