/*Bulb Switcher 3.
    There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.

    At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. 
    A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.

    Return the number of moments in which all turned on bulbs are blue.


    Input: light = [2,1,3,5,4]
    Output: 3
    Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.
*/


public class bulb_switcher_3 {

    /*Using formula for sum of N-natural_numbers.
        Time: O(n);
        Space: O(1);
    */
    public int numTimesAllBlue(int[] light) {
        long currSum = 0;
        long maxElement = 0;
        int ansCount = 0;
        
        for(int i = 0; i < light.length; i++) {
            currSum += light[i];
            maxElement = Math.max(maxElement, light[i]);
            
            long desiredSum = maxElement * (maxElement + 1) / 2;
            
            if(desiredSum == currSum) {
                ansCount++;
            }
        }
        
        return ansCount++;
    }
    /*************************************************************************** */
}
