/*Binary Tree Reverse-Level Order Traversal 

    Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

    Input: root = [3,9,20,null,null,15,7]
    Output: [[15,7],[9,20],[3]]
*/

public class reverseLevelOrder {


    /*Using BFS, adding elements in queue with reverseOrder(first right then left), later reverse the orderList.

        Time: O(n + n/2)  {DFS + reversing}
        Space: O(w);

        Note: This will not give the reverse-Levels into seperate lists. (Or do not print in seprate lines)
    */
    public ArrayList<Integer> reverseLevelOrder_1(Node root) {
        ArrayList<Integer> orderList = new ArrayList<>();
        
        if(root == null) {
            return orderList;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            Node remNode = q.poll();
            orderList.add(remNode.data);
            
            
            //addChildren if not null. {first right child and then left child}
            if(remNode.right != null) q.add(remNode.right);
            if(remNode.left != null) q.add(remNode.left);
        }
        
        
        
        //reverse the list
        int n = orderList.size();
        for(int i = 0; i < n/2; i++) {
            int val1 = orderList.get(i);
            int val2 = orderList.get(n - i - 1);
            
            orderList.set(i, val2);
            orderList.set(n - i - 1, val1);
        }
        
        return orderList;
    }
    /**************************************************************************************** */










    /*BFS(LevelOrder) {firstly collect all levels into List-of-lists, then reverse this list-of-lists}
        Time: O(n);
        Space: O(w);

        Note: to get the reverse-levels, with each level into a list. {can be used to print the reverseLevel with each level in different line}
    */
    public List<List<Integer>> levelOrderBottom_2(TreeNode root) {
        List<List<Integer>> reverseLevelOrder = new ArrayList<>();
        
        if(root == null) {
            return reverseLevelOrder;
        }
        
        //firstly collect the levels in the reverseLeveOrder list
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            
            while(size-- != 0) {
                TreeNode remNode = q.poll();
                
                //work
                thisLevel.add(remNode.val);
                
                //add children if not null
                if(remNode.left != null) q.add(remNode.left);
                if(remNode.right != null) q.add(remNode.right);
            }
            
            reverseLevelOrder.add(thisLevel);
        }
        
        
        //reverse the reverseLevelOrder
        int left = 0;
        int right = reverseLevelOrder.size() - 1;
        while(left < right) {
            List<Integer> temp = reverseLevelOrder.get(left);
            reverseLevelOrder.set(left, reverseLevelOrder.get(right));
            reverseLevelOrder.set(right, temp);
            
            left++;
            right--;
        }
        
        
        //return our answer
        return reverseLevelOrder;
    }
    /***************************************************************************************** */

}
