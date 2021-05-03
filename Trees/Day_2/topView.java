/* Print Top View of a Tree.

     The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

    Input:
           10
        /      \
      20         30
    /   \      /    \
    40   60   90    100

    Note: Never try to do this with DFS.
*/

public class topView {


    /*BFS{LevelOrder} with a Map and leftMin & rightMax variables.
        Time: O(n);
        Space: O(w);
    */
    static class pair {
        Node node;
        int dist;
        
        pair(Node n, int d) {
            this.node = n;
            this.dist = d;
        } 
    }
    
    
    static ArrayList<Integer> topView(Node root) {
        
        //get the map-fill, using LevelOrder;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftMin = 0;
        int rightMax = 0;
        
        //fill the map, accordingly
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        
        while(!q.isEmpty()) {
            pair remPair = q.poll();
            
            //if this dist is reached first time, this will present in topView.
            if(map.containsKey(remPair.dist) == false) {
                map.put(remPair.dist, remPair.node.data);
            }
            
            //update the leftMin and rightMax accordingly
            leftMin = Math.min(leftMin, remPair.dist);
            rightMax = Math.max(rightMax, remPair.dist);
            
            //add children if present
            if(remPair.node.left != null) q.add(new pair(remPair.node.left, remPair.dist - 1));
            
            if(remPair.node.right != null) q.add(new pair(remPair.node.right, remPair.dist + 1));
        }
        
        
        //fill the topView list from map, using leftMin and rightMax
        ArrayList<Integer> topView = new ArrayList<>();
        
        for(int dist = leftMin; dist <= rightMax; dist++) {
            topView.add(map.get(dist));
        }
        
        return topView;
    }
    /************************************************************************************************* */
}
