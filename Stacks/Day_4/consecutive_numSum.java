/*Consecutive Numbers Sum

    Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

    Input: 9
    Output: 3
    Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4

    Input: 15
    Output: 4
    Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

*/


public class consecutive_numSum {

    /*Special Mathematical Method,

        Explationation: https://leetcode.com/problems/consecutive-numbers-sum/discuss/1161273/This-is-a-O(sqrt(N))-mathematical-solution

        Time: O(log(N));
        Space: O(1);
    */
    public int consecutiveNumbersSum(int N) {
        int consecutiveCount = 1;
        int totalWays = 0;
        
        while(N >= consecutiveCount) {
            N -= (consecutiveCount - 1);
            
            if(N % (consecutiveCount) == 0) {
                totalWays++;
            }
            
            consecutiveCount++;
        }
        
        return totalWays;
    }
    /****************************************************************** */
}