public class articulation_points {
    
    public static int time = 0;
    public void articulationPointsDFS(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, int[] discovery, int[] low, int[] parent, boolean[] isArticulationPoint) {

        //we will be counting the number of children, for treating this as root.
        int children = 0;

        //mark the visited
        visited[node] = true;

        //setting the discovery
        time++;
        discovery[node] = time;
        low[u] = time;

        ArrayList<Integer> adjacents = graph.get(node);
        for(int i = 0; i < adjacents.size(); i++) {
            int childNode = adjacents.get(i);

            if(visited[childNode] == false) {
                children++;
                parent[childNode] = node;

                articulationPointsDFS(graph, childNode, visited, discovery, low, parent, isArticulationPoint);

                //updating the low for current node
                low[node] = Math.min(low[node], low[childNode]);


                //Case-1: when current node is root and has more than 2 children.
                if(parent[node] == -1 && children >= 2) {
                    isArticulationPoint[node] = true;
                }

                //Case-2: when current node is not a root, but low of it's child is ">=" discovery of current node.
                if(parent[node] != -1 && low[childNode] >= disc[node]) {
                    isArticulationPoint[node] = true;
                }
            }
            else if(childNode != parent[node]) {
                low[node] = Math.min(low[node], disc[childNode]);
            }
        }

    }



    public int[] articulationPoints(ArrayList<ArrayList<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        int[] discovery = new int[graph.size()];
        int[] low = new int[graph.size()];
        
        int[] parent = new int[graph.size()];
        boolean[] isArticulationPoint = new boolean[graph.size()];

        //we will be building parent data while doing DFS.
        for(int i = 0; i < graph.size(); i++) {
            parent[i] = -1;
        }


        //calling for all the components
        for(int i = 0; i < graph.size(); i++) {
            if(visited[i] == false) {
                articulationPointsDFS(graph, i, visited, discovery, low, parent, isArticulationPoint);
            }
        }

        //return isArticulation array;
        return isArticulationPoint;
    }
}
