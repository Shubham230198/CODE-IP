/*Diagonal Traversal of Binary Tree

    Given a Binary Tree, print the diagonal traversal of the binary tree.
    Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.


    Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13

    Output : 8 10 14 3 6 7 13 1 4


*/


public class diagonal_Traversal {
    

    //This is order of elements are usually preferred.
    /* Using DFS, with keeping a track of leftMin. {Will give diagonalLevel elements into the same diagonal Order.}

        *Way:- While going leftChild (dist - 1), while going rightChild (dist-only)
        Time: O(n);
        Space: O(h);

    */
    private static int leftMin = 0;
    private static void preOrder(Node root, HashMap<Integer, ArrayList<Integer>> map, int leftDist) {
        if(root == null) {
            return;
        }
        
        if(map.containsKey(leftDist) == true) {
            map.get(leftDist).add(root.data);    
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            
            map.put(leftDist, list);
            
            //update the leftMin
            leftMin = Math.min(leftMin, leftDist);
        }
        
        
        //call to childrens
        preOrder(root.left, map, leftDist - 1);
        preOrder(root.right, map, leftDist);
    }
    

    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> diagonalList = new ArrayList<>();
        
        if(root == null) {
            return diagonalList;
        }
        
        //get the map filled, by preOrder (also keeping a track of leftMin)
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int leftDist = 0;
        leftMin = 1;
        preOrder(root, map, leftDist);
        
        
        
        //add to diagonalList list, the diagonal traversals from the map, using leftMin;
        
        for(int dist = 0; dist >= leftMin; dist--) {
            for(int ele: map.get(dist)) {
                diagonalList.add(ele);
            }
        }
        
        //return the diagonalList
        return diagonalList;
    }
    /********************************************************************************************* */










    //Ususally not required.  (becoz weired order in the same-level elements)
    /*BFS {only when order required over elements of same diagonal, is same-level first}
    
        *Way:- While going leftChild (dist - 1), while going rightChild (dist-only)

        Time: O(n);
        Space: O(w)

    */
    private static class pair {
        Node node;
        int dist;
        
        pair(Node n, int d) {
            this.node = n;
            this.dist = d;
        }
    }
    
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> diagonalList = new ArrayList<>();
        
        if(root == null) {
            return diagonalList;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int leftMin = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        
        while(!q.isEmpty()) {
            pair remPair = q.poll();
            
            if(map.containsKey(remPair.dist) == true) {
                map.get(remPair.dist).add(remPair.node.data);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(remPair.node.data);
        
                map.put(remPair.dist, list);
                
                //update leftMin, as new diagonal-level is created.
                leftMin = Math.min(leftMin, remPair.dist);
            }
            
            
            //add children if exist, {left with (dist - 1), while right with (dist only);
            if(remPair.node.left != null) q.add(new pair(remPair.node.left, remPair.dist - 1));
            if(remPair.node.right != null) q.add(new pair(remPair.node.right, remPair.dist));
        }
        
        

        
        //add to diagonalList list, the diagonal traversals from the map, using leftMin;
        
        for(int dist = 0; dist >= leftMin; dist--) {
            for(int ele: map.get(dist)) {
                diagonalList.add(ele);
            }
        }
        
        //return the diagonalList
        return diagonalList;
    }
    /******************************************************************************************************** */
}
