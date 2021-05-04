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











    /*Logarithmic Approach.

        Time: O(log(n));
        Space: O(1);

        Way: --->We can divide the array into 4-parts.
             --->if any element occurs more than 25%, then it should occur at any of the starting point of the 4-fragments.
             --->So, we just have to find total Occurence of 4 elements. {this could be done by 2-binary searching} 
    */

    //function to find the first index, containing val.
    private int getLowerBound(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        
        int idx = -1;
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            if(arr[mid] < val) {
                left = mid + 1;
            }
            else if(arr[mid] > val) {             //if arr[mid] >= val;
                right = mid - 1;
            }
            else {
                idx = mid;
                right = mid - 1;
            }
        }
        
        return idx;
    }
    
    
    //function to find the last index, containing val.
    private int getUpperBound(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        
        int idx = -1;
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            if(arr[mid] < val) {
                left = mid + 1;
            }
            else if(arr[mid] > val) {                //if arr[mid] > val
                right = mid - 1;
            }
            else {
                idx = mid;
                left = left + 1;
            }
        }
        
        return idx;
    }
    
    
    //main log function.
    public int findSpecialInteger_2(int[] arr) {
        
        int jump = arr.length/4;
        int idx = 0;
        
        while(idx < arr.length) {
            
            //get the lowestIdx and upperestIdx of occurence of arr[idx];
            int lowerIdx = getLowerBound(arr, arr[idx]);
            int upperIdx = getUpperBound(arr, arr[idx]);
            
            
            //count the occurence of arr[idx]
            int count = upperIdx - lowerIdx + 1;
            
            //if the count is greater than arr.length/4, this is our answer.
            if(count > jump) {
                return arr[idx];
            }
            
            //else just move the idx to the starting of next segment, (by making a jump)
            idx += jump;
        }
        
  
        //if the majority element doesn't exist return -1;
        return -1;    
    }

    /************************************************************************************************************** */
}
