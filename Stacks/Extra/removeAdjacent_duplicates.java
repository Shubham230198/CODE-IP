/* Remove All Adjacent Duplicates In String

    Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
    We repeatedly make duplicate removals on S until we no longer can.

    Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.


    Input: "abbaca"
    Output: "ca"
    Explanation: 
        For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
        The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

*/
public class removeAdjacent_duplicates {
    
    /*Using Stack
        Time: O(n);
        Space: O(n);
    */
    public String removeDuplicates(String str) {

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {

            if(!st.isEmpty() && st.peek() == str.charAt(i)) {
                st.pop();
            }
            else {
                st.push(str.charAt(i));
            }
        }


        StringBuilder sbr = new StringBuilder();
        while(!st.isEmpty()) {
            sbr.append(st.pop());
        }

        return sbr.reverse().toString();
    }
    /*********************************************************************************** */









    /*Using just StringBuilder, {same above approach}
        Time: O(n);
        Space: O(1);
    */
    public String removeDuplicates_2(String str) {
        StringBuilder sbr = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(sbr.length() > 0 && sbr.charAt(sbr.length() - 1) == ch) {
                sbr.deleteCharAt(sbr.length() - 1);
            }
            else {
                sbr.append(ch);
            }
        }
        
        return sbr.toString();
    }
    /******************************************************************************** */

}
