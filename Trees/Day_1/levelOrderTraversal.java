/* Binary Tree Level Order Traversal

    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

*/

public class levelOrderTraversal {    

    /*Using a Queue {using size variable}
        Time: O(n);
        Space: O(max-width of the tree);
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        
        if(root == null) {           //Important condition, unless result into compilation error.
            return levelOrderList;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> thisLevelList = new ArrayList<>();    //List for everyLevel.
            
            while(size-- != 0) {
                TreeNode rem = q.poll();
                
                //push into the list,
                thisLevelList.add(rem.val);
                
                //add children
                if(rem.left != null)
                    q.add(rem.left);
                
                if(rem.right != null)
                    q.add(rem.right);
            }
            
            levelOrderList.add(thisLevelList);
        }
        
        return levelOrderList;
    }
    /*******************************************************************************88** */
}
