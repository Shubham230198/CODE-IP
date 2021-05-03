/*Given a binary tree, print the bottom view from left to right.

    Note: Never use DFS here.

*/


public class bottomView {


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
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView_1(Node root) {
        //get the map-fill, using levelOrder;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftMin = 0;
        int rightMax = 0;
        
        //fill the map, accordingly
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        
        while(!q.isEmpty()) {
            pair remPair = q.poll();
            
            //update the map for thisDist everyTime.
            map.put(remPair.dist, remPair.node.data);
            
            
            //update the leftMin and rightMax accordingly
            leftMin = Math.min(leftMin, remPair.dist);
            rightMax = Math.max(rightMax, remPair.dist);
            
            //add children if present
            if(remPair.node.left != null) q.add(new pair(remPair.node.left, remPair.dist - 1));
            
            if(remPair.node.right != null) q.add(new pair(remPair.node.right, remPair.dist + 1));
        }
        
        
        //fill the bottomlist from map, using leftMin and rightMax
        ArrayList<Integer> bottomView = new ArrayList<>();
        
        for(int dist = leftMin; dist <= rightMax; dist++) {
            bottomView.add(map.get(dist));
        }
        
        return bottomView;
    }
    /************************************************************************************************************ */
}