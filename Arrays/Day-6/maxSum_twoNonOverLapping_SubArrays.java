/*Maximum Sum of Two Non-Overlapping Subarrays.

    Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, 
    which have lengths L and M.  
    (For clarification, the L-length subarray could occur before or after the M-length subarray.)


    Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
    Output: 29
    Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.

*/


public class maxSum_twoNonOverLapping_SubArrays {
    

    /*Using preSum array, and 2-variables to keep track of max-M_SubArr_Sum and max-L_SubArr_Sum.

        Time: O(n + n);  {preSum + traversing}
        Space: O(n);   {preSum Array}

    */

    //helper function to get preSum array.
    private int[] getPreSum(int[] A) {
        int[] preSum = new int[A.length];
        preSum[0] = A[0];
        
        for(int i = 1; i < A.length; i++) {
            preSum[i] = A[i] + preSum[i - 1];
        }
        
        return preSum;
    }
    
    
    
    //main logic function.
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        
        //get the preSumArr of the "A";
        int[] preSum = getPreSum(A);
        
        
        //trace the maxSum of M-subArray and N-subArray.  (Along with overAllMax sum)
        int lMax = preSum[L - 1];
        int mMax = preSum[M - 1];
        int oMax = preSum[L + M - 1];
        
        for(int i = L + M; i < A.length; i++) {
            
            //considering the "L" subArray ending Here.
            mMax = Math.max(mMax, preSum[i-L] - preSum[i-L-M]);              //update "M" subArrayMax, before "i-L".
            oMax = Math.max(oMax, (preSum[i] - preSum[i-L]) + mMax );        //update the overAllMax.
            
            
            //considering the "M" subArray ending here.
            lMax = Math.max(lMax, preSum[i-M] - preSum[i-M-L]);                //update "L" subArrayMax, before "i-M".
            oMax = Math.max(oMax, (preSum[i] - preSum[i-M]) + lMax);           //update the overAllMax.
        }
        
        
 
        return oMax;
    }
    /********************************************************************************************************** */
}
