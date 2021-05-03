/* GAS STATION

    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to 
    its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

    Given two integer arrays gas and cost, return the starting gas station's index if you can travel around 
    the circuit once in the clockwise direction, otherwise return -1. 

    Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    Output: 3
*/

class Solution {

    /*Next Cyclic of the, first-negative preSum of Delta. {Delta[i] = gas[i] - cost[i]}
        Time: O(4n);
        Space: O(2n)
    */
    public int canCompleteCircuit_1(int[] gas, int[] cost) {
        //if totalGas < totalCost ---> No such circular path will exists.
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if(totalCost > totalGas) {
            return -1;
        }
        
        //creating Delta array.
        int[] delta = new int[gas.length];
        for(int i = 0; i < gas.length; i++) {
            delta[i] = gas[i] - cost[i];
        }
        
        //creating preSum of delta Array.
        int[] preSum = new int[delta.length];
        preSum[0] = delta[0];
        for(int i = 1; i < delta.length; i++) {
            preSum[i] = preSum[i - 1] + delta[i];
        }
        
        //finding MinVal and MinValIdx in the preSum.
        int idx = -1;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < preSum.length; i++) {
            if(preSum[i] < minVal) {
                minVal = preSum[i];
                idx = i;
            }
        }
 
        //returning the next cyclic index of minValIdx.
        if(idx == preSum.length - 1) {
            return 0;
        }
        else {
            return idx + 1;
        }
    }
    /********************************************************************************* */







    /* Same Above Idea  --- {with efficient code}
        Time: O(n);
        Space: O(1);
    */
    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int preSum = 0;
        int minPreSum = Integer.MAX_VALUE;
        int idx = -1;
        
        for(int i = 0; i < gas.length; i++) {
            preSum += (gas[i] - cost[i]);
            
            if(preSum < minPreSum) {
                minPreSum = preSum;
                idx = i;
            }
        }
        
        //if preSum is Negative in last ---> {means totalGas < totalCost}
        if(preSum < 0) {
            return -1;
        }
        else {

            //returning the cyclic next of idx.
            return (idx + 1) % gas.length;
        }
    }
    /********************************************************************* */
}