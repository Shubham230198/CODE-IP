/* House Robber-1

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money 
    you can rob tonight without alerting the police.
    It will automatically contact the police if two adjacent houses were broken into on the same night

    Input: [5, 2, 1, 3]
    Output: 8
    Explanation: Rob the first and the last house.
*/


public class House_Robber {
    
    /*Famous Dynamic Programming Approach. (for current postion last two-position answers are needed.)
        Time: O(n);
        Space: O(n);

    */

    /*************************************************************************** */



    /*Using 2-variables approach. {same above logic, just space optimised}
        Time: O(n);
        Space: O(1);
    */
    public long houseRobber(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        else if(A.length == 1) {
            return (long)A[0];
        }

        long secondLastProfit = A[0];
        long lastProfit = Math.max(A[0], A[1]);

        for(int i = 2; i < A.length; i++) {
            long nowProfit = Math.max(lastProfit, secondLastProfit + A[i]);

            secondLastProfit = lastProfit;
            lastProfit = nowProfit;
        }

        return lastProfit;
    }
    /********************************************************************************* */
}
