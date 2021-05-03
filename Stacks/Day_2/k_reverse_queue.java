/*Reverse the first K-elements from the Queue.

    Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, 
    leaving the other elements in the same relative order.

    Input:
    5 3
    1 2 3 4 5

    Output: 
    3 2 1 4 5
*/
import java.util.*;
public class k_reverse_queue {
    
    /*Using auxilary stack.   {using LIFO functionality}

        Time: O(n + k);
        Space: O(k);
    */
    public static void k_reverseQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();

        //getting fist-k elements of queue, into the stack.
        int idx = 0;
        while(idx < k) {
            st.push(q.poll());
            idx++;
        }

        //getting all those(k) elements from stack, into queue.
        while(!st.isEmpty()) {
            q.add(st.pop());
        }

        //remove the (len-k) elements from q, and add at last.
        for(int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }
    }
    /********************************************************************************** */
}
