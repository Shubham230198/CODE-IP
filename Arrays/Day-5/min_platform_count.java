/*Minimum Platform Required to Accomodate all the Trains.

    Given arrival and departure times of all trains that reach a railway station. 
    Find the minimum number of platforms required for the railway station so that no train is kept waiting.
    
    Arrival and departure time can never be the same for a train but we can have arrival time of one train 
    equal to departure time of the other. At any given instance of time, same platform can not be used for 
    both departure of a train and arrival of another train. In such cases, we need different platforms,

*/



public class min_platform_count {
    
    /*Sort the arrival arrays and departure arrays seprately, Then running 2-pointer{start} one on each, keeping track of max platforms.
        Time: O(2*nlog(n) + n);   {2-sorting and one traversal}
        Space: O(1);
    */
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int currPlatform = 0;
        int maxPlatform = 0;
        int aPtr = 0;
        int dPtr = 0;
        
        while(aPtr < n) {
            if(dep[dPtr] < arr[aPtr]) {
                currPlatform--;
                dPtr++;
            }
            else {
                currPlatform++;
                aPtr++;
            }
            
            maxPlatform = Math.max(maxPlatform, currPlatform);
        }
        
        return maxPlatform;
    }
    /************************************************************************************ */






    /*Time Clock Array Based
        Time: O(n + 2400);
        Space: O(2400)
    */

    static int findPlatform_TimeArray(int arr[], int dep[], int n)
    {
        //creating a 24 hrs time clock for a day.
        int[] timeClock = new int[2400];
        
        //incrementing platform count whenever a train arrive.
        for(int x: arr) {
            timeClock[x]++;
        }
        
        //decrementing platform count, just after a train leaves. {as same platform can't be used for arrival and departure of 2 trains}
        for(int x: dep) {
            timeClock[x + 1]--;
        }
        
        //creating a preSum of the TimeClock array, and keeping track of max-count-of-platforms used.
        int currPlatforms = 0;
        int minPlatforms = 0;
        for(int i = 0; i < timeClock.length; i++) {
            currPlatforms += timeClock[i];
            
            minPlatforms = Math.max(currPlatforms, minPlatforms);
        }
        
        return minPlatforms;
        
    }
    /******************************************************************************* */
}
