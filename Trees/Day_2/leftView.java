public class leftView {
    

    /*DFS(preOrder) with a global variable.
        Time: O(n);
        Space: O(h); {height of the tree}
    */
    static int maxDepth = -1;
    static void preOrder(Node root, int nowDepth, ArrayList<Integer> leftView) {
        if(root == null) {
            return;
        }
        
        //if we reached this-depth for first time, this will be a part of leftView
        if(nowDepth > maxDepth) {
            leftView.add(root.data);
            maxDepth = nowDepth;
        }
        
        
        //make preOrder calls.
        preOrder(root.left, nowDepth + 1, leftView);
        preOrder(root.right, nowDepth + 1, leftView);
    }
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView_1(Node root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        
        int nowDepth = 0;
        maxDepth = -1;
        preOrder(root, nowDepth, leftView);
        
        return leftView;
    }
    /********************************************************************************************** */









    /*BFS(LevelOrder)   {first node of every level will be in leftOrder}
        Time: O(n);
        Space: O(w);   {width of the tree}

    */
    ArrayList<Integer> leftView_2(Node root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        
        if(root == null) return leftView;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
          
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                
                Node remNode = q.poll();
                
                //if this is the first node of this level, this will be part of leftView.
                if(i == 0) {
                    leftView.add(remNode.data);
                }
                
                
                //add children if not null
                if(remNode.left != null) q.add(remNode.left);
                if(remNode.right != null) q.add(remNode.right);
            }
        }
        
        return leftView;
    }
    /********************************************************************************************* */

}
