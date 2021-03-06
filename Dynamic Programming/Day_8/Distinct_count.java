/*DISTINCT SUBSEQUENCES
    Given two strings s and t, return the number of distinct subsequences of s which equals t.

    Input: s = "rabbbit", t = "rabbit"
    Output: 3
    Explanation:
        As shown below, there are 3 ways you can generate "rabbit" from S.
        rabbbit
        rabbbit
        rabbbit
*/

public class Distinct_count {
    
    public static void main(String[] args) {
        // String s = "babgbag";
        // String t = "bag";

        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(distinct_C_subseq(s, t, 0, 0));
    }

    /*Recursive Approach.
        Time: O(2^(t.length()))
        Space: O(t.length())

    */
    static int numDistinct_r(String s,String t, int x, int y) {
        if(x == s.length() && y == t.length()) {    //if both empty, then we already created the answer.
            return 1;
        }
        else if(x == s.length()) {        //if "s" string empty, then remaining "t" can't be made.
            return 0;
        }
        else if(y == t.length()) {       //if "t" string empty, then it is already created.
            return 1;
        }


        char sChar = s.charAt(x);
        char tChar = t.charAt(y);

        if(sChar == tChar) {
            //ask the count of answers from next sChar and next tChar.
            int val1 = numDistinct_r(s, t, x + 1, y + 1);

            //ask the count of answers from next sChar, but same tChar.  (as current tChar can be matched with multiple sChar)
            int val2 = numDistinct_r(s, t, x + 1, y);
            
            //return their sum value;
            return val1 + val2;
        }
        else { //if sChar and tChar are not same, then check for next sChar. (we can move forward in "t" only when current tChar matches)
            return numDistinct_r(s, t, x + 1, y);
        }
    }

    /********************************************************************************************** */




    /*2-D DP, {filling order similar to LCS}
        Time: O(sLength * tLength)
        Space: O(sLength * tLength)
    */
    
    public int numDistinct_DP(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[0].length - 1; j >= 0; j--) {
                
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 1;
                }
                else if(i == dp.length - 1) {
                    dp[i][j] = 0;
                }
                else if(j == dp[0].length - 1) {
                    dp[i][j] = 1;
                }
                else {
                    char sChar = s.charAt(i);
                    char tChar = t.charAt(j);
                    
                    //if tchar and sChar are same, we have to look down-cell and down-right-cell.
                    if(sChar == tChar) {
                        dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                    }
                    else {   //if not equal, just go to down-right-cell.
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        
        return dp[0][0];
    }
    /****************************************************************************************** */


    /*1-D DP {we have to move from left to right in a row, to fill this DP}
        Time: O(sLength * tLength)
        Space: O(sLength)
    */

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        
        for(int i = s.length() ; i >= 0; i--) {
            for(int j = 0; j < dp.length; j++) {    //this order is imp; as we reaches to down-cell, and down-right-cell.
                
                if(i == s.length() && j == dp.length - 1) {
                    dp[j] = 1;
                }
                else if(i == s.length()) {
                    dp[j] = 0;
                }
                else if(j == dp.length - 1) {
                    dp[j] = 1;
                }
                else {
                    char sChar = s.charAt(i);
                    char tChar = t.charAt(j);
                    
                    if(sChar == tChar) {
                        dp[j] = dp[j] + dp[j + 1];
                    }
                    else {
                        dp[j] = dp[j];
                    }
                }
            }
        }
        
        return dp[0];
    }
    /*************************************************************************************** */
}
