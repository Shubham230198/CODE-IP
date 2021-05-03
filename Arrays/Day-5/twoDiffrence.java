/*Find Pair Given Difference
    Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.

    Input:
    L = 6, N = 78
    arr[] = {5, 20, 3, 2, 5, 80}
    Output: 1
    Explanation: (2, 80) have difference of 78.
*/

public class twoDiffrence {

    /*Using sorting, and then 2-pointer-traversal, {both from starting}

        Time: O(n.log(n) + n);     ---> {for sorting and traversal}
        Space: O(1);
    */
    public boolean findPair(int arr[], int size, int n) {
        if(size < 2) {
            return false;
        }
        
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        
        while(i < size && j < size) {
            
            if(i == j) {   //make sure they are not equal, As we want a pair of two elements.
                j++;
                continue;
            }
            
            int diff = arr[j] - arr[i];
            
            if(diff == n) {
                return true;
            }
            else if(diff < n) {
                j++;
            }
            else {       //if diff > n.
                i++;
            }
        }
        
        return false;
    }
    /************************************************************************************ */










    /*HashSet Based.   ---> {If we want to find all such distinct pairs, we have to use HashMap, (for frequency)}
        Time: O(n);
        Space: O(n);
    */
    public boolean findPair_2(int arr[], int size, int n) {
        HashSet<Integer> set = new HashSet<>();
        
        // n = a - b;
        for(int i = 0; i < size; i++) {
            
            if(set.contains(arr[i] - n) || set.contains(n + arr[i])) {      //here, arr[i] could work as both, "a" OR "b" respectively.
                return true;
            }
            else {
                set.add(arr[i]);
            }
        }
        
        return false;
    }
    /********************************************************************* */

}
