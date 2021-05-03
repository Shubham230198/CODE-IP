/*Next Greater Element to Right in Cyclic Manner.
    
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
    return the next greater number for every element in nums.

    If it doesn't exist, return -1 for this number.

    Input: nums = [1,2,3,4,3]
    Output: [2,3,4,-1,4]
*/

public class nextGreater_Right_Cycle {
    

    /*
        Time: O(n + n + n);  {pushes + pops + last-traversal};
        Space: O(n);
    */
    public int[] nextGreaterElements(int[] nums) {
        int[] nxtGrtrRight = new int[nums.length];
        
        Stack<Integer> st = new Stack();
        for(int i = 0; i < nums.length; i++) {
            
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                nxtGrtrRight[st.pop()] = nums[i];
            }
            
            st.push(i);
        }

        //doing nextCycle, {but this time no any element will be pushed into the stack}
        for(int i = 0; i < nums.length; i++) {
            
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                nxtGrtrRight[st.pop()] = nums[i];
            }
        }
        
        //setting the largest element(s) of the array --> -1. {we will never encounter nextGreater, even in cycle.}
        while(!st.isEmpty()) {
            nxtGrtrRight[st.pop()] = -1;
        }
        
        return nxtGrtrRight;
    }
    /******************************************************************** */

}
