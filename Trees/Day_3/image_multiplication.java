/*Image Multiplication 

    You are given a binary tree. Your task is pretty straightforward. You have to find the sum of the product of each node and its mirror image
    (The mirror of a node is a node which exists at the mirror position of the node in opposite subtree at the root.). 
    Don’t take into account a pair more than once. The root node is the mirror image of itself.

    The answer may be very large, compute the answer modulo 10^9 + 7.

    Input:
                       1                 
                   /        \
                  3           2
                /  \         /  \
               7     6       5    4
             /   \    \     /  \    \
           11    10    15  9    8    12

    Output:
    332

    Explanation:
    Sum = (1*1) + (3*2) + (7*4) + (6*5) + (11*12) + (15*9) = 332
*/


public class image_multiplication {
    

    /*Using Mirror-traversal (DFS)-{without return type & global method} on left-SubTree and right-SubTree of root, And a global variable to keep track of all the totalProduct.

        Time: O(n);
        Space: O(h);  {due to DFS}
    */
    private static int MOD = 1_000_000_007;
    private static long finalProduct = 0; 
    
    //helping function.
    private static void getMirroredProduct_1(Node leftPtr, Node rightPtr) {
        if(leftPtr == null || rightPtr == null) {
            return;
        }
        
        //sum the product of leftPtr and rightPtr;
        finalProduct += ((leftPtr.data%MOD) * (rightPtr.data%MOD)) % MOD;
        finalProduct %= MOD;
        
        
        //make corresponding calls for pointers
        getMirroredProduct(leftPtr.left, rightPtr.right);
        getMirroredProduct(leftPtr.right, rightPtr.left);
    }
     
    //actual function.
    public long imgMultiply_1(Node root) {
        if(root == null) {
            return 0;
        }
        
        //initialize the finalProduct with (root-val * root-val), as this is mirror-point of itself
        finalProduct = (root.data%MOD * root.data%MOD) % MOD;
        
        //Note: it is very important to deal with left-Subtree and rightSubtree seperately, unless each product will be repeated twice.

        //get the product from leftSubtree-Ptr and rightSubTree-Ptr
        Node leftPtr = root.left;
        Node rightPtr = root.right;
        getMirroredProduct(leftPtr, rightPtr);
        
        //return the finalProduct;
        return finalProduct;
    }
    /********************************************************************************************************* */








    /*Using Mirror-traverasal (DFS)-{with return type} over leftSubtree and rightSubtree of root.
        Time: O(n);
        Space: O(h);   {DFS}

    */
    private static long getMirroredProduct_2(Node leftPtr, Node rightPtr) {
        if(leftPtr == null || rightPtr == null) {
            return 0;
        }
        
        //make corresponding calls for pointers
        long leftAns = getMirroredProduct(leftPtr.left, rightPtr.right);
        long rightAns = getMirroredProduct(leftPtr.right, rightPtr.left);
        

        //sum the product of leftPtr and rightPtr;
        long currAns = ((leftPtr.data%MOD) * (rightPtr.data%MOD)) % MOD;
        
        //add leftAns and rightAns to "currAns";
        currAns = (currAns + leftAns)%MOD;
        currAns = (currAns + rightAns)%MOD;
        
        //return the currentAns;
        return currAns;
    }
     

    public long imgMultiply_2(Node root) {
        if(root == null) {
            return 0;
        }
        
        //initialize the finalProduct with (root-val * root-val), as this is mirror-point of itself
        long finalProduct = (root.data%MOD * root.data%MOD) % MOD;
        
        //get the mirror-product Sum from leftSubtree-Ptr and rightSubTree-Ptr, and add it finalProduct;
        Node leftPtr = root.left;
        Node rightPtr = root.right;
        finalProduct = (finalProduct + getMirroredProduct(leftPtr, rightPtr)) % MOD;
        
        //return the finalProduct;
        return finalProduct;
    }
    /********************************************************************************************************* */
}
