/*Longest Length of unbalanced string.

    We have to find the length of longest unbalanced string.
*/
import java.util.*;
public class longestUnbalanced {
    
    /*Checking if str is balanced ---> {then (length - 1)}, else {length};
        Time: O(n);
        Space: O(n);
    */
    public static int longest_Unbalanced(String str) {
        
        //checking if the str is balanced or not.
        Stack<Character> st = new Stack<>();
        boolean flag = true;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {

                while(!st.isEmpty() && st.peek() != ')') {
                    st.pop();
                }

                if(st.isEmpty() == true) {
                    flag = false;
                    break;
                }

                st.pop();
            }
            else {
                st.push(ch);
            }
        }

        if(!st.isEmpty()) {
            flag = false;
        }


        //if the str is balanced ---> {then answer is (length - 1)}, else ---> {answer is length}
        if(flag == true) {
            return str.length() - 1;
        }
        else {
            return str.length();
        }
    }
    /******************************************************************************************** */
}
