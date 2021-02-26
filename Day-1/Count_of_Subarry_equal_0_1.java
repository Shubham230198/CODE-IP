/*  Subarrays with equal 1s and 0s 

    Given an array containing 0s and 1s. 
    Find the number of subarrays having equal number of 0s and 1s.

        Input:
        N = 7
        A[] = {1,0,0,1,0,1,1}
        Output: 8
        Explanation: The index range for the 8 
        sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
        (4, 5) ,(2, 5), (0, 5), (1, 6)


        Time: O(n)
        Space: O(n)
*/

import java.util.*;
class countsubArray {
    static int countSubarrWithEqualZeroAndOne(int arr[], int N)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int preSum = 0;
        int subArrCount = 0;
        for(int i = 0; i < arr.length; i++) {
            
            //treating 1 as +1, and 0 as -1.
            preSum += (arr[i] == 1 ? 1 : -1);
            
            if(map.containsKey(preSum)) {
                subArrCount += map.get(preSum);
            }
            
            if(map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            }
            else {
                map.put(preSum, 1);
            }
        }
        
        return subArrCount;
    }
}
