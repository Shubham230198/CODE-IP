/*Minimum rotations in a dominoes array.

    In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.
    We may rotate the ith domino, so that A[i] and B[i] swap values.

    Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
    If it cannot be done, return -1.
*/

public class Dominos_min_rotaions {
    
    /*Checking 4 possible combinations {val1-in-arr1, val1-in-arr2, val2-in-arr1, val2-in-arr2}
        Time: O(4 * n);
        Space: O(1);
    */

    //this function will count number of swaps required, to set "val" into "arr1".
    public int getSwapsCount(int[] arr1, int[] arr2, int val) {
        
        int swapsCount = 0;
        for(int i = 0; i < arr1.length; i++) {
            
            if(arr1[i] == val) {  //if already the val is present do nothing.
                //do nothing
            }
            else {  
                if(arr2[i] == val) {   //if "val" is not present in arr1, but present in arr2 --> then increase the swapCount.
                    swapsCount++;
                }
                else{               //if "val" is not present in arr1, nor in arr2 --> then return +Infinity. {as "val" can't be set in arr1}
                    return Integer.MAX_VALUE;
                }
            }
        }
        
        return swapsCount;
    }
    
    
    public int minDominoRotations(int[] A, int[] B) {
        
        //checking all 4 combinations possible
        int val1_in_A = getSwapsCount(A, B, A[0]);
        int val1_in_B = getSwapsCount(B, A, A[0]);
        
        int val2_in_A = getSwapsCount(A, B, B[0]);
        int val2_in_B = getSwapsCount(B, A, B[0]);
        
        
        //getting minimum value out of all 4 possible combinations.
        int minRotations = val1_in_A;
        if(minRotations > val1_in_B) {
            minRotations = val1_in_B;
        }
        
        if(minRotations > val2_in_A) {
            minRotations = val2_in_A;
        }
        
        if(minRotations > val2_in_B) {
            minRotations = val2_in_B;
        }


        //if "minRotations" is +Infinity --> no answer is possible.
        if(minRotations == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return minRotations;
        }
    }
    /***************************************************************************** */
}
