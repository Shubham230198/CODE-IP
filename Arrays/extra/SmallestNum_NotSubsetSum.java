/*Smallest Number, that cannot be representated by sum of suset of Array.

    Given a sorted array of N positive integers, find the smallest positive integer S 
    such that S cannot be represented as sum of elements of any subset of the given array set.

    N = 3
    Arr[] = {1, 2, 3}
    Output: 7
    Explanation: 7 is the smallest positive number 
    for which any subset is not present with sum 7.
*/


public class SmallestNum_NotSubsetSum {    

    /*Simple single Loop Based

        Way: if (smallestNum < arr[i]) then smallestNum is the answer, unless add arr[i] to smallestNum, and traverse nextElements. 

        Logic: A positive integer ‘k’ being added to a series of consecutive positive integers [1, 2, 3, …….. p] furthers that series by K elements without disrupting the continuity as long as k ≤ (p+1).

        Proof: https://medium.com/dexters-lab/eli5-find-the-smallest-positive-integer-value-that-cannot-be-represented-as-sum-of-any-subset-of-f8ea2488184b

    */
    long findSmallest(long[] arr, int n) {
        long smallestNum = 1;
        
        for(long x: arr) {
            if(smallestNum < x) {   //if smallestNum < x, we found the gap, so smallestNum is the answer.
                return smallestNum;
            }
            
            smallestNum += x;
        }
        
        return smallestNum;
    }
    /*********************************************************** */
}
