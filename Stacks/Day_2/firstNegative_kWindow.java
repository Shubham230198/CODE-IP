/*First Negative integer in every window of size K.

    Given an array A[] of size N and a positive integer K, find the first negative integer 
    for each and every window(contiguous subarray) of size K.

    Input : 
    N = 5
    A[] = {-8, 2, 3, -6, 10}
    K = 2
    Output : 
    -8 0 -6 -6

*/
import java.util.*;
public class firstNegative_kWindow {
    
    /*Using a Queue of Negative numbers of the window:
        Time: O(n);
        Space: O(k);  
    */
    public long[] printFirstNegativeInteger_1(long A[], int N, int k) {
        long[] result = new long[A.length - k + 1];
        
        Queue<Long> q = new LinkedList<>();
        
        //creating the window of k length.
        int start = 0;
        int end = 0;
        while(end < k) {
            if(A[end] < 0) {
                q.add(A[end]);
            }
            end++;
        }
        
        int idx = 0;
        result[idx] = q.size() == 0 ? 0 : q.peek();
        idx++;
        
        //moving the window forward.
        while(end < A.length) {
            long comingNum = A[end];
            if(comingNum < 0) {
                q.add(comingNum);
            }
            
            long leavingNum = A[start];
            if(leavingNum < 0) {
                q.remove();
            }
            
            result[idx] = q.size() == 0 ? 0 : q.peek();
            idx++;
            
            start++;
            end++;
        }
        return result;
    }
    /***************************************************************************************** */







    /*Keeping the tract of last negative element. (while traversing from right to left).
        Time: O(n);
        Space: O(1);
    */
    public long[] printFirstNegativeInteger_2(long A[], int N, int k) {
        long[] result = new long[A.length - k + 1];
        
        int nIdx = A.length;
        int idx = A.length - 1;

        //traversing the (k - 1) elements from last.
        for(int i = 0; i < k - 1; i++) {
            if(A[idx] < 0) {
                nIdx = idx;
            }
            
            idx--;
        }
        
        
        //travesring (N - k + 1) eleemnts from right to left.
        while(idx >= 0) {
            
            //if current number is negative, update the negative_idx.
            if(A[idx] < 0) {
                nIdx = idx;
            }    
            
            //if the last negative_idx falls under this window of size k, (starting from current idx) ---> (that negative number ius our answer to this window)
            if(nIdx < (idx + k)) {
                result[idx] = A[nIdx];
            }
            else {     //else answer will be zero.
                result[idx] = 0;
            }
            
            idx--;
        }
        
        return result;
    }
    /*************************************************************************************** */
}
