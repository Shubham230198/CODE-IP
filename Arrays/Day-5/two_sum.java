/*TWO Value Sum equal to X.

    Given an array Arr of N positive integers and another number X. 
    Determine whether or not there exist two elements in Arr whose sum is exactly X.


    Note: Below discussed both approaches could also be used to get all desired pairs.
*/


public class two_sum {
    
    /*Sorting + 2-pointers{start-end}
        Time: O(nlogn + n);
        space: O(1);
    */

    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Arrays.sort(arr);
	    
	    int left = 0;
	    int right = n - 1;
	    
	    while(left < right) {
	        if(arr[left] + arr[right] == x) {
	            return true;
	        }
	        else if(arr[left] + arr[right] < x) {
	            left++;
	        }
	        else {
	            right--;
	        }
	    }
	    
	    return false;
    }
    /********************************************************************** */



    /*HashSet Based Approach
        Time: O(n);
        Space: O(n);
    */

    boolean hasArrayTwoCandidates_Set(int arr[], int n, int x) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int val: arr) {
            if(hs.contains(x - val)) {
                return true;
            }
            
            hs.add(val);
        }
	    
	    return false;
    }
    /********************************************************* */


}
