/*Remove Duplicate characters from string.

    Given a string s, remove duplicate letters so that every letter appears once and only once. 
    You must make sure your result is the smallest in lexicographical order among all possible results.

    Input: s = "cbacdcbc"
    Output: "acdb"
*/

public class remove_duplicate {

    /*Stack, freqArr, isInlcuded based approach.
        Time: O(n);
        Space: O(26 + 26 + n);
    */
    public String removeDuplicate(String s) {
        //the freqArray --> to check at any time, if present Character is occur later too. (so we can remove it resently)
        int[] freqArr = new int[26];
        for(char ch: s.toCharArray()) {
            freqArr[ch - 'a']++;
        }
        
        //to check if character is present in the stack.
        boolean[] isIncluded = new boolean[26];

        Stack<Character> st = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            //if this character is already present in the stack ---> (do nothing {think why})
            if(isIncluded[ch - 'a'] == false) {
                
                //remove the peek-char if it can occur later, and greater than "ch" char.
                while(!st.isEmpty() && (st.peek() > ch) && (freqArr[st.peek() - 'a'] > 0)) {

                    int rem = st.pop();
                    isIncluded[rem - 'a'] = false;

                }            
            
                st.add(ch);
                isIncluded[ch - 'a'] = true;    
            }
            
            freqArr[ch - 'a']--;
        }
        
        //get the content from the stack.
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        
        return str.reverse().toString();
    }

    /*************************************************************************************************** */
}
