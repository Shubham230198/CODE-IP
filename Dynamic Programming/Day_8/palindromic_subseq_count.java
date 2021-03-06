/* COUNT OF PALINDROMIC SUBSTRINGS
    Given a string, your task is to count how many palindromic substrings in this string.

    The substrings with different start indexes or end indexes are counted as different
    substrings even they consist of same characters.

    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".
*/

public class palindromic_subseq_count {

    /*Diagonal filling boolean DP. 
        Time: O(n^2);
        Space: O(n^2)

    */
    public int countSubstrings(String s) {
        //for counting total number of trues in the dp array.
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int gap = 0; gap < dp[0].length; gap++) {
            for(int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                
                if(gap == 0) {       //all length 1 substrings are palindromic in nature.
                    dp[i][j] = true;
                }
                else if(gap == 1) {     //for 2 length substrings-> check for i'th and j'th character is same or not.
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {   //else check i'th and j'th similarity, along with palindromic nature of (i + 1) <---> (j - 1) substring.
                    if((s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] == true)) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                
                //if the current substring (i) <----> (j) is palindromic, increase the count.
                if(dp[i][j] == true) {  
                    count++;
                }
            }
        }
        
        return count;
    }

    /**************************************************************************************** */


    /*Try making all the characters of given string, as center points of palindromic substring.
        Time: O(n^2)
        Space: O(1)

    */
    public int countSubstrings_allCenterPoints(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            //even length palindromic substrings, with mid elements as s.charAt(i - 1) and s.charAt(i);
            int low = i - 1;
            int high = i;
            while((low >= 0 && high < s.length()) && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                count++;
            }
            
            //odd length palindromic substrings, with mid element as s.charAt(i);
            low = i - 1;
            high = i + 1;
            count++;     //counting the single length palindromic substring, {s.charAt(i) only}
            
            while((low >= 0 && high < s.length()) && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                count++;
            }
        }
        
        return count;
    }

    /*********************************************************************************************** */


}
