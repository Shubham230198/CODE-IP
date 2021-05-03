/*Lowest Common Ancestor of a Binary Tree

    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/


public class lca_inBinaryTree {
    
    /*Single Traversal based,
        Time: O(n);
        Space: O(h); {DFS} 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base condition
        if(root == null) {
            return null;
        }

        //if anyone of "p" or "q" are root, return the root. {as it can be lca}
        if(root == p || root == q) {
            return root;
        }
        
        TreeNode leftAnswer = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAnswer = lowestCommonAncestor(root.right, p, q);
        
        if(leftAnswer != null && rightAnswer != null) {
            return root;
        }
        
        return (leftAnswer == null ? rightAnswer : leftAnswer);
    }
    /********************************************************************************************** */







    /*Using Node-to-Root-Path, to find LCA Node.
        Time: O(n + n + h);     {two node-to-root-path + traversal over these node-to-root-path to find lca}
        Space: O(2*h);   {two node-to-root path storage}
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        ArrayList<TreeNode> pReversePath = getNodeToRootPath(root, p);
        ArrayList<TreeNode> qReversePath = getNodeToRootPath(root, q);
        
        
        //now find lca-node by using above root-to-node-paths.
        TreeNode lca = root;
        int idx1 = pReversePath.size() - 1;
        int idx2 = qReversePath.size() - 1;
        
        while(idx1 >= 0 && idx2 >= 0) {
            
            if(pReversePath.get(idx1) == qReversePath.get(idx2)) {
                lca = pReversePath.get(idx1);
            }
            else {
                break;
            }
            
            idx1--;
            idx2--;
        }
        
        return lca;
    }
    
    
    //Root-to-node-path function.
    private ArrayList<TreeNode> getNodeToRootPath(TreeNode root, TreeNode node) {
        if(root == null) {
            return null;
        }
        
        
        if(root == node) {
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            
            return list;
        }
        
        
        ArrayList<TreeNode> leftList = getNodeToRootPath(root.left, node);
        if(leftList != null) {
            leftList.add(root);
            return leftList;
        } 
        
        ArrayList<TreeNode> rightList = getNodeToRootPath(root.right, node);
        if(rightList != null) {
            rightList.add(root);
            return rightList;
        }
        
        
        return null;
    }
    /********************************************************************************************* */
}
