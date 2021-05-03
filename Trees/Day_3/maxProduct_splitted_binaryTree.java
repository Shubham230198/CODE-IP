/* Maximum Product of Splitted Binary Tree

    Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
    Since the answer may be too large, return it modulo 10^9 + 7.


    Input: root = [1,2,3,4,5,6]
    Output: 110
    Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)

*/



public class maxProduct_splitted_binaryTree {
    

    /*Using Approach somewhat similar to getAllNodesDistances.

        Way: --->get allTreeSum.
             --->start traversing the tree in PreOrder(return size-of-everySubTree), 
                 & in postWork, update the maxProduct by leftBreak and rightBreak Products.

                 leftBreak = leftSum * (totalSum - leftSum);
                 rightBreak = rightSum * (total - rightSum);


        Time: O(n + n)  {allTreeSum + maximise the maxProduct}
        Space: O(h) {DFS}

    */


    //helper fucntion to getSum of tree. O(n) {DFS}
    private long getTotalSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        long currSum = root.val;
        
        currSum += getTotalSum(root.left);
        currSum += getTotalSum(root.right);
        
        return currSum;
    }
    
    
    //global MaxProduct vaiable
    private static long maxProduct;

    //main logical function to maximise the maxProduct.
    private static long setMaxProduct(TreeNode root, long totalSize) {
        if(root == null) {
            return 0;
        }
        
        
        //create the leftBreak Product
        long leftSum = setMaxProduct(root.left, totalSize);
        long leftBreakProduct = (leftSum)*(totalSize - leftSum);
        
        //create the rightBreak Product
        long rightSum = setMaxProduct(root.right, totalSize);
        long rightBreakProduct = (rightSum)*(totalSize - rightSum);
        
        
        //update the maxProduct, with max of all three
        maxProduct = Math.max(maxProduct, leftBreakProduct);
        maxProduct = Math.max(maxProduct, rightBreakProduct);
        
        
        //return totalSubTreeSum from current root.
        return leftSum + rightSum + root.val;
        
    }
    
    
    //main entrance function
    public int maxProduct(TreeNode root) {
        
        //get the TotalSum of the tree
        long totalSum = getTotalSum(root);
        
        
        //initalize the maxProduct
        maxProduct = 0;
        setMaxProduct(root, totalSum);
        
        //return maxProduct;
        return (int)(maxProduct % (1_000_000_007));
    }

    /************************************************************************************* */
}
