/*Count Reversals to balanced the paranthesis string.

    Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals 
    required to convert the string into a balanced expression.

    Input:
    S = "}{{}}{{{"
    Output: 3
    Explanation: One way to balance is:
    "{{{}}{}}". There is no balanced sequence
    that can be formed in lesser reversals.
*/

import java.util.*;
public class countReversal {    

    /*
        Time: O(n);
        Space: O(n);
    */
    public static int countRev(String S) {
        
        //not possible to balance if the length is odd.
        if(S.length() % 2 != 0) {
            return -1;
        }
        
        //removing the balanced part ---> {This will lead to "}}}}....{{{{" }
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(ch == '}' && !st.isEmpty()) {
                
                if(st.peek() == '{') {
                    st.pop();
                }
                else {
                    st.push(ch);
                }
            }
            else {
                st.push(ch);
            }
        }
        
        //counting the unwanted opening and unwanted closing brackets.
        int openCount = 0;
        while(!st.isEmpty() && st.peek() == '{') {
            openCount++;
            st.pop();
        }
        
        int closeCount = st.size();
        
        //half the openCount and loseCount.        
        int half_open_ceil = (openCount + 1) / 2;
        int half_close_ceil = (closeCount + 1) / 2;
        
        return half_open_ceil + half_close_ceil;
    }
    /********************************************************************************************* */





    /*Using 2-Variables to calculate excess opening and closing brackets.
        Time: O(n);
        Space: O(1);
    */
    static int countRev_2(String S) {
        
        if(S.length() % 2 != 0) {
            return -1;
        }
        
        int openCount = 0;
        int closeCount = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(ch == '{') {
                openCount++;
            }
            else {
                if(openCount > 0) {
                    openCount--;
                }
                else {
                    closeCount++;
                }
            }
        }
        
        
        int half_open_ceil = (openCount + 1) / 2;
        int half_close_ceil = (closeCount + 1) / 2;
        
        return half_open_ceil + half_close_ceil;
    }
    /********************************************************************** */

}
