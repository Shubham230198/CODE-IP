/*MAXIMUM SUM SUBARRAY
    Given an integer array nums, find the contiguous subarray (containing at least one number) which 
    has the largest sum and return its sum.

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
*/

public class maximum_subarray {
    
    /*Kadane's Algo
        Time: O(n);
        Space: O(1);
    */
    public int maxSubArray(int[] nums) {
        int nowSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            nowSum = Math.max(nowSum + nums[i], nums[i]);
            
            maxSum = Math.max(nowSum, maxSum);
        }
        
        return maxSum;
    }

    /******************************************************************************** */
}
