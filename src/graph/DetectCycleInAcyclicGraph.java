package graph;

public class DetectCycleInAcyclicGraph {
    public static void main(String[] args) {
        int vertices = 5;
        CreateGraph cg = new CreateGraph(vertices);
        CreateGraph.addedge(0,1);
        CreateGraph.addedge(1,2);
        CreateGraph.addedge(2,3);
        CreateGraph.addedge(3,4);
        CreateGraph.addedge(2,0);
        boolean [] visited = new boolean[vertices];
        for (int i =0; i< vertices; i++) {
            if(visited[i] == false) {
                boolean flag = isCycleExists(i, -1, visited);
            }
        }
    }

    public  static boolean isCycleExists(int child, int parent, boolean[] visited){
        if(visited[child] == false ){
            visited[child] = true;
        }
//        if(visited[child] == true && child!=parent){
//            return true;
//        }

        for(int node : CreateGraph.getAdjList()[child]){

            if(visited[node] == false){
              if (isCycleExists(node,child,visited)){
                  return true;
              }

            }
            else{
                if(parent!=child){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
