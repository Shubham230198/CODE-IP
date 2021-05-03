/*Mininum Add of Brackets to Balance the paranthesis string.

    Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) 
    so that the resulting parentheses string is valid.

    Input: "()))(("
    Output: 4
*/

import java.util.*;
public class minAdd_toBalance {
    
    
    /*Using Stack   ----> {Answer is the sum of count of excess-closing-brackets and excess-opening-brackets}
        Time: O(n);
        Space: O(n);

    */
    public int minAddToMakeValid_1(String S) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(st.size() != 0 && ch == ')') {
                if(st.peek() == '(') {
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
        
        return st.size();
    }
    /********************************************************************* */




    /*Using variables to count excess closing brackets and opening brackets.
        Time: O(n);
        Space: O(1);
    */
    public int minAddToMakeValid(String S) {
        int ans = 0;
        if(S == null || S.length() == 0) return ans;
        
        
        return helper(S);
    }
    
    private int helper(String S) {        
        int close = 0, open = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                open ++;
            } else {
                if(open == 0) close++;
                else open--;
            }
        }
        return close + open;
    }

    /************************************************************************ */
}
