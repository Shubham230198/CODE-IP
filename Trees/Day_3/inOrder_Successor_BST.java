/*Inorder Successor in BST

    Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

    If the given node has no in-order successor in the tree, return null.

    Input: {2,1,3}, node with value 1
    Output: 2
    Explanation: 
         2
        / \
       1   3

*/


public class inOrder_Successor_BST {
    

    /*Iterative Approach,  {Better Approach, then 2nd Approach} 
        --> if rightChild of "p Node" is not null, then minNode in it's rightSubTree is Successor. 
        -->else (if rightChild is null), then it's ancestor with leftChild in currentPath will be answer.


        Time: O(h)  {height}
        Space: O(1) 
    */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null) {
            return null;
        }

        if(p.right != null) {
            return getMinInSubTree(p.right);
        }

        TreeNode succ = null;
        
        while(root != null) {

            if(root.val < p.val) {
                root = root.right;
            }
            else if(root.val > p.val) {
                succ = root;
                root = root.left;
            }
            else {
                break;
            }
        }

        return succ;
    }


    public static TreeNode getMinInSubTree(TreeNode root) {
        if(root.left == null) {
            return root;
        }

        return getMinInSubTree(root.left);
    }
    /*********************************************************************************************************** */







    //Note: not a preffered approach.

    /*Recursive Approach, with a globalVariable {to find parent with leftChild in the currentPath}

        Time: O(h);
        Space: O(1);

    */
    private static TreeNode successor;

    private static TreeNode getMinInBST(TreeNode root) {
        if(root.left == null) {
            return root;
        }

        return getMinInBST(root.left);
    }


    private static void setParentWithLeftChild(TreeNode root, TreeNode p) {
        //no need of base case, as it is BST-Search and p exists for sure.


        if(root.val == p.val) {
            return;
        }
        else if(root.val < p.val) {
            setParentWithLeftChild(root.right, p);
        }
        else {            //root.val > p.val

            //set the successor, as this will be a leftCall
            successor = root;
            setParentWithLeftChild(root.left, p);
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //update successor for every new testCase.
        successor = null;

        //if root is null, return null.
        if(root == null) {
            return successor;
        }

        //if rightChild is not null, then answer will be minOf-RightChildSubtree.
        if(p.right != null) {
            successor = getMinInBST(p.right);
        }
        else {
            setParentWithLeftChild(root, p);
        }

        return successor;
    }
    /******************************************************************************************************* */
}
