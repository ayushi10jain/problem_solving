package graph;

import java.util.LinkedList;


public class CreateGraph {
    static int vertices;
    static int edges;
    static LinkedList<Integer>[] adj;

    public CreateGraph(int vertices){
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];
        for (int i=0; i<adj.length; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args) {
        CreateGraph cg = new CreateGraph(5);
        addedge( 0, 1);
        addedge( 0, 4);
        addedge( 1, 2);
        addedge(1, 3);
        addedge( 1, 4);
        addedge( 2, 3);
        addedge( 3, 4);
        noOfVertices();
        printGraph();
        noOfEdges();
    }

    public static int noOfEdges(){
        return edges;
    }
    public static int noOfVertices(){
        return vertices;
    }
     public static void printGraph() {
         for (int i = 0; i < vertices; i++) {
             System.out.println("Adjacency List ::::" + i);
             System.out.print("head");
             for (int j = 0; j < adj[i].size(); j++) {
                 System.out.print("->" + adj[i].get(j));
             }
             System.out.println();
         }
     }

     public static void addedge(int u,int v){
         adj[u].add(v);
         edges++;
     }

    public static LinkedList<Integer>[] getAdjList(){
        return adj;
    }



}
