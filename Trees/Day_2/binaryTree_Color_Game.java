/*Binary Tree coloring game problem.

    Link: https://leetcode.com/problems/binary-tree-coloring-game/

*/



public class binaryTree_Color_Game {
    

    /*get the sizes of leftSubtree, rightSubtree, and remaining-tree with respect to redNode.  
        {if any of those sizes are greater than totalNode/2, then we can win the game}

        Time: O(n);
        Space: O(1);
    */
    private static TreeNode getNode(TreeNode root, int x) {
        if(root == null) return null;
        
        if(root.val == x) {
            return root;
        }
        
        TreeNode leftAns = getNode(root.left, x);
        if(leftAns != null) {
            return leftAns;
        }
        
        TreeNode rightAns = getNode(root.right, x);
        if(rightAns != null) {
            return rightAns;
        }
        
        return null;
    }
    
    
    private static int getSize(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int nowSize = 1;
        
        nowSize += getSize(root.left);
        nowSize += getSize(root.right);
        
        return nowSize;
    }
    
    
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode redNode = getNode(root, x);
        
        //get the sizes of the left and right size.
        int leftSize = getSize(redNode.left);
        int rightSize = getSize(redNode.right);
        
        //size of remaining tree-part;
        int remainingSize = n - leftSize - rightSize - 1;
        
        
        //check the chances of winning
        int fact = n/2;
        
        if(leftSize > n/2 || rightSize > n/2 || remainingSize > n/2) {
            return true;
        }
        else {
            return false;
        }
    }
    /****************************************************************************************** */
}
