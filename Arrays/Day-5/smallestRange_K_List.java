/*Smallest Range Covering Elements from K Lists.

    You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
    We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

    Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
    Output: [20,24]
    Explanation: 
    List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
    List 2: [0, 9, 12, 20], 20 is in range [20,24].
    List 3: [5, 18, 22, 30], 22 is in range [20,24].
*/


public class smallestRange_K_List {

    /*Min-Priority Based solution {keep the track of max-element while adding into PQ, while minElement will be given by PQ}
        Time: O(n * log(k))    {here, n is total number of elements, while k is number of lists}.
        Space: O(k);
    */  
    public class pair implements Comparable<pair> {
        int listIdx;
        int eleIdx;
        int element;
        
        pair(int lIdx, int eIdx, int ele) {
            this.listIdx = lIdx;
            this.eleIdx = eIdx;
            this.element = ele;
        }
        
        public int compareTo(pair other) {
            return this.element - other.element;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        
        //these are the range variables.
        int a = Integer.MAX_VALUE;
        int b = 0;
        
        //the maxVal will keep the track of max-element in current set of all-considering elements.
        int maxVal = Integer.MIN_VALUE;
        
        
        //make min-priority queue of pairs, and at any instant it will keep exactly one-element of all the lists in it.
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            
            maxVal = Math.max(maxVal, val);    //update the maxVal, with new coming element if possible.
            pq.add(new pair(i, 0, val));
        }
        
        
        while(!pq.isEmpty()) {
            pair rem = pq.poll();
            
            //update the minRange variables, if possible, {using the minVal and maxVal}
            int minVal = rem.element;
            if(maxVal - minVal < a - b) {
                a = maxVal;
                b = minVal;
            }
            
            //if possible add next element from same list, else break the loop.
            if(rem.eleIdx + 1 < nums.get(rem.listIdx).size()) {
                int newVal = nums.get(rem.listIdx).get(rem.eleIdx + 1);
                
                maxVal = Math.max(maxVal, newVal);      //update the maxVal, with new coming element if possible.
                pq.add(new pair(rem.listIdx, rem.eleIdx + 1, newVal));   //add the new element-pair into the min-priority queue.
                
            }
            else {
                break;
            }
            
        }
        
        
        //make the minRange Array, and return it.
        int[] minRange = new int[] {b, a};
        return minRange;
    }
    /******************************************************************************************************************************** */

}
