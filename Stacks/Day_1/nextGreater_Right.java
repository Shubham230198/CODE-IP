/*  Find Next Greater-Element-to-Right for every element in the Array.

    Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each 
    element of the array in order of their appearance in the array.

    If there does not exist next greater of current element, then next greater element for current element is -1.

    Input: 
    N = 4, arr[] = [1 3 2 4]
    Output:
    3 4 4 -1
*/


public class nextGreater_Right {

    /*For Finding Next Right   ---> {Left ---> Right Traversal Technique}

        Time: O(n + n);   {for inserting the elements into stacks, and removing them}
        Space: O(n);
    */
    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] nextGR = new long[arr.length];
        
        Stack<Integer> st = new Stack();
        for(int i = 0; i < arr.length; i++) {
            
            //while the comming element, is greater than st.peek() element --> update the next-Greater of st.peek() element, & remove it.
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGR[st.pop()] = arr[i];
            }

            //then push the comming element into the stack
            st.push(i);
        }
        
        while(!st.empty()) {
            nextGR[st.pop()] = -1;
        }
        
        return nextGR;
    }
    /******************************************************************* */
}
