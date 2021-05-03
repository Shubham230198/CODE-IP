/*Backspace containing string matching.

    Given two strings s and t, return true if they are equal when both are typed into empty text editors. 
    '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.

    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".
*/


public class backspace_matching {
    
    /*Using 2-Stacks
        Time:O(n + m)
        Space: O(n + m)
    */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '#') {
                if(st1.size() > 0)
                    st1.pop();
            }
            else {
                st1.push(ch);
            }
        }    
        
        Stack<Character> st2 = new Stack<>();
        for(char ch: t.toCharArray()) {
            if(ch == '#') {
                if(st2.size() > 0)
                    st2.pop();
            }
            else {
                st2.push(ch);
            }
        }
        
        //matching the remaining characters inside of stacks.
        while(!st1.isEmpty() && !st2.isEmpty()) {
            if(st1.pop() != st2.pop()) {
                return false;
            }
        }
        
        //if both become empty at same time --> then true, else false;
        if(st1.isEmpty() && st2.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
        
    }
    /*********************************************************************************************** */





    /*Pointers based ----> {without the use of stacks}
        Time: O(n + m);
        Space: O(1);
    */
    public boolean backspaceCompare_1(String s, String t) {
        int ptr1 = s.length() - 1;
        int ptr2 = t.length() - 1;
        
        int skipS = 0;
        int skipT = 0;
        
        while(ptr1 >= 0 || ptr2 >= 0) {
            
            while(ptr1 >= 0) {
                if(s.charAt(ptr1) == '#') {
                    skipS++;
                }
                else if(skipS > 0) {
                    skipS--;
                }
                else {
                    break;
                }
                
                ptr1--;
            }
            
            
            while(ptr2 >= 0) {
                if(t.charAt(ptr2) == '#') {
                    skipT++;
                }
                else if(skipT > 0) {
                    skipT--;
                }    
                else {
                    break;
                }   
                   
                ptr2--;
            }
            
            //if both "S" or "T" are completed, return true;
            if(ptr1 < 0 && ptr2 < 0) {
                return true;
            }
            else if(ptr1 < 0 || ptr2 < 0) {   //if exactly one of the "S" or "T" are completed, becomes negative ---> {can't be equal}
                return false;
            }
            else {   //if none of "S" or "T" are completed ---> Check for characters.

                if(s.charAt(ptr1) == t.charAt(ptr2)) {       
                    //do nothing, just move the pointers
                    ptr1--;
                    ptr2--;
                }
                else {             //if characters does not matches.
                    return false;
                }
            }
            
        }
        
       return true;      //both "S" and "R" gets completed without returning false;  {ptr1 and ptr2 just become negative at the same time}
    }
    /************************************************************************************************ */

}
