/*Maximum Distance to Closest Person.

    Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
    Return that maximum distance to the closest person.

    Input: seats = [1,0,0,0,1,0,1]
    Output: 2
    Explanation: 
        If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
        If Alex sits in any other open seat, the closest person has distance 1.
        Thus, the maximum distance to the closest person is 2.
*/


public class max_closest_dist {
    

    /*Similar Approach to that of "Falling Dominoes".   {code is slightly different flow}
        Time: O(n + n + n);
        Space: (1);
    */

    public int maxDistToClosest(int[] seats) {
        int left = 0;
        int right = 1;
        
        int maxDistance = 0;
        while(right < seats.length) {
            
            if(seats[left] == 1 && seats[right] == 1) {       //if both pointers have persons ----> we can made alex to sit just in between them.
                int nDist = (right - left + 1);    //{Including Distance}
                
                if(nDist % 2 == 0) {         //if distance is even ---->  we can made him sit "dist/2 - 1".  {as in middle seat alex will seat}.    
                    maxDistance = Math.max(maxDistance, (nDist / 2) - 1);
                }
                else {                      //if distance is odd ---->  we can made him sit "dist/2".  {as in middle seat alex will seat}.
                    maxDistance = Math.max(maxDistance, (nDist / 2));
                }
                
                left = right;           //left reaches to right, and right moves to nxt "1 position".
                right = right + 1;
            }
            else if(seats[left] == 1) {
                right++;
            }
            else if(seats[right] == 1) {
                left++;
            }
            else {
                left++;
                right++;
            }
        }
        
        //get the fistOcc and LastOcc of "1", as we have to check two edge cases ---> {when alex sit on "0th" Index, OR "Last" Index}
        int firstOcc = -1;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                firstOcc = i;
                break;
            }
        }
        
        int lastOcc = -1;
        for(int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1) {
                lastOcc = i;
                break;
            }
        }
        
        //calculate the distances  ---> {for first Index Seating, and last_Index seating.} 
        int fSeat = firstOcc - 0;
        int lSeat = (seats.length - 1) - lastOcc;
        
        return Math.max(maxDistance, Math.max(fSeat, lSeat));
    }
    /*************************************************************************************** */





    /*Similar Approach to Falling Dominoes. {AS well coding flow is similar}
        Time: O(n);
        Space: O(1)
    */
    public int maxDistToClosest_2(int[] seats) {
        //first and last occurence of "1". {to Handle edge cases}   {Inittialized with "0", as at least one seat is filled}.
        int firstOcc = 0;                                 
        int lastOcc = 0;
        
        //setting left to first "1".
        int left = 0;
        while(seats[left] != 1) {          // no need to check out-of-bound -->{as given atleast one seat is filled}
            left++;
            
            firstOcc = left;   //just updating "firstOcc", and "LastOcc" of "1".
            lastOcc = left;
        }
        
        int right = left + 1;
        
        int maxDistance = 0;
        while(right < seats.length) {
            
            while(right < seats.length && seats[right] != 1) {             //set right to next "1".  {if possible unless break the loop}
                right++;
            }
            
            if(right == seats.length) {
                break;
            }
            
            //update the lastOcc of "1".
            lastOcc = right;
            
            //distace between left and right {inclusive}
            int nDist = (right - left + 1);
            
            if(nDist % 2 == 0) {
                maxDistance = Math.max(maxDistance, (nDist / 2) - 1);
            }
            else {
                maxDistance = Math.max(maxDistance, (nDist / 2));
            }
            
            left = right;
            right = right + 1;
        }
        
        //calculating edge cases.
        int fIdx = firstOcc - 0;
        int lIdx = (seats.length - 1) - lastOcc;
        
        return Math.max(maxDistance, Math.max(fIdx, lIdx));
    }
    /*********************************************************************************** */
}
