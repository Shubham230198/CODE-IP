/*WILDCARD PATTERN MATCHING
    Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively,  
    You have to print 'true' if the wildcard pattern is matched with str else print 'false' .

    The wildcard pattern can include the characters ‘?’ and ‘*’
    ‘?’ – matches any single character
    ‘*’ – Matches any sequence of characters (including the empty sequence)

    pattern = "ba*a?"
    str = "baaabab"
    Output: 1
    Explanation: replace '*' with "aab" and '?' with 'b'. 

*/
public class wildcard_pattern {

    /*Recursive approach
        Time: O(n^n);
        Space: O(n);

    */

    static boolean wildCard(String patrn, String str, int p, int s) {
        if(p == patrn.length() && s == str.length()) {
            return true;
        }
        else if(p == patrn.length()) {
            return false;
        }
        else if(s == str.length()) {
            for(int i = p; i < patrn.length(); i++) {
                if(patrn.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        } 

        char pChar = patrn.charAt(p);
        char sChar = str.charAt(s);

        if(pChar == '*') {
            for(int i = s; i <= str.length(); i++) {   //"<=" is needed, as for last case when str = "";
                boolean flag = wildCard(patrn, str, p + 1, i);
                if(flag == true) {
                    return true;
                }
            }

            return false;
        }
        else if(pChar == '?') {
            return wildCard(patrn, str, p + 1, s + 1);
        }
        else {
            if(pChar == sChar) {
                return wildCard(patrn, str, p + 1, s + 1);
            }
            else {
                return false;
            }
        
        }
    }
    /********************************************************************** */


    /*2-d DP {like Knapsack problem}
        Time: O(n^2);
        Space: O(n^2)
    */

    boolean wildCard_DP(String pattern, String str)
    {
        boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
        
        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[0].length - 1; j >= 0; j--) {
                //if both blank, then it is matched
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                }
                else if(i == dp.length - 1) {   //if pattern is empty, then can't be matched.
                    dp[i][j] = false;
                }
                else if(j == dp[0].length - 1) {    //if string is empty, then
                    //if current char is star, then down cell will be our answer.
                    if(pattern.charAt(i) == '*') {   
                        dp[i][j] = dp[i + 1][j];
                    }
                    else {                 //if not star, then answer is false;
                        dp[i][j] = false;
                    }
                }
                else {
                    //if the patrn char is star, then OR of down and right cell. {why?}
                    if(pattern.charAt(i) == '*') {    
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    }
                    //if patrn char is '?' OR patrn and str char matches => look for down-right cell
                    else if((pattern.charAt(i) == '?') || (pattern.charAt(i) == str.charAt(j))) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
