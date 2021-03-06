/*LARGEST SQUARE IN MATRIX
    Given a binary matrix mat of size n * m, find out the maximum size square sub-matrix with all 1s.

    Input: n = 2, m = 2
    mat = {
        {1, 1}, 
        {1, 1}}
    Output: 2
    Explaination: The maximum size of the square
    sub-matrix is 2. The matrix itself is the 
    maximum sized sub-matrix in this case.
*/

public class Largest_Square_in_Matrix {
    
    /*2-D DP {filled in similar fasion to Knapsack}
        Time: O(n^2)
        Space: O(n^2)
    */
    static int maxSquare(int n, int m, int mat[][]){
        
        int[][] dp = new int[n][m];
        int maxSize = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                }
                else {
                    if(mat[i][j] == 1) {
                        //taking 1 + Minimum(of top, left and top-left)
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                    else {
                        dp[i][j] = 0;
                    }
                }
                
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        
        return maxSize;
    }
}
