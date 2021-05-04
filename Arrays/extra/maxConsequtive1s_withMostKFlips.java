/*Max Consecutive Ones, after at most K flips.

    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

*/



public class maxConsequtive1s_withMostKFlips {


    /*Variable length sliding window.

        Time: O(n + n);
        Space: O(1);
    */
    
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        int countZero = 0;     //parameter to count zeroes in current (high - low + 1) window.
        int maxLen = 0;      
        
        for(high = 0; high < nums.length; high++) {
            if(nums[high] == 0) countZero++;
            
            //while this window doesn't become valid, increment the low. (decrementing window size)
            while(countZero > k) {
                if(nums[low] == 0) {
                    countZero--;
                }
                
                low++;
            }
            
            //update the maxLen 
            maxLen = Math.max(maxLen, high - low + 1);
        }
        
        
        return maxLen;
    }
    /************************************************************************************************** */
}
