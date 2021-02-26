/* Longest Increasing Subsequence:-

    Given an integer array nums, return the length
    of the longest strictly increasing subsequence.

    For example, [3,6,2,7] is a subsequence of the
    array [0,3,1,6,2,2,7].
*/


class LIS {
    /*
        Time : O(n^2);  Space: O(n)
    */

    public int lengthOfLIS_1(int[] nums) {
        int[] dp = new int[nums.length];               //i'th element stores the length of LIS 
                                                      //including i'th ele of arr. (from starting to i'th position)
        
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            int idx = i - 1;
            int maxLen = 0;
            
            while(idx >= 0) {
                if(nums[idx] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[idx]);
                }
                
                idx--;
            }
            
            dp[i] = maxLen + 1;
            
        }
        
        int ans = 0;
        for(int x: dp) {
            ans = Math.max(ans, x);
        }
        
        return ans;
    }

    /************************************************************************* */





    /*
        Time: O(n*Log(n));  Space: O(n)
    */

    public int lengthOfLIS_2(int[] nums) {
        int[] lis = new int[nums.length];  //this array will store LIS elemets for current Level.
                                         //but can't use to print LIS sequence, as it is updating all the time.
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int low = 0; 
            int high = ans;
            
            while(low < high) {
                int mid = low + (high - low)/2;
                
                if(lis[mid] < nums[i]) {     //it will be "<=" if equal elements are allowed in LIS.
                    low = mid + 1;             //it is "<" if equal elements are not allowed in LIS.
                }
                else {
                    high = mid;
                }
            }
            
            lis[low] = nums[i];
            
            if(low == ans) {
                ans++;
            }
        }
        
        return ans;
        
    }

    /*********************************************************************** */
}

