/*Minium jumps required to reach position x, {with incremental jumps}

    Given an integers X. The task is to find the number of jumps to reach a point X 
    in the number line starting from zero.

    Note: The first jump made can be of length one unit and each successive jump will 
    be exactly one unit longer than the previous jump in length. It is allowed to go 
    either left or right in each jump.

*/

public class minJumps_to_reach_x {
    
    /*Reach to x-or-greater by positive jumps only, thenafter when diff becomes divisible by 2. That steps will be our stepAns. 

        Time: O();
        Space: O(1);
    */
    public static int getMinSteps(int x) {
        //defineing reachPosition, stepSize and stepCount. 
        int reach = 0;
        int step = 1;
        int stepCount = 0;
        
        //get to the position, greater than equal to destination(x);
        while(reach < x) {
            reach += step;
            
            stepCount++;
            step++;
        }
        
        //get the difference,from reachPosition to destination(x)
        int diff = reach - x;
        
        //we will take next (+)steps untill the diff becomes even.    {at max we will need two steps} 
        while(diff % 2 != 0) {
            reach += step;
            stepCount++;
            step++;
            
            diff = reach - x;
        }
        
        return stepCount;
    }
    /******************************************************************* */




    /*Same Logic Implemented, with shorter code. 
        Time: O()
        Space: O(1)
    */
    static int getsum(int n) {  
        return (n * (n + 1)) / 2;  
    }  
      
    static int countJumps(int x) {  
        // First make number positive, answer will be same either it is positive or negative  
        x = Math.abs(x);  
    
        // To store required answer  
        int ans = 0;  
    
        // Continue till number is lesser or not in same parity  
        while (getsum(ans) < x || ((getsum(ans) - x) & 1) > 0)  
            ans++;  
      
        return ans;  
    }
    /*************************************************************************************** */
}
