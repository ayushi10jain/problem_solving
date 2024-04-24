package graph;

import java.util.LinkedList;
import java.util.Stack;


public class DFS {

    public static void main(String[] args) {
        int vertices = 5;
        CreateGraph cg = new CreateGraph(vertices);
        CreateGraph.addedge(0,1);
        CreateGraph.addedge(0,2);
        CreateGraph.addedge(1,3);
        CreateGraph.addedge(2,3);
        CreateGraph.addedge(3,4);
        boolean visited [] = new boolean[vertices];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<vertices; i++) {
           if(visited[i] == false)
            printDFSUsingStack(0,visited,s);
        }
    }

    private static void printDFS(int startVertex, boolean[] visited) {

        if(!visited[startVertex]){
            visited[startVertex] = true;
            System.out.println("StartVertex is :" + startVertex);
            for(Integer child : CreateGraph.getAdjList()[startVertex]){
                if(!visited[child]){
                    printDFS(child, visited);
                }
            }
        }
    }

    private static void printDFSUsingStack(int startVertex, boolean[] visited, Stack<Integer> track){
            track.add(startVertex);

            while(!track.empty()) {
                int vertex = track.pop();

                if(visited[vertex] == false) {
                    System.out.println("StartVertex is :" + vertex);
                    visited[vertex] = true;
                }
                for(Integer child : CreateGraph.getAdjList()[vertex]){

                    if(visited[child] == false){
                    track.add(child);
                }
            }
        }
    }
}
