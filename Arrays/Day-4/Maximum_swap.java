/*Maximum Number Possible By Just One Swap.

    Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
    Return the maximum valued number you could get.

    Input: 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.
*/

public class Maximum_swap {
    
    /*Post-Max-Idx based approach {first element to have it's riht-max-ele greater than itself, has to swapped with it}
        Time: O(digits-count);
        Space: O(digits-count);
    */
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        
        int[] nums = new int[numStr.length()];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = numStr.charAt(i) - '0';
        }
        
        //creating a post-maximum-index array {for equal elements, give rightmost element index}
        int[] postMaxIdx = new int[nums.length];
        postMaxIdx[nums.length - 1] = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            
            if(nums[i] <= nums[postMaxIdx[i + 1]]) {
                postMaxIdx[i] = postMaxIdx[i + 1];
            }
            else {
                postMaxIdx[i] = i;
            }
        }
        
        
        //traverse the nums array --> {if current ele "<=" it's right-maxElement, swap them two and break the loop}
        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] < nums[postMaxIdx[i]]) {
                int left = i;
                int right = postMaxIdx[i];
                
                //swap   {first such swap will give max number possible}
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                //break the loop
                break;
            }
        }
        
        
        //convert the "nums" array into a number and return.
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = ans*10 + nums[i];
        }
        
        return ans;
    }
    /*********************************************************************** */
}
