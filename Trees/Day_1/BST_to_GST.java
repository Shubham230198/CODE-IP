/*Binary Search Tree to greater sum tree.

    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the 
    original key plus sum of all keys greater than the original key in BST.

    As a reminder, a binary search tree is a tree that satisfies these constraints:
        1. The left subtree of a node contains only nodes with keys less than the node's key.
        2. The right subtree of a node contains only nodes with keys greater than the node's key.
        3. Both the left and right subtrees must also be binary search trees.

    Input: root = [3,2,4,1]
    Output: [7,9,4,10]



    Note: It is not possible to solve this question using return type, {instead of global variable, or heap object}
*/



public class BST_to_GST {
    

    /*using global static variable.
        Time: O(n);
        Space: O(1);
    */
    static int greaterSum = 0;
    
    private void createGST(TreeNode root) {
        if(root == null) {
            return;
        }
        
        //traversing in reverse inOrder. {right-root-left}
        createGST(root.right);
        
        //set the root-node value{greater-Sum} & new-greaterSum value;
        greaterSum += root.val;
        root.val = greaterSum;
        
        createGST(root.left);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        
        greaterSum = 0;
        createGST(root);
        
        
        return root;
    }
    /****************************************************************** */









    /*Using an array of 1 length, as argument.   {without any global variable}
        Time: O(n);
        Space: O(1);
    */
    private void createGST(TreeNode root, int[] sumArr) {
        if(root == null) {
            return;
        }
        
        
        //traversing in reverse inOrder. {right-root-left}
        createGST(root.right, sumArr);
        
        //set the root-node value{greater-Sum} & new-greaterSum value;
        sumArr[0] += root.val;
        root.val = sumArr[0];
        
        
        createGST(root.left, sumArr);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        
        int[] sumArr = new int[1];
        sumArr[0] = 0;
        createGST(root, sumArr);
        
        
        return root;
    }
    /*************************************************************************** */

}
