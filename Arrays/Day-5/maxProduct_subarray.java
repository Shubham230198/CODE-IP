/*Maximum Product Subarray

    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

    Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class maxProduct_subarray {
    
    /*Based on Main idea of Kadane's Algo.
        Time: O(n);
        Space: O(1);
    */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int overMaxProduct = nums[0];
        
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int maxTemp = maxProduct;
                int minTemp = minProduct;
                
                maxProduct = Math.max(nums[i], minTemp * nums[i]);
                minProduct = Math.min(nums[i], maxTemp * nums[i]);
            }
            else {
                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);
            }
            
            overMaxProduct = Math.max(overMaxProduct, maxProduct);
        }
        
        return overMaxProduct;
    }
    /**************************************************************************************** */
}