/*ORDERLY QUEUE.
    A string S of lowercase letters is given.  Then, we may make any number of moves.
    In each move, we choose one of the first K letters (starting from the left), remove it, 
    and place it at the end of the string.

    Return the lexicographically smallest string we could have after any number of moves.

    Input: S = "baaca", K = 3
    Output: "aaabc"
    Explanation: 
        In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
        In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
*/


public class Orderly_queue {
    
    /*Sort of BUBBLE SORT {for k > 1}
        Time: O(S.len * S.len);  {it is when k == 1}
        Space: O(S.len);
    */
    public String orderlyQueue(String S, int K) {
        
        //if (k == 1), then create and check every string.
        if(K == 1) {
            String resStr = S;
            for(int i = 1; i < S.length(); i++) {   //{starting to rotate the string, starting from 1 char from left.}
                String tempStr = S.substring(i) + S.substring(0, i);
                
                if(tempStr.compareTo(resStr) < 0) {
                    resStr = tempStr;
                }
            }
            
            return resStr;
        
        }
        else {  //for (k != 1) => problem is just bubble sort. (so return the sorted string).
            char[] arr = S.toCharArray();
            Arrays.sort(arr);
            
            return String.valueOf(arr);
        }
    }
    /*********************************************************************************** */




}
