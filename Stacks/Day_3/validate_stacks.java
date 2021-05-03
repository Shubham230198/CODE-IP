/*Validate Stacks:

    Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result 
    of a sequence of push and pop operations on an initially empty stack.

    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    Output: true
    Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
*/


public class validate_stacks {


    /*Keeping the priority to pop, as much as possible.
        Time: O(n + n);
        Space: O(n);
    */
    public boolean validateStackSequences_1(int[] pushed, int[] popped) {
        
        Stack<Integer> st = new Stack<>();
        int popIdx = 0;           //for keeping track of popped elements.
        
        for(int x: pushed) {
            st.push(x);
            
            while(!st.isEmpty() && st.peek() == popped[popIdx]) {      //pop the elements from the stack, untill top element matches with the popIdx Element.
                st.pop();
                popIdx++;
            }
        }
        
        if(popIdx == popped.length) {                  //if popIdx reaches end of the popped array ---> {stack operation is validated}
            return true;
        }
        else {
            return false;
        }
        
    }
    /********************************************************************************** */




    
    /* Without using any Stack.
        Time: O(n + n);
        Space: O(1)
    */
    public boolean validateStackSequences_2(int[] pushed, int[] popped) {
        
        int len = pushed.length, i = 0, j = 0, s = 0;
        while (i < len) {
            if (s >= 0 && popped[j] == pushed[s]) {
                j++;
                s--;
            } else {
                s++;
                i++;
                if (i < len) pushed[s] = pushed[i];
            }
        }

        return s == 0;
         
     }
     /*********************************************************************** */


}

