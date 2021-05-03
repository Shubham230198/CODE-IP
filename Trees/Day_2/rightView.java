/*Return the Right View of the Binary Tree.

    Given the root of a binary tree, imagine yourself standing on the right side of it, 
    return the values of the nodes you can see ordered from top to bottom.

    Input: root = [1,2,3,null,5,null,4]
    Output: [1,3,4]

*/


public class rightView {

    /* Using DFS(reversePreOrder) with a global variable.
        Time: O(n);
        Space: O(h);   {height of tree  ---> Space in recursive functional stack}
    */

    private static int maxDepth = -1;
    
    private static void reversePreOrder(TreeNode root, int nowDepth, List<Integer> rightView) {
        if(root == null) {
            return;
        }
        
        //if this-depth is reached first time, then add into list and update maxDepth
        if(nowDepth > maxDepth) {
            rightView.add(root.val);
            
            maxDepth = nowDepth;
        }
        
        //make reverse PreOrder call.
        reversePreOrder(root.right, nowDepth + 1, rightView);
        reversePreOrder(root.left, nowDepth + 1, rightView);
        
    }
    
    public List<Integer> rightSideView_1(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        
        int nowDepth = 0;
        maxDepth = -1;
        reversePreOrder(root, 0, rightView);
        
        return rightView;
    }
    /*********************************************************************************************** */







    /*Using BFS(levelOrder)  {last node of every level, will be present in the rightView}
        Time: O(n);
        Space: O(w);  {width of the tree}
    */
    public List<Integer> rightSideView_2(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        
        if(root == null) {
            return rightView;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- != 0) {
                TreeNode remNode = q.poll();
                
                //add Children {if Present}
                if(remNode.left != null) q.add(remNode.left);
                if(remNode.right != null) q.add(remNode.right);
                
                
                //if this is the last node of this level, --> {this will be part of rightView}
                if(size == 0) {
                    rightView.add(remNode.val);
                }
                
            }
        }
        
        return rightView;
    }
    /******************************************************************************************************* */

}
