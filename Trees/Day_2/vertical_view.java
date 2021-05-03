/*vertial Order Traversal of a Tree.

    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

    Note:- For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. 
    The root of the tree is at (0, 0).


    The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting 
    from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. 
    In such a case, sort these nodes by their values.

    Input: root = [1,2,3,4,5,6,7]
    Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation:
    Column -2: Only node 4 is in this column.
    Column -1: Only node 2 is in this column.
    Column 0: Nodes 1, 5, and 6 are in this column.
            1 is at the top, so it comes first.
            5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
    Column 1: Only node 3 is in this column.
    Column 2: Only node 7 is in this column.
*/


public class vertical_view {
    


    /*Here, simply the order when horizontal-index Collides, will be from top level to bottom level.
     //if the level collides too, order will be from left to right.

        Time: O(n);
        Space: O(w);

    */

    //Queue-Pair class, for helping in LevelOrderTraversal while keeping track of "hori".
    private static class QPair {
        TreeNode node;
        int hori;
        
        QPair(TreeNode n, int h) {
            this.node = n;
            this.hori = h;
        }
    }

    
    public List<List<Integer>> verticalTraversal_1(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        
        if(root == null) {
            return verticalOrder;
        }
        
        
        
        //fill the map with LevelOrder, maintaining Horizontal and vertical indexing.
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int leftMin = 1;
        int rightMax = -1;
        
        Queue<QPair> q = new LinkedList<>();
        q.add(new QPair(root, 0));
        
        while(!q.isEmpty()) {
            
            QPair rem = q.poll();
            
            //Add in the Map, (key as its horizontal distance), and accordingly update the leftMin and rightMax with "rem.hori";
            if(map.containsKey(rem.hori) == true) {
                map.get(rem.hori).add(rem.node.val);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(rem.node.val);
                map.put(rem.hori, list);
                
                //update the leftMin and rightMax;
                leftMin = Math.min(leftMin, rem.hori);
                rightMax = Math.max(rightMax, rem.hori);
            }
            
            
            //add children if exists
            if(rem.node.left != null) q.add(new QPair(rem.node.left, rem.hori - 1));
            if(rem.node.right != null) q.add(new QPair(rem.node.right, rem.hori + 1));
        }
    
        
        
        
        //fill the verticalOrder list from map.
        for(int dist = leftMin; dist <= rightMax; dist++) {
            
            //get the corresponding vertical order from map, and fill in the answer-list accordingly.
            ArrayList<Integer> list = map.get(dist);
            
            List<Integer> thisVLevel = new ArrayList<>();
            for(int val: list) {
                thisVLevel.add(val);
            }
            
            verticalOrder.add(thisVLevel);
        }
        
        
        return verticalOrder;
    }
    /********************************************************************************************************* */




    /*Note: Here in below code if two or more nodes collide in verticalOrder:-
        //They are ordered on first-Of-Horizontal index.
        //if the horizontal index is also same for two or more nodes, then they are needed in sorted order of node-value.

    
    Logic: Using LevelOrder, along with a HashMap of horiDist-vs-ListOfNodes

        Time: O(n + k)  {traversal + someSorting}
        Space: O(w);
    */

    //Queue Pair class, for traversal while maintaining "hori" and "verti" index of the tree.
    private static class QPair {
        TreeNode node;
        int hori;
        int verti;
        
        QPair(TreeNode n, int h, int v) {
            this.node = n;
            this.hori = h;
            this.verti = v;
        }
    }
    
    //List-Pair class, which will be used in HashMap second  element. 
    private static class LPair implements Comparable<LPair> {
        int val;
        int hori;
        
        LPair(int v, int h) {
            this.val = v;
            this.hori = h;
        }
        
        public int compareTo(LPair other) {
            
            if(this.hori != other.hori) {
                return this.hori - other.hori;
            }
            else {
                return this.val - other.val;
            }
        }
    }
    

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        
        if(root == null) {
            return verticalOrder;
        }
        
        
        
        //fill the map with LevelOrder, maintaining Horizontal and vertical indexing.
        HashMap<Integer, ArrayList<LPair>> map = new HashMap<>();
        
        int leftMin = 1;
        int rightMax = -1;
        
        Queue<QPair> q = new LinkedList<>();
        q.add(new QPair(root, 0, 0));
        
        while(!q.isEmpty()) {
            
            QPair rem = q.poll();
            
            //Add in the Map, (key as its horizontal distance), and accordingly update the leftMin and rightMax with "rem.hori";
            if(map.containsKey(rem.hori) == true) {
                map.get(rem.hori).add(new LPair(rem.node.val, rem.verti));
            }
            else {
                ArrayList<LPair> list = new ArrayList<>();
                list.add(new LPair(rem.node.val, rem.verti));
                map.put(rem.hori, list);
                
                //update the leftMin and rightMax;
                leftMin = Math.min(leftMin, rem.hori);
                rightMax = Math.max(rightMax, rem.hori);
            }
            
            
            //add children if exists
            if(rem.node.left != null) q.add(new QPair(rem.node.left, rem.hori - 1, rem.verti + 1));
            if(rem.node.right != null) q.add(new QPair(rem.node.right, rem.hori + 1, rem.verti + 1));
        }
        
        
        
        
        
        //fill the verticalOrder list from map.
        for(int dist = leftMin; dist <= rightMax; dist++) {
            
            //get a vertical order, sort it and fill in the answer-list accordingly.
            ArrayList<LPair> list = map.get(dist);
            Collections.sort(list);
            
            List<Integer> thisVLevel = new ArrayList<>();
            for(LPair lp: list) {
                thisVLevel.add(lp.val);
            }
            
            verticalOrder.add(thisVLevel);
        }
        
        
        return verticalOrder;
    }
    /*********************************************************************************************************** */
}
