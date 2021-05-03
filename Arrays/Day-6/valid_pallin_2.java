/*Valid Palindromic String - II

    Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
*/

public class valid_pallin_2 {
    
    /*Using a helper function (exactly same to judge plindrome), whenever we find first mis-match.
        Time: O(n);
        Space: O(1);
    */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {      //if find the mismatch, we will call helper function, with specific indexes.
                boolean firstCase = helper(s, left, right - 1);
                boolean secondCase = helper(s, left + 1, right);
                
                return firstCase || secondCase;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    //helping function to check if specific substring is pallindrome.
    public boolean helper(String s, int left, int right) {
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    /************************************************************************************* */




    /*Generic function to allow at max "diff" number of operation, to make string palindromic. 

        Time: O(n);
        Space: O(1);
    */
    public boolean validPalindrome_2(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        return helper(s, left, right, 1);
    }
    
    
    public boolean helper(String s, int left, int right, int diff) {
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {       //whenever the lChar and rChar does not matches, ---> decrease the diff, and make appropiate calls.
                diff--;

                if(diff < 0) 
                    return false;

                boolean firstCase = helper(s, left + 1, right, diff);
                boolean secondCase = helper(s, left, right - 1, diff);

                return firstCase || secondCase;
            }
            
            left++;
            right--;
    
        }
        
        
        return true;    
    }
    /******************************************************************************** */
}
