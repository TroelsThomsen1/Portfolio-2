package com.company;

public class Main {


    public static void main(String[] args) {
        System.out.println("Shipping Container Cost");
        System.out.println();


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

        adjacencylist.printPrim();
        adjacencylist.Prim();

    }
}