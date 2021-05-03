/*Max Sum of smallest and second-smallest in all possible sub-arrays.

    Given an array, find maximum sum of smallest and second smallest elements chosen from all possible sub-arrays. 
    More formally, if we write all (nC2) sub-arrays of array of size >=2 and find the sum of smallest and second smallest, 
    then our answer will be maximum sum among them.

    Input : arr[] = [4, 3, 1, 5, 6]
    Output : 11
*/


public class MaxSum_Of2Smallest_inSubArr {    

    /*This question is simply deduced to Maximum of sum-of-2-consequtive-elements.
        Time: O(n);
        Space: O(1);
    */
    public static long pairWithMaxSum(long arr[]) {
        long maxSum = Long.MIN_VALUE;
        
        for(int i = 1; i < arr.length; i++) {
            maxSum = Math.max(maxSum, arr[i] + arr[i - 1]);
        }
        
        return maxSum;
    }
    /*********************************************************** */
}











