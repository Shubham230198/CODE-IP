/*Next Warmer day difference.

    Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days 
    you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

    TestInput = [73, 74, 75, 71, 69, 72, 76, 73], 
    Output = [1, 1, 4, 2, 1, 1, 0, 0].

*/

public class nextWarmerDay_Right {

    /*Exactly similar approach to that of next-greater-element-onRight.

        Time: O(n + n);
        Space: O(n);
    */
    public int[] dailyTemperatures(int[] T) {
        int[] nextWarmer = new int[T.length];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++) {
            
            while(!st.isEmpty() && T[st.peek()] < T[i]) {
                nextWarmer[st.peek()] = i - st.pop(); 
            }
            
            st.push(i);
        }
        
        //all other places (where we don't find nextWarmer days) --> they already contains 0.

    
        //return answer
        return nextWarmer;
    }
    /************************************************************************************************ */
}
