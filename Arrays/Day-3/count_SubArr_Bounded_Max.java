/*NUMBER OF SUBARRAYS WITH BOUNDED MAXIMUM

    We are given an array A of positive integers, and two positive integers L and R (L <= R).

    Return the number of (contiguous, non-empty) subarrays such that the value of the maximum 
    array element in that subarray is at least L and at most R.

    Input: 
    A = [2, 1, 4, 3]
    L = 2
    R = 3
    Output: 3
    Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
*/

public class count_SubArr_Bounded_Max {

    /*2-Pointers  {start-start}
        Time: O(n);
        Space: O(1);
    */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int totalAns = 0;
        
        int lastValidCount = 0;
        int left = 0;
        int right = 0;
        
        while(right < A.length) {
            int val = A[right];
            
            if(L <= val && val <= R) {                      //if val is in range; then get the new arrays ending at val, and update "lastValidCount".
                int nowAns = (right - left + 1);
                
                lastValidCount = nowAns;
                totalAns += nowAns;
            }
            else if(val < L) {                          //if val is < L; then no new arrays ending at val, just the lastValid Count.
                
                totalAns += lastValidCount;
            }
            else {                              //when val > R; then reset everything as if fresh problem from "right + 1";
                left = right + 1;
                lastValidCount = 0;
            }
            
            right++;
        }
        
        return totalAns;
    }
    /********************************************************************************** */

}