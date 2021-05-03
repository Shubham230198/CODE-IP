/*MIN-JUMPS Game
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position. Your goal is to reach
    the last index in the minimum number of jumps.

    You can assume that you can always reach the last index.

    
*/

public class min_jump_game {
    
    /*1-DP Approach
        Time: O(n^2)
        Space: O(n)
    */
    public int jump_DP(int[] nums) {
        int[] minJumpsDP = new int[nums.length];
        Arrays.fill(minJumpsDP, 1000000007);
        
        minJumpsDP[nums.length - 1] = 0;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            int minVal = 1000000007;
            
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < nums.length) {
                    minVal = Math.min(minVal, minJumpsDP[i + j]);
                }
                else {
                    break;
                }
            }
            
            minJumpsDP[i] = minVal + 1;
        }
        
        return minJumpsDP[0];
    }
    
    /***************************************************************************************** */

    /*SPECIAL METHOD
        Time: O(n)
        Space: O(1)
    */
    public static int minJumps(int[] nums) {
        int jumps = 0;
        int currentReach = 0;
        int nextReach = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i == nums.length - 1) {            //if reach to last index, return jumps till now.
                return jumps;
            }
            
            //update nextReach with possible current nums[i];
            nextReach = Math.max(nextReach, i + nums[i]);  

            //if i reach currentReach, time to make jump to nextReach
            if(i == currentReach) {    
                
                if(i >= nextReach) {   //but if "i" >= nextReach, there is no possible solution.
                    return -1;
                }
                
                jumps++;
                currentReach = nextReach; 
            }
        }

        return -1;
    }

    /***************************************************************************************** */
}
