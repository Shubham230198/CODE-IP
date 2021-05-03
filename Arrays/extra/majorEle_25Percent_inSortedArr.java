/* Element Appearing More Than 25% In Sorted Array.

    Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, 
    return that integer.

    Input: arr = [1,2,2,6,6,6,6,7,10]
    Output: 6

    Input: arr = [1,1]
    Output: 1
*/

public class majorEle_25Percent_inSortedArr {
    
    /*Counting the Occurence on the fly (as the array is sorted)

        Time: O(n);
        Space: O(1);
    */
    public int findSpecialInteger(int[] arr) {
        
        int val = -1;     //denoting dummy element.
        int count = 0;   //denoting no occurence at all.
        
        for(int x: arr) {
            
            if(x == val) {
                count++;
            }
            else {
                //check if previouse element was our answer
                if(count > arr.length/4) {
                    return val;
                }
                
                //else just update the newVal and newCount
                val = x;
                count = 1;
            }
        }
        
        //after comming out of this loop, our last element will remain uncheck,
        
        //so our answer should be val, as question gaurantees the a element with more than 25% times.
        return val;
    }

    /******************************************************************************************************************** */
}
