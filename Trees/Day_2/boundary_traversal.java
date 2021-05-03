/*Find the anticlockwise boundary of the tree.

    Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

        1. Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you 
            always travel preferring the left subtree over the right subtree. 
        2.Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
        3. Reverse right boundary nodes: defined as the path from the right-most node to the root. 
            The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
        
        
        
    Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 


    Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \ 
       10   14 

    Output: 20 8 4 10 14 25 22

*/


public class boundary_traversal {
    

    /*Firstly get root, then LeftBoundary(without leafs of root.left), then leafs (of root.left, root.right), lastly rightBoundary(without leafs of root.right)

        Time: O(h + n + h); {getLeft + getLeaf + getRight}
        Space: O(1);
    */
    static void getLeftBoundary(Node root, ArrayList<Integer> boundaryList) {
        //if this is leaf node go back
        if(root.left == null && root.right == null) {
            return;
        }
        
        boundaryList.add(root.data);
        
        //if left exist go left, unless go right
        if(root.left != null) {
            getLeftBoundary(root.left, boundaryList);
        }
        else {      //when root.right != null;
            getLeftBoundary(root.right, boundaryList);
        }
    }
    
    
    static void getLeafBoundary(Node root, ArrayList<Integer> boundaryList) {
        if(root == null) {
            return;
        }
        else if(root.left == null && root.right == null) {
            boundaryList.add(root.data);
            return;
        }
        
        getLeafBoundary(root.left, boundaryList);;
        getLeafBoundary(root.right, boundaryList);
    }
    
    
    static void getRightBoundary(Node root, ArrayList<Integer> boundaryList) {
        //if this is leaf node, go back
        if(root.left == null && root.right == null) {
            return;
        }
        
        if(root.right != null) {
            getRightBoundary(root.right, boundaryList);
        }
        else {    //when root.left != null;
            getRightBoundary(root.left, boundaryList);
        }
        
        boundaryList.add(root.data);
    }
    

	ArrayList <Integer> printBoundary(Node root) {
	    ArrayList<Integer> boundaryList = new ArrayList<>();
	    
	    if(root == null) {
	        return boundaryList;
	    }
	    
	    //add the root first
	    boundaryList.add(root.data);
	    
	    //fill the left boundary, if leftNode exists.
	    if(root.left != null)
	        getLeftBoundary(root.left, boundaryList);
	    
	    //fill the leaf nodes,
	    getLeafBoundary(root.left, boundaryList);
	    getLeafBoundary(root.right, boundaryList);
	    
	    //fill the right-Boundary {in post-order}
	    if(root.right != null)
	        getRightBoundary(root.right, boundaryList);
	    
	    
	    //return the list
	    return boundaryList;
	}
    /******************************************************************************** */
}
