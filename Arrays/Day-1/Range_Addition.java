/*RANGE ADDITION.
    Assume you have an array of length n initialized with all 0's and are given k update operations.
    Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments 
    each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

    Return the modified array after all k operations were executed.

*/

public class Range_Addition {
    
    /*Update on only "start" and "end + 1"
        Time: O(n + q);
        Space: O(n);  =>{could also be done within a single array}
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] helper = new int[length];

        for(int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];

            helper[start] += inc;

            if(end != helper.length - 1) {
                helper[end + 1] -= inc;
            }
        }

        int[] result = new int[helper.length];
        result[0] = helper[0];
        for(int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + helper[i];
        }

        return result;
    }
    /************************************************************* */
}
