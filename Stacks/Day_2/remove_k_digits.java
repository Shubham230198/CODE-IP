/*Remove K Digits, to make it minimum.

    Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer 
    after removing k digits from num.

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*/
import java.util.*;
public class remove_k_digits {

    /*Using stack 
        Time: O(2*n);
        Space: O(n);
    */
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            
            //if the current char is less than st.peek() --> then just remove the st.peek() char. {make sure to check value of k > 0}
            while(!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }
            
            //if the current character is '0' and stack is empty --> then dont push it into stack, {this will become leading zeroes}
            if(ch == '0' && st.isEmpty() == true) {
                continue;
            }
            
            //else push
            st.push(ch);
            
        }
        
        //if all characters are pushed, still we have "k" remaining, start poping from top of stack.
        while(k != 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        //get the content of the stack into stringbuilder.
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        
        
        //if str is already empty --> just return "0" string.
        if(str.length() == 0) {
            return "0";
        }
        else { //else return reverse of the str.
            return str.reverse().toString();        
        }
    }

    /************************************************************************* */
}
