/*Find 3 numbers such that there sum is closest to the given target.

    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class threeSum {
    


    /*Using Binary Search, and a minDiff variable.

        Time: O(nlog(n) + nlog(n));  {sorting + traversal}
        Space: O(1);
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {    //it is such that the last value of i, could contain (i+1) and (i+2);
            
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                
                int val = nums[left] + nums[right] + nums[i];
                
                if(Math.abs(minDiff) > Math.abs(target - val)) {
                    minDiff = target - val;
                }
                
                if(val < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        
        return target - minDiff;
    }
    /****************************************************************************** */
}
