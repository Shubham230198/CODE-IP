/*SQUARES OF SORTED ARRAYS
    Given an integer array nums sorted in non-decreasing order, 
    return an array of the squares of each number sorted in non-decreasing order.

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
*/
public class squares_of_sorted_array {
    
    /*2-Pointer approach   {mid-mid}{first finding out first positve number in "nums" array}
        Time: O(n)
        Space: O(1)
    */
    public int[] sortedSquares_1(int[] nums) {
        int idx = nums.length;  //if positive number are not present.

        //finding first positive number index.
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                idx = i;
                break;
            }
        }
        
        int[] results = new int[nums.length];
        
        //left will move to more left {over the negative numbers}
        //right will move to more right {over the positive numbers}
        int right = idx;
        int left = idx - 1;

        idx = 0; //idx will be used to fill squares in results array.
        while(left >= 0 && right < nums.length) {
            int lSquare = nums[left]*nums[left];
            int rSquare = nums[right]*nums[right];
            
            if(lSquare > rSquare) {
                results[idx] = rSquare;
                right++;
            }
            else {
                results[idx] = lSquare;
                left--;
            }
            
            idx++;
        }
        
        while(left >= 0) {
            results[idx] = nums[left]*nums[left];
            idx++;
            left--;
        }
        
        while(right < nums.length) {
            results[idx] = nums[right]*nums[right];
            idx++;
            right++;
        }
        
        return results;
    }
    /*************************************************************************************** */


    /*2-Pointer approach    {start-end}
        Time: O(n);
        Space: O(1);
    */
    public int[] sortedSquares_2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        int[] results = new int[nums.length];
        int idx = nums.length - 1;
        
        while(left <= right) {
            int lVal = Math.abs(nums[left]);
            int rVal = Math.abs(nums[right]);
            
            if(lVal < rVal) {
                results[idx] = rVal * rVal;
                right--;
            }
            else {
                results[idx] = lVal * lVal;
                left++;
            }
            
            idx--;
        }
        
        return results;
    }
    /************************************************************************************** */
}
