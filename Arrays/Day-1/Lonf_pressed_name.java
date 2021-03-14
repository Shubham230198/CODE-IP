/*LONG PRESSED KEY
    Your friend is typing his name into a keyboard. Sometimes, when typing a character c, 
    the key might get long pressed, and the character will be typed 1 or more times.

    Input: name = "alex", typed = "aaleex"
    Output: true
    Explanation: 'a' and 'e' in 'alex' were long pressed.
*/

public class Lonf_pressed_name {
    
    /* 2-pointers from starting.
        Time: O( Max(str1.len, str2len));
        Space: O(1);
    */
    public boolean isLongPressedName(String name, String typed) {
        //if first charater doesn't matches => always false;
        if(name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        
        
        int i = 0;
        int j = 0;
        
        //till the name string exists.
        while(i < name.length() && j < typed.length()) {
            
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            else {   //if "i"th char does not matches "j"th.
                
                //below condition could raise exception, if we haven't checked first character.
                if(typed.charAt(j - 1) == typed.charAt(j)) {
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        
        
        //if name string is still remaining.
        while(i < name.length()) {
            return false;
        }
        
        
        //if typed string is still remaining.
        while(j < typed.length()) {
            
            if(typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        
        
        return true;
    }
}
