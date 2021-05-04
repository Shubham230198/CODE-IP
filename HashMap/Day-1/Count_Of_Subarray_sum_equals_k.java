/*  Subarray Sum Equals K

    Given an array of integers nums and an integer k, 
    return the total number of continuous subarrays whose sum equals to k. 

        Example 1:

        Input: nums = [1,1,1], k = 2
        Output: 2

        Time: O(n);
        Space: O(n);

*/

import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        
        int preSum = 0;
        int subArrCount = 0;
        for(int i = 0; i < nums.length; i++) {      //order matters
            
            //1. update preSum.
            preSum += nums[i];
            
            //2. check for (presum - k) in the hashmap
            if(map.containsKey(preSum - k) == true) {
                subArrCount += map.get(preSum - k);
            }
            
            //3. update new preSum-value into hashmap 
            if(map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            }
            else {
                map.put(preSum, 1);
            }
        }
        
        return subArrCount;
    }
}