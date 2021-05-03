/*Length of Longest valid parenthesis string.

    Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.

    Input: S = "()(())("
    Output: 6
    Explanation: The longest valid 
    substring is "()(())". Length = 6.
*/


import java.util.*;
public class longestValidSubstring {
 
    /*Using a Stack ---> {after every sucessesful pattern match (i.e. after pop() of opening bracket), the nowLen is (current_idx - stack.peek()_element_idx) }
        Time: O(n);
        Space: O(n)
    */
    static int findMaxLen(String S) {
        
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(ch == ')' && !st.isEmpty()) {
                
                if(S.charAt(st.peek()) == '(') {
                    st.pop();
                    
                    int lIdx = !st.isEmpty() ? st.peek() : -1;
                    int nowLen = i - lIdx;
                    
                    maxLen = Math.max(maxLen, nowLen);
                } 
                else {
                    st.push(i);
                }
            }
            else {
                st.push(i);
            }
        }
        
        return maxLen;
    }
    /******************************************************************* */






    /*

    */
    

}
