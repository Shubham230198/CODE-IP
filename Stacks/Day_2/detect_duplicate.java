/*Detect if the expresstion contains duplicate paranthesis.

    Given a balanced expression, find if it contains duplicate parenthesis or not. A set of parenthesis are duplicate if the 
    same subexpression is surrounded by multiple parenthesis.

    (((a+(b)))+(c+d))
    The subexpression "a+(b)" is surrounded by two 
    pairs of brackets.

*/
import java.util.*;
public class detect_duplicate {

    /*Using Stack.
        Time: O(n);
        Stack: O(n);
    */
    public static boolean detectDuplicate(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int countExtraChar = 0;

                //as the exression was balanced, (for every ")" there will be a "(" present in stack)
                while(st.peek() != '(') {   
                    st.pop();
                    countExtraChar++;
                }

                st.pop();   //removing the respective "(" bracket.

                if(countExtraChar == 0) {
                    return true;
                }
            }
            else {
                st.push(ch);
            }
        }

        return true;
    }
    /*************************************************************************************************** */






    /* To calculate the count of duplicate brackets.
        Time: O(n);
        Space: O(n);
    */
    public static int countDuplicate(String str) {
        int count = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int countExtraChar = 0;

                //as the exression was balanced, (for every ")" there will be a "(" present in stack)
                while(st.peek() != '(') {   
                    st.pop();
                    countExtraChar++;
                }

                st.pop();   //removing the respective "(" bracket.

                if(countExtraChar == 0) {
                    count++;
                }
            }
            else {
                st.push(ch);
            }
        }

        return count;
    }
    /******************************************************************************************** */

}
