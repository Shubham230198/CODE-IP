/*MinCost Binary Tree

    Given an array arr of positive integers, consider all binary trees such that:
        1.Each node has either 0 or 2 children;
        2.The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  
        (Recall that a node is a leaf if and only if it has 0 children.)
        3.The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
    
    Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.

    Input: arr = [6,2,4]
    Output: 32
    Explanation:
    There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

        24            24
       /  \          /  \
      12   4        6    8
     /  \               / \
    6    2             2   4

*/


public class minCost_SubTree {
    

    /*Using NextGreaterLeft and NextGreaterRight elements to destroy effect of current val.
        Time: O(3*n);
        Space: O(2*n)
    */
    public static int[] getLeftGreater(int[] arr) {
        int[] leftGreater = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = arr.length - 1; i >= 0; i--) {
            
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                leftGreater[st.pop()] = arr[i];
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            leftGreater[st.pop()] = Integer.MAX_VALUE;
        }
        
        return leftGreater;
    }
    
    public static int[] getRightGreater(int[] arr) {
        int[] rightGreater = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {      //very important to notice. {as one has to be left undestroyed, Here "<=" is replaced with "<"} && {but not in getLeftGreater function}
                rightGreater[st.pop()] = arr[i];
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            rightGreater[st.pop()] = Integer.MAX_VALUE;
        }
        
        return rightGreater;
    }
    
    public int mctFromLeafValues_1(int[] arr) {
        int[] leftGreater = getLeftGreater(arr);
        int[] rightGreater = getRightGreater(arr);
        int cost = 0;
        
        
        for(int i = 0; i < arr.length; i++) {
            int fact1 = leftGreater[i];
            int fact2 = rightGreater[i];
            
            //no need to process the single largest element in the arr. {it's leftMax & rightMax will both be +Infinity} 
            if(fact1 != Integer.MAX_VALUE || fact2 != Integer.MAX_VALUE)
                cost += Math.min(fact1, fact2) * arr[i];

        }
        
        return cost;
    }
    /************************************************************************************************* */


    /*In a single traversal, without space. {same above approach}
        Time: O(n);
        Space: O(1);
    */
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int cost = 0;
        
        
        for(int i = 0; i <= arr.length; i++) {
            int val = (i == arr.length ? Integer.MAX_VALUE : arr[i]);
            
            while(!st.isEmpty() && st.peek() <= val) {
                int var = st.pop();
                
                int fact1 = val;
                int fact2 = (st.isEmpty() ? Integer.MAX_VALUE : st.peek());
                
                //no need to process the single largest element in the arr. {it's leftMax & rightMax will both be +Infinity} 
                if(fact1 != Integer.MAX_VALUE || fact2 != Integer.MAX_VALUE)
                    cost += Math.min(fact1, fact2) * var;
            }
            
            st.push(val);
        }
        
        return cost;
    }
    /****************************************************************************************** */
}
