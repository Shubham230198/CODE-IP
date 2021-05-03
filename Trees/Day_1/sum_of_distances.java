/*Sum of Distances in Tree

    An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
    The ith edge connects nodes edges[i][0] and edges[i][1] together.

    Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

    Note: As we don't know the root, we will deal with it by making bi-directional graph. (for this tree) 

Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]

Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5

  We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.


*/



//Note: Here, the work of (DistanceFrom_0) and (getSubTreeSizeFilled) function, could be done by (single DFS Function with a globalVariable).  Leading To reduce the time complexity --> O(2*n)


public class sum_of_distances {
    

    /*get DistanceofAllNodesFrom_0, sizeOfAllSubTrees, and then calculate the distance of all nodes.

        Time: O(n + n + n);  {for the above specific fucntions}
        Space: O(w);
    */
    private static class QPair {
        int node;
        int dist;
        
        QPair(int n, int d) {
            this.node = n;
            this.dist = d;
        }
    }
    

    //Using BFS (O(n))
    public static int getDistanceFrom_0(HashMap<Integer, ArrayList<Integer>> map) {
        
        int distance = 0;
        boolean[] visited = new boolean[map.size()];
        
        
        Queue<QPair> q = new LinkedList<>();
        q.add(new QPair(0, 0));
        visited[0] = true;
        
        while(!q.isEmpty()) {
            QPair rem = q.poll();
            
            distance += rem.dist;
            
            
            for(int nebr: map.get(rem.node)) {
                
                if(visited[nebr] == false) {
                    visited[nebr] = true;
                    q.add(new QPair(nebr, rem.dist + 1));
                }
            }
        }
        
        return distance;
    }
    
    
    
    
    //Using DFS function to fill the subTreeCount Array.  O(n)
    private static int getSubTreeSizeFilled(HashMap<Integer, ArrayList<Integer>> map, int[] subTreeSize, boolean[] visited, int node) {
        
        int currSize = 1;
        
        for(int nebr: map.get(node)) {
            
            if(visited[nebr] == false) {
                visited[nebr] = true;
                
                currSize += getSubTreeSizeFilled(map, subTreeSize, visited, nebr);
            }
        }
        
        subTreeSize[node] = currSize;
        
        return currSize;
    }
    
    
    
    //fill distanceOfNodes for all Nodes. (Using BFS)
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] allDistance = new int[N];

        if(N <= 1) {
            return allDistance;
        }        
        
        
        //create a bi-directional graph, for corresponing tree (as we dont know the root)
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(map.containsKey(u)) {
                map.get(u).add(v);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(v);
                
                map.put(u, list);
            }
            
            if(map.containsKey(v)) {
                map.get(v).add(u);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(u);
                
                map.put(v, list);
            }
        }
        
        
        
        //find the distance of allNodes from node-0 using BFS.   {could be done with DFS and a global-variable too}
        int distanceFrom_0 = getDistanceFrom_0(map);
        
        
        //make a subTreeSize Array, and get it filled using DFS.   {very difficult with BFS}
        int[] subTreeSize = new int[N];
        boolean[] visited = new boolean[N];
        visited[0] = true;
        
        getSubTreeSizeFilled(map, subTreeSize, visited, 0);
        

        
        
        //fill allDistance array, accordingly.
        allDistance[0] = distanceFrom_0;
        
        Arrays.fill(visited, false);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            
            int rem = q.poll();
            
    
            //add children, while filling there allDistance answer.
            for(int nebr: map.get(rem)) {
                
                if(visited[nebr] == false) {
                    visited[nebr] = true;
                    q.add(nebr);
                    
                    //fill answer of nebr
                    allDistance[nebr] = allDistance[rem] - subTreeSize[nebr] + (N - subTreeSize[nebr]);
                }
            }
        }
        
        return allDistance;
    }
    /************************************************************************************************************** */
}
