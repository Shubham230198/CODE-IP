/*Longest Valid Brackets String

    Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
    NOTE: Length of smallest the valid substring ( ) is 2.

    Input: S = "()(())("
    Output: 6
    Explanation: The longest valid 
    substring is "()(())". Length = 6.
*/

import java.util.*;

public class longest_validBrackets {
    
    
    /*Stack with Indexes.
        Time: O(n);
        Space: O(n);
    */
    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        int maxLen = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(ch == ')' && st.size() > 1 && S.charAt(st.peek()) == '(' ) {
                st.pop();
                maxLen = Math.max(maxLen, i - st.peek());
                continue;
            }
            
            st.push(i);
            
        }
        
        return maxLen;
     }
     /*************************************************************************** */
}
