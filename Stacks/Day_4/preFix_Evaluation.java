/*Evaluating the final value of PreFix expression.

//Note:- preFix to PostFix conversion and InFix conversion will be similar.

   For Input:
    /*2+319
    your output is: 
    0
*/

public class preFix_Evaluation {

    /*Using a Stack, {travesing from back}
        Time: O(n);
        Space: O(n);
    */
    public static int evaluatePostFix(String S) {
        Stack<Integer> valueSt = new Stack<>();
        
        for(int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            
            if(Character.isDigit(ch)) {
                valueSt.push(ch - '0');
            }
            else {
                int val1 = valueSt.pop();           //poping order is changed here, due to reverse traversal.
                int val2 = valueSt.pop();
                
                int finalVal = calculate(val1, val2, ch);
                valueSt.add(finalVal);
            }
        }
        
        return valueSt.pop();
    }
    /**************************************************************************************** */
}
