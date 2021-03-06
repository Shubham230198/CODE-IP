/*ARTHEMATIC SLICES -1 : {subarray based}
    An integer array is called arithmetic if it consists of at least three elements and 
    if the difference between any two consecutive elements is the same.

    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    Given an integer array nums, return the number of arithmetic subarrays of nums.

    Input: nums = [1,2,3,4]
    Output: 3
    Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

*/


public class Arthematic_Slices_1 {
    
    /*Linear DP
        Time: O(n);
        Space: O(n);    {can be even done in O(1)}
    */
    public int numberOfArithmeticSlices(int[] nums) {
        //at any index containg counting of all arthemetic subarrays ending that index.
        int[] count = new int[nums.length];           
        
        for(int i = 2; i < nums.length; i++) {           //starting from index, as min-size is 3. {Triplet}
            
            //checking if the last 2 elements make a arthemeic subarray. (along with current index element) 
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) { 
                count[i] = count[i - 1] + 1;
            }
        }
        
        int totalCount = 0; //counting total number arthematic subarrays.
        for(int x: count) {
            totalCount += x;
        }
        
        return totalCount;
    }
}
