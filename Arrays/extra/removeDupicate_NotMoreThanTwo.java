/*Remove Duplicates from Sorted Array, such that not more than 2 occurence is allowed.

    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
    Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

    Input: nums = [0,0,1,1,1,1,2,3,3]
    Output: 7, nums = [0,0,1,1,2,3,3]
    Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.

*/


public class removeDupicate_NotMoreThanTwo {
    

    /*Using a "idx" to fill the array at right position, and "val" & "count" to trace the val and it's occurence.
        Time: O(n);
        Space: O(1);

    */
    public int removeDuplicates(int[] nums) {
        
        //make index "idx" to fill the array correclty.
        int idx = 0;
        
        //"val" to trace the recent value, and its count;
        int val = nums[0];
        int count = 1;
        
        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] == val) {   //if the num[i] is equal to last-val, increment count.
                count++;
            }
            else {                 //its time to set previous val at "idx",
                
                if(count >= 2) {
                    nums[idx++] = val;
                    nums[idx++] = val;
                }
                else {
                    nums[idx++] = val;
                }
                
                //update the new Count and Val;
                count = 1;
                val = nums[i];
            }
        }
        
        //make the last-val to the index "idx";  (as it won't be filled by above loop)
        if(count >= 2) {
            nums[idx++] = val;
            nums[idx++] = val;
        }
        else {
            nums[idx++] = val;
        }
        
        
        //return the idx. (as it will be pointing to size).
        return idx;
    }
    /***************************************************************************************************************** */
}
