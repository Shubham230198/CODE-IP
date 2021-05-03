/*Populate the next Right Pointers.

    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Input: root = [1,2,3,4,5,6,7]
    Output: [1,#,2,3,#,4,5,6,7,#]
    Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer 
    to point to its next right node, just like in Figure B. The serialized output is in level order as connected 
    by the next pointers, with '#' signifying the end of each level.
*/

public class NextRightPointers {

    /*Queue LevelOrder based approach. {will work in all types of trees}
        Time: O(n);
        Space: O(n);
    */
    public Node connect(Node root) {
        if(root == null) {         //when root is null.
            return null;
        }
        
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- != 0) {
                Node remNode = q.poll();
                
                //set the next pointer, {if this is not the last node of this level.}
                if(size != 0) {
                    remNode.next = q.peek();
                }
                
                
                //add non-null childrens
                if(remNode.left != null) {
                    q.add(remNode.left);
                }
                
                if(remNode.right != null) {
                    q.add(remNode.right);
                }
                
            }
        }
        
        return root;
    }
    /******************************************************************************************* */


    //Note: Below approach will work only if the tree is "perfect-binary tree", not on other trees.
    /*Special Temp-based Appraoch, {temp will set child's next pointers, and traversing in level order}
        Time: O(n);
        Space: O(1);
    */
    public Node connect(Node root) {
        if(root == null) {         //when root is null.
            return null;
        }
        
        
        Node node = root;           //node pointer will be traversing to extreme left node only. {so node will traverse till non-leaf nodes}
        while(node.left != null) {
            
            //temp node will be used to set "next" of it's children, and then whole level-node's children.
            Node temp = node;
            while(temp != null) {
                temp.left.next = temp.right;
                
                if(temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                
                temp = temp.next;     //making temp to move in level-way.
            }
            
            node = node.left;
        }
                  
        return root;
    }
    /**************************************************************************************************************** */

}
