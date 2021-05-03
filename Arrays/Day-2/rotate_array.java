/*ROTATE ARRAY
    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
*/

public class rotate_array {
    
    /*Reversing Method.
        Time: O(2*n)
        Space: O(1)
    */

    static void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        if(k < 0) {
            k += nums.length;
        }
        
        //firstly reverse last "k" elements
        reverse(nums, nums.length - k, nums.length - 1);

        //then reverse first "n-k" elements.
        reverse(nums, 0, nums.length - k - 1);

        //then reverse the whole array.
        reverse(nums, 0, nums.length - 1);
    }
    /************************************************************************** */
}
