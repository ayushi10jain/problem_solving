package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int vertices = 5;
        CreateGraph cg = new CreateGraph(vertices);
        CreateGraph.addedge(0, 1);
        CreateGraph.addedge(0, 2);
        CreateGraph.addedge(1, 2);
        CreateGraph.addedge(1, 4);
        CreateGraph.addedge(4, 4);
        boolean[] visited = new boolean[vertices];
        Queue<Integer> track = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                track.add(i);
                bfs(i, visited, track);
            }
        }

    }

    public static void bfs(int start, boolean[] visited, Queue<Integer> track) {
        while (!track.isEmpty()) {
            int parent = track.poll();
            if (visited[parent] == false) {
                visited[parent] = true;
                System.out.println(parent);
                for (int child : CreateGraph.getAdjList()[parent]) {
                    if(visited[child] == false){
                        track.add(child);
                    }
                }
            }

        }
    }
}
