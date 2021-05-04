/*Find Bottom Left Tree Value

    Given the root of a binary tree, return the leftmost value in the last row of the tree.

    Input: root = [1,2,3,4,null,5,6,null,null,7]
    Output: 7

*/


public class findLeftMostNode_ofLastLevel {
    
    /*PreOrder(DFS), with a track of maxDepth.
        ---> Whenever nowDepth > maxDepth, update the ansVal and maxDepth.

        Time: O(n);
        Space: O(h);
    */
    private int ansVal = 0;
    private int maxDepth = 0;
    
    private void setAnsVal(TreeNode root, int nowDepth) {
        if(root == null) {
            return;
        }
        
        if(nowDepth > maxDepth) {
            ansVal = root.val;
            maxDepth = nowDepth;
        }
        
        setAnsVal(root.left, nowDepth + 1);
        setAnsVal(root.right, nowDepth + 1);
    }
    
    public int findBottomLeftValue(TreeNode root) {
        
        //define the currentLevel, and make a call to set the ansVal;
        int nowDepth = 1;
        setAnsVal(root, nowDepth);
        
        //return ansVal;
        return ansVal;
    }
    /****************************************************************************************** */







    /*Using return type(2-int Userdefined dataStructure), instead of making global variable. 
        Object -- (int-Val, int-depth)
        Way: --->LeftAns and RightAns will define answer of current level.
             --->currAns will be one with maxDepth.
             --->If depth is same answer will be leftAns.

        Time: O(n);
        Space: O(h);
    */
    private class pair {
        int val;
        int depth;
        
        pair(int v, int d) {
            this.val = v;
            this.depth = d;
        }
    }
    
    
    private pair getLeftBottomVal(TreeNode root, int nowDepth) {
        if(root == null) {           //if null, then pass non-considrable dummy value; (will occur only if we reach null from a non-leaf parent)
            return new pair(0, -1);
        }
        else if(root.left == null && root.right == null) {    //if it is a leaf node, return this with it's depth.
            return new pair(root.val, nowDepth);
        }
        
        
        pair leftAns = getLeftBottomVal(root.left, nowDepth + 1);
        pair rightAns = getLeftBottomVal(root.right, nowDepth + 1);
        
        pair currAns = null;
        
        if(leftAns.depth >= rightAns.depth) {              //if leftDepth is greaterThanEqual to rightDepth, "leftAns" is our answer.
            currAns = leftAns;    
        }
        else {                                      //else is "rightAns".
            currAns = rightAns;
        }
        
        return currAns;
    }
    
    
    public int findBottomLeftValue(TreeNode root) {
        
        //define the currentLevel, and make a call to set the ansVal;
        int nowDepth = 1;
        pair ans = getLeftBottomVal(root, nowDepth);
        
        //return ansVal;
        return ans.val;
    }
    /****************************************************************************************** */

}
