/*Valid Parantheis.

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    Input: s = "()[]{}"
    Output: true

*/
import java.util.*;
public class valid_paranthesis {
    
    /*Using Stack.
        Time: O(n);
        Space: O(n);
    */
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            }
            else {
                if(st.size() == 0) {
                    return false;
                }
                else {
                    if(ch == ')') {
                        if(st.peek() == '(') {
                            st.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else if(ch == '}') {
                        if(st.peek() == '{') {
                            st.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else {       //when it is "]"
                        if(st.peek() == '[') {
                            st.pop();
                        }
                        else {
                            return false;                            
                        }
                    }    
                }
                
            }
        }
        
        
        if(st.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /******************************************************************************** */
}
