/*Return preOrder of a binary tree.

    Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/

public class preOrderTraversal {

    /*Recursive Approach
        Time: O(n);
        Space: O(n);
    */




    /*Stack-status based Iterative approach.
        Time:O(3*n)
        Space: O(n);
    */
    public static class pair {
        TreeNode node;
        int status;
        
        pair(TreeNode node, int status) {
            this.node = node;
            this.status = status;
        }
    }
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 0));
        
        while(!st.isEmpty()) {
            pair rem = st.peek();
            
            if(rem.node == null) {
                st.pop();
                continue;
            }
            
            if(rem.status == 0) {
                preOrderList.add(rem.node.val);
                
                rem.status = 1;
                st.push(new pair(rem.node.left, 0));
            }
            else if(rem.status == 1) {
                rem.status = 2;
                st.push(new pair(rem.node.right, 0));
            }
            else {              //when status is 2.
                st.pop();
            }
        }
        
        return preOrderList;
    }
    /******************************************************************************************* */








    /*Morris Traversals
        Time: O(n);
        Space: O(1);
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preList = new ArrayList<>();
        
        TreeNode current = root;
        while(current != null) {
            if(current.left == null) {
                
                preList.add(current.val);
                current = current.right;
            }
            else {
                
                TreeNode predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                
                if(predecessor.right == null) {    //"cuurent" node is acting as a current first time.
                    preList.add(current.val);
                    
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
            
        }
        
        return preList;
        
    }
    /************************************************************************************************************* */
}
