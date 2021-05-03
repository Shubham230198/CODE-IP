/*First Missing Positive Number

    Given an unsorted integer array nums, find the smallest missing positive integer.
    Input: nums = [3,4,-1,1]
    Output: 2
*/
public class First_missing_Positive {
    
    /*Making every possible number to reach it's designated position.
        Time: O(2n);
        Space: O(1);
    */
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        while(i < nums.length) {
            
            //if the "val" is "<=" 0 OR ">" nums.len  ---> {skip this element}
            if(nums[i] <= 0 || nums[i] > nums.length) {
                i++;
                continue;
            }
            
            //if "val" is "(i + 1)" OR "nums[val - 1] == val"  ---> {skip this element}
            if(nums[i] == (i + 1) || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }
            

            //swaping the "val" & "nums[val - 1]" --> make the "val" to its right postion {1-based index}
            int tIdx = nums[i] - 1;
            
            int temp = nums[i];
            nums[i] = nums[tIdx];
            nums[tIdx] = temp;
        }

        
        //checking the first "val", which is not "val != (i + 1)"   ---> this will be our result.
        i = 0;
        while(i < nums.length) {
            if(nums[i] != i + 1) {
                return (i + 1);
            }
            
            i++;
        }
        
        //if no such "val" is found --> last (i + 1) will be our answer.
        return (i + 1);
    }

    /**************************************************************************************** */
}
