/*Check if a string is rotated string, of another string.

    We are given two strings, A and B. Return True if and only if A can become B after some number of shifts on A.

    Example 1:
    Input: A = 'abcde', B = 'cdeab'
    Output: true

    Example 2:
    Input: A = 'abcde', B = 'abced'
    Output: false


*/


public class isRotated_string {
    

    /*Applying KMP algorithm. {after cocatenation of a string to itself}
        Time: O(A + B);
        Space: O(A + B);
    */
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) {
            return false;
        }
        
        StringBuilder text = new StringBuilder(A);
        text.append(A);
        
        StringBuilder pattern = new StringBuilder(B);
        
        StringBuilder str = new StringBuilder();
        str.append(pattern);
        
        int secondStartIdx = str.length();
        
        str.append('#');
        str.append(text);
        
        
        
        int[] lps = new int[str.length()];
        lps[0] = 0;
        
        int i = 1, len = 0;
        
        while(i < lps.length) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len > 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        for(i = secondStartIdx; i < lps.length; i++) {
            if(lps[i] == pattern.length()) {
                return true;
            }
        }
        
        return false;
    }
    /******************************************************************************** */
}
