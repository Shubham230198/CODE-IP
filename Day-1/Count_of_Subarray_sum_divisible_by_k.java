/*  Sub-Array sum divisible by K

    You are given an array A of N positive and/or negative integers and a value K. 
    The task is to find the count of all sub-arrays whose sum is divisible by K.

    Using Hashmap (for storing freq of remainders)=> Time: O(n)   &&   Space: O(k)
    Using Array  (for storing freq of remainders)=>  Time: O(n + k)   &&  Space: O(k)

*/


import java.util.*;
class Solution
{   
    //Using HashMap
    long subCount_HM(long arr[] ,int n,int k)
    {
	    HashMap<Long, Long> map = new HashMap<>();
	    map.put((long)0, (long)1);
	    
	    long preSum = 0;
	    long subArrCount = 0;
	    for(int i = 0; i < n; i++) {
	        preSum += arr[i];
	        
	        //highly important as the preSum could be negative at any i, 
	        //(so remainder could become negative too)
	        
	        long rem = ((preSum % k) + k) % k;
	        if(map.containsKey(rem) == true) {
	            subArrCount += map.get(rem);
	        }
	         
	        if(map.containsKey(rem)) {
	            map.put(rem, map.get(rem) + 1);
	        }
	        else {
	            map.put(rem, (long)1);
	        }
	    }
	    
        return subArrCount;
        
    }


    //Using Array
    long subCout_Arr(long arr[], int n, int k) {
        int[] remFreq = new int[k];
        long preSum = 0;

        for(int i = 0; i < n; i++) {
            preSum += arr[i];

            int rem = ((int)(preSum % k) + k) % k;
            remFreq[rem]++;
        }

        long subArrCount = remFreq[0];
        for(int i = 1; i < k; i++) {
            subArrCount += (remFreq[i] * (remFreq[i] - 1)) / 2;
        }

        return subArrCount;
    }
}