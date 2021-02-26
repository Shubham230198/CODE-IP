/*Russian Doll- Envelopes
    You have a number of envelopes with widths and heights given 
    as a pair of integers (w, h). One envelope can fit into another 
    if and only if both the width and height of one envelope is greater 
    than the width and height of the other envelope.

    What is the maximum number of envelopes can you Russian doll? (put one inside other)

    Note:
    Rotation is not allowed.

    Input: [[5,4],[6,4],[6,7],[2,3]]
    Output: 3 
    Explanation: The maximum number of envelopes you can Russian doll is 3 
    ([2,3] => [5,4] => [6,7]).
*/


static class pair implements Comparable<pair> {
    int w;
    int h;
    
    pair(int a, int b) {
        this.w = a;
        this.h = b;
    }
    
    //sort on the basis of height; (no same length is allowed)
    public int compareTo(pair o) {  
        if(this.h < o.h) {
            return -1;
        }
        else if(this.h > o.h) {
            return 1;
        }
        else {                       
            if(this.w < o.w) {   //as same length is not allowed, on equal heights
                                 //will be sorting pairs in reverse order of w;
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}


/*LIS BASED APPROACH
 *  Time: O(n.log(n) + nlog(n))   ==> sorting + LIS
 *  Space: O(n)
 */
public int maxEnvelopes(int[][] envelopes) {
    pair[] arr = new pair[envelopes.length];
    
    for(int i = 0; i < arr.length; i++) {
        arr[i] = new pair(envelopes[i][0], envelopes[i][1]);            
    }
    Arrays.sort(arr);
    
    int[] lis = new int[envelopes.length];
    int ans = 0;        
    for(int i = 0; i < arr.length; i++) {
        int low = 0; int high = ans;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(lis[mid] < arr[i].w) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        lis[low] = arr[i].w;
        
        if(low == ans) {
            ans++;
        }
    }
    
    return ans;
}