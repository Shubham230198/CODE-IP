/*WIGGLE SORT

    Given an unsorted array nums, reorder it in-place such that
        nums[0] <= nums[1] >= nums[2] <= nums[3]....

    Input: [3, 5, 2, 1, 6, 4]
    Output: [1, 6, 2, 5, 3, 4]
    Explanation: This question may have multiple answers, and [2, 6, 1, 5, 3, 4] is also ok.
*/


public class wiggle_sort {
    
    /*Just keep focusing on order of next element, {based on even OR odd index}

        Time: O(n)  {single interation}
        Space: O(1)
    */
    public void wiggleSort(int[] nums) {
        
        for(int i = 1; i < nums.length; i++) {    
            //if index is even ---> (previous element should be ">=" then current element)
            if(i % 2 == 0) {

                if(nums[i - 1] < nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
                else {
                    //do nothing already sorted.
                }
            }
            //if index is odd ---> (previous element should be "<=" then current element)
            else {

                if(nums[i - 1] > nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
                else {
                    //do nothing already sorted.
                }
            }
        }
    }
    /****************************************************************************************** */
}