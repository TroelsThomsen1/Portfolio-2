package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) {
        double conWeight =0;

        Adjacencylist g = mkgraph1();
        g.printDijk();
        // create graph as the one in the lecture

        // all vertices are done
        int n = g.vertices.size();

        ArrayList<Vertex> vlst=g.vertices;

        PriorityQueue<Vertex> Q = new PriorityQueue<>();

        if (g.vertices.size() > 0) {

            g.vertices.get(0).distance = 0;

            Q.offer(g.vertices.get(0));
        }


        while (!Q.isEmpty()) {

            // make a vertex for the smallest edge and retrieve it from the priority list.
            //and if not, then it is out of tree
            Vertex minCost = Q.poll();
            minCost.IsInTree = false;

            //Weight of edges
            for (int e = 0; e < minCost.getOutEdges().size(); e++) {
                Edge edge = minCost.getOutEdges().get(e);
                Vertex toVertex = edge.getToVertex();

                // if statement that checks if vertex weight less than distance of edge and it is not inside tree
                if (edge.getWeight() < edge.getToVertex().distance && !edge.getToVertex().IsInTree) {
                    Q.remove(toVertex);
                    edge.getToVertex().distance = edge.getWeight();
                    edge.getToVertex().PrevVertex = minCost;
                    Q.offer(edge.getToVertex());
                }
            }
            minCost.IsInTree = true;
            conWeight += minCost.distance;
            System.out.println("Example of priority queue used: " + conWeight);
        }

        boolean[] done= new boolean[n];
        int[] prev= new int[n];
        int[] weight = new int[n];

        Arrays.fill(weight,100000); // Basically no limit to edge weight
        Arrays.fill(prev,-1);
        Arrays.fill(done,false); // All vertices is unvisited
        weight[0]=0; // start vertex has weight 0
        prev[0]=0;   // 0 in array is starting vertex

        while(true) {
            // Step 1: Find the closest vertex amongst those not “done”
            int cur = -1;
            int wgt = 10000; // find index of next node to examine
            for (int i = 0; i < n; i++) {
                if (weight[i] < wgt && !done[i]) {
                    cur = i;
                    wgt = weight[i];
                }
            }
            System.out.println("cur " + cur);
            if(cur<0)break;

            Vertex curV = vlst.get(cur);

            for (Edge e : curV.outEdges) {
                System.out.println("check edge " + e);
                int toIndex = vlst.indexOf(e.to);
                if (weight[cur] + e.weight < weight[toIndex]) {
                    weight[toIndex] = weight[cur] + e.weight;
                    prev[toIndex] = cur;
                }
            }
            done[cur] = true;
        }

        for(int i=0;i<n;i++){
            System.out.println(i+":"+vlst.get(i)+"   "+done[i]+" "
                    +(prev[i]<0?"-":vlst.get(prev[i]))
                    +"  "+weight[i]);
        }

    }
    public static Adjacencylist mkgraph1() {
        Adjacencylist adjacencylist = new Adjacencylist();


        Vertex Jawaharlal_Nehru = new Vertex("Jawaharlal Nehru");
        Vertex Tanjung_Pelepas = new Vertex("Tanjung Pelepas");
        Vertex Dar_Es_Salaam = new Vertex("Dar Es Salaam");
        Vertex Mombasa = new Vertex("Mombasa");
        Vertex Zanzibar = new Vertex("Zanzibar");
        Vertex Jebel_Ali_Dubai = new Vertex("Jebel Ali Dubai");
        Vertex Salalah = new Vertex("Salalah");


        adjacencylist.addVertex(Jawaharlal_Nehru);
        adjacencylist.addVertex(Tanjung_Pelepas);
        adjacencylist.addVertex(Dar_Es_Salaam);
        adjacencylist.addVertex(Mombasa);
        adjacencylist.addVertex(Zanzibar);
        adjacencylist.addVertex(Jebel_Ali_Dubai);
        adjacencylist.addVertex(Salalah);

        adjacencylist.newEdge(Jawaharlal_Nehru, Mombasa, 2000);
        adjacencylist.newEdge(Jawaharlal_Nehru, Dar_Es_Salaam, 2000);
        adjacencylist.newEdge(Tanjung_Pelepas, Mombasa, 5000);
        adjacencylist.newEdge(Tanjung_Pelepas, Dar_Es_Salaam, 3000);
        adjacencylist.newEdge(Tanjung_Pelepas, Zanzibar, 2000);
        adjacencylist.newEdge(Tanjung_Pelepas, Jebel_Ali_Dubai, 7000);
        adjacencylist.newEdge(Tanjung_Pelepas, Salalah, 7000);
        adjacencylist.newEdge(Dar_Es_Salaam, Tanjung_Pelepas, 5000);
        adjacencylist.newEdge(Dar_Es_Salaam, Jawaharlal_Nehru, 3000);
        adjacencylist.newEdge(Dar_Es_Salaam, Jebel_Ali_Dubai, 2000);
        adjacencylist.newEdge(Mombasa, Salalah, 2000);
        adjacencylist.newEdge(Mombasa, Jebel_Ali_Dubai, 500);
        return adjacencylist;
    }
}