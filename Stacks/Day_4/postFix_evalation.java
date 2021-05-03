/*Evaluation of Postfix Expression

    Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. 
    Operators will only include the basic arithmetic operators like *, /, + and -.

    Input: S = "231*+9-"
    Output: -4
    Explanation:
    After solving the given expression, 
    we have -4 as result.

*/

//Note: Postfix to Prefix Conversion and Infix conversion will be similar to this code.


public class postFix_evalation {

    /*Traversing from left to right
        Time: O(n);
        Space: O(n);
    */
    public static int evaluatePostFix(String S) {
        Stack<Integer> valueSt = new Stack<>();
        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(Character.isDigit(ch)) {
                valueSt.push(ch - '0');
            }
            else {
                int val2 = valueSt.pop();
                int val1 = valueSt.pop();
                
                int finalVal = calculate(val1, val2, ch);
                valueSt.add(finalVal);
            }
        }
        
        return valueSt.pop();
    }
    /************************************************************************** */
}
