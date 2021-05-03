/*Find LCA Node in a Biinary Search Tree.

    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


*/


public class lca_inBST {
    

    /*Node to wich one node lies in left-Subtree(including root) and other lies in right-Subtree(including root).
        Time: O(n);
        Space: O(h);
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //No base case required, as question says both p and q nodes exists in the given tree.
        
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
    /************************************************************************************************ */
}
