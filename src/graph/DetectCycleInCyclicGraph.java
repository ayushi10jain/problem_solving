package graph;

public class DetectCycleInCyclicGraph {
    public static void main(String[] args) {
        int vertices = 5;
        CreateGraph cg = new CreateGraph(vertices);
        CreateGraph.addedge(0, 1);
        CreateGraph.addedge(1, 2);
        //CreateGraph.addedge(2, 0);
        CreateGraph.addedge(2, 3);
        CreateGraph.addedge(2, 4);
        CreateGraph.addedge(4, 3);
        boolean visited[] = new boolean[vertices];
        boolean recStack[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                System.out.println("In disconnected graph");
              boolean exists =  isCycleExists(i, visited, recStack);
              if(exists){
                  break;
              }
                System.out.println("Cycle Exists" + exists);
            }
        }
    }

    public static boolean isCycleExists(int i, boolean[] visited, boolean[] recStack) {
        System.out.println("value of i" + i);
        if (recStack[i] == true) {
            System.out.println(recStack[i]);
            return true;
        }
        if (visited[i]) {
            return false;
        }
        recStack[i] = true;
        visited[i] = true;
        System.out.println("recStack" + recStack);
        System.out.println("visited" + visited);
        for (int child : CreateGraph.getAdjList()[i]) {
            boolean flag = isCycleExists(child, visited, recStack);
            if (flag == true) {
                return true;
            }
        }
        recStack[i] = false;
        System.out.println("recStack" + recStack);
        return false;
    }

}
