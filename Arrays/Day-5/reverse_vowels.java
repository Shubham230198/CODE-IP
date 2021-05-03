/*Reverse vowels in a string.

    Write a function that takes a string as input and reverse only the vowels of a string.
    Input: "leetcode"
    Output: "leotcede"
*/

public class reverse_vowels {
    
    /* Simple 2-pointers Approach
        Time: O(s.length());
        Space: O(s.length());
    */
    public String reverseVowels(String s) {
        char[] strArr = s.toCharArray();
        int n = strArr.length;
        
        int left = 0;
        int right = n - 1;
        while(left < right) {
            
            if(isVowel(strArr[left]) == true && isVowel(strArr[right]) == true) {
                char temp = strArr[left];
                strArr[left] = strArr[right];
                strArr[right] = temp;

                left++;
                right--;
            }
            else if(isVowel(strArr[left]) == true) {
                right--;
            } 
            else if(isVowel(strArr[right]) == true) {
                left++;
            }
            else {
                right--;
                left++;
            }
            
        }

        return String.valueOf(strArr);
    }
    /******************************************************************************** */
}
