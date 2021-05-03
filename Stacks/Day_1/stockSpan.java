/*Stocks Span Problem.

    The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, 
    for which the price of the stock on the current day is less than or equal to its price on the given day.

    For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
     then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

*/

import java.util.*;
public class stockSpan {

    /*Application of next-Greater on left
        Time: O(n);
        Space: O(n);
    */
    public static int[] calculateSpan(int price[], int n) {
        int[] spans = new int[n];
    
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            
            while(!st.isEmpty() && price[i] > price[st.peek()]) {
                spans[st.peek()] = st.pop() - i;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            spans[st.peek()] = st.pop() + 1;
        }
        
        return spans;
    }
    /*********************************************************************** */
}
