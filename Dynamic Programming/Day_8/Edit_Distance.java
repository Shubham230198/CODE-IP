/*EDIT DISTANCE PROBLEM
    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

    You have the following three operations permitted on a word:
        Insert a character
        Delete a character
        Replace a character


    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation: 
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')
*/

public class Edit_Distance {
    
    /*2-D DP {similar filling as that of knapsack problem}
        Time: O(n^2)
        Space: O(n^2)

    */

    public int minDistance(String word1, String word2) {
        int[][] minOperation = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i < minOperation.length; i++) {
            for(int j = 0; j < minOperation[0].length; j++) {
                
                if(i == 0 && j == 0) {
                    minOperation[i][j] = 0;
                }
                else if(i == 0) {              //word1 = ""; then minoperation will be word2.length(); {ONLY ADD}
                    minOperation[i][j] = j;
                }
                else if(j == 0) {              //word2 = ""; then minoperation will be word1.length(); {ONLY DELETE}
                    minOperation[i][j] = i;
                }
                else {                  //delete operation, replace operation, insert operation respectively.
                         
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        minOperation[i][j] = minOperation[i - 1][j - 1];
                    }
                    else {
                    minOperation[i][j] = Math.min(minOperation[i - 1][j], Math.min(minOperation[i - 1][j - 1], minOperation[i][j - 1])) + 1;                        
                    }
                }
            }
        }
        
        return minOperation[word1.length()][word2.length()];
    }
}
