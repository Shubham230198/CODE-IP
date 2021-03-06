/**PERFECT NUMBERS {Leet}
      Given an integer n, return the least number of perfect square numbers that sum to n.
        Example 1:

        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.

    NOTE:- Here, both combination as well as permutation approach will work fine. As we are taking min(or Max).

*/

public class Perfect_Squares {
    
    
    /*USING PERMUTATION APPROACH {of coin change}
        Time: O(n * root(n))
        Space: O(n)
    */
    public int numSquares(int n) {
        int[] countOfSquares = new int[n + 1];
        for(int i = 0; i < countOfSquares.length; i++) {
            countOfSquares[i] = Integer.MAX_VALUE - 1;
        }
        countOfSquares[0] = 0;

        for(int i = 1; i < countOfSquares.length; i++) {
        
            for(int j = 1; j * j <= i; j++) {
                countOfSquares[i] = Math.min(countOfSquares[i], countOfSquares[i - j * j] + 1);
            }
        }
        
        return countOfSquares[n];
    } 
    /*************************************************************************** */


    /*USING COMBINATION APPROACH {of coin change}
        Time: O(n * root(n));
        Space: O(n)
    */
    public int numSquares_Combination(int n) {
        int[] countOfSquares = new int[n + 1];
        for(int i = 0; i < countOfSquares.length; i++) {
            countOfSquares[i] = Integer.MAX_VALUE - 1;
        }
        countOfSquares[0] = 0;

        for(int i = 1; i * i <= n; i++) {
        
            for(int j = 1; j < countOfSquares.length; j++) {
                
                if(j - i*i >= 0) {
                    countOfSquares[j] = Math.min(countOfSquares[j], countOfSquares[j - i * i] + 1);
                }
                
            }
        }
        
        return countOfSquares[n];
    }    
/*********************************************************************************** */
}
