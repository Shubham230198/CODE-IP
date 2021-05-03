/*Find if given tree is a subtree of another tree or not.

    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure 
    and node values of subRoot and false otherwise.

    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    Output: true
*/


public class subTree_of_anotherTree {
    

    /*BruteForce way,
        Time: O(n*m)  {product of the size of two trees}
        Space: O(1);
    */
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        else if(root1 == null || root2 == null) {
            return false;
        }
        
        
        if(root1.val != root2.val) {
            return false;
        }
        
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        else if(root == null || subRoot == null) {
            return false;
        }
    
        
        if(root.val == subRoot.val) {
            boolean flag = isSameTree(root, subRoot);
            if(flag == true) {
                return true;
            }
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /******************************************************************************* */





    /*Using PreOrder, and KMP subarray matching.
        Time: O(n + m); {sum of size of both trees}
        Space: O(n + m);
    */
    public static void getPreOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            list.add(Integer.MAX_VALUE);
            return;
        }
        
        list.add(root.val);
        
        getPreOrder(root.left, list);
        getPreOrder(root.right, list);
    }
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        ArrayList<Integer> treeList = new ArrayList<>();
        getPreOrder(t, treeList);
        int firstTreeSize = treeList.size();
        
        treeList.add(Integer.MIN_VALUE);
        
        int secondTreeIdx = treeList.size();
        getPreOrder(s, treeList);
    
        
        //get the lps of treeList;
        int[] lps = new int[treeList.size()];
        lps[0] = 0;
        
        int i = 1; 
        int len = 0;
        
        while(i < lps.length) {
            if(treeList.get(i).equals(treeList.get(len)) == true) {
                len++;
                lps[i] = len;
                
                i++;
            }
            else {
                if(len > 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        
        for(i = secondTreeIdx; i < treeList.size(); i++) {
            if(lps[i] == firstTreeSize) {
                return true;
            }
        }
        
        return false;
        
    }
    /***************************************************************************************** */
}
