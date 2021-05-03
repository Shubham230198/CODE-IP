/*Return inOrder of a binary tree.

    Given the root of a binary tree, return the inorder traversal of its nodes' values.
*/


public class inOrderTraversal {
    
    /*Recursive approach
        Time: O(n);
        Space: O(n);
    */





    /*Iterative Stack-status based approach.
        Time: O(3*n);
        Space: O(n)
    */
    static class pair {
        TreeNode node;
        int status;
        
        pair(TreeNode node, int status) {
            this.node = node;
            this.status = status;
        }
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 0));
        
        while(!st.isEmpty()) {
            pair rem = st.peek();
            
            //if any null node is being added, we dont need to process it. {just pop() and continue}
            if(rem.node == null) {
                st.pop();
                continue;
            }
            
            //if status is 0, it is preWork.
            if(rem.status == 0) {
                rem.status = 1;
                st.add(new pair(rem.node.left, 0));
            }   
            else if(rem.status == 1) {      //if status is 1, we are in InWork.
                inOrderList.add(rem.node.val);
                
                rem.status = 2;
                st.add(new pair(rem.node.right, 0));
            }                               
            else if(rem.status == 2) {      //if status is 2, we are in PostWork.
                st.pop();
            }
            
        }
        
        return inOrderList;
    }
    /************************************************************************* */







    /* Moris traversal
        Time: O(n);
        Space: O(1);
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inList = new ArrayList<>();
        
        if(root == null) {
            return inList;
        }
        
        
        TreeNode current = root;
        while(current != null) {
            
            if(current.left == null) {
                inList.add(current.val);
                current = current.right;
            }
            else {
                
                TreeNode predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                
                if(predecessor.right == null) {   //if the predecessor.right is null ---> {the left nodes of current aren't processed  till now, so go to leftNodes of current}
                    predecessor.right = current;
                    current = current.left;
                }
                else  {                          //if the predecessor.right is current ---> {all left nodes of current are already processed, we are comming here second time}
                    predecessor.right = null;
                    
                    inList.add(current.val);
                    current = current.right;
                }
             }
        }
        
        return inList;
        
    }

    /******************************************************************************************************************************** */

}
