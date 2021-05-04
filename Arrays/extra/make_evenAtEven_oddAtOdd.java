/*Make the evenElements to evenIndex and oddElement to oddIndex.

    Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

    Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
    Return any answer array that satisfies this condition.

    Input: nums = [4,2,5,7]
    Output: [4,5,2,7]
    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


*/

public class make_evenAtEven_oddAtOdd {
    

    /*Keep track of oddWrong and evenWrong element using two pointers, whenever we get both wrong, we swap them.

        Time: O(n);
        Space: O(1);
    */
    public int[] sortArrayByParityII(int[] nums) {
        
        int odd = 1;
        int even = 0;
        
        while(odd < nums.length && even < nums.length) {
            
            if(nums[odd] % 2 == 1) {
                odd += 2;
            }
            else if(nums[even] % 2 == 0) {
                even += 2;
            }
            else {
                
                //swap them, and move to next part
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                
                even += 2;
                odd += 2;
            }
        }
        
        //return the nums array.
        return nums;
    }
    /************************************************************************************* */
}
