public class postOrderTraversal {
    

    /*Recursive Approach.
        Time: O(n);
        Space: O(n);
    */




    /*Stack-Status based approach.
        Time: O(n);
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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 0));
        
        while(!st.isEmpty()) {
            pair rem = st.peek();
            
            if(rem.node == null) {
                st.pop();
                continue;
            }
            
            if(rem.status == 0) {
                rem.status = 1;
                st.push(new pair(rem.node.left, 0));
            }
            else if(rem.status == 1) {
                rem.status = 2;
                st.push(new pair(rem.node.right, 0));
            }
            else {         //status is 2.
                postOrder.add(rem.node.val);
                st.pop();
            }
        }
        
        return postOrder;
    }
    /*************************************************************************************** */
}
