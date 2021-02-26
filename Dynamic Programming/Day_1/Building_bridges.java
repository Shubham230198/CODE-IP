/*BUILDING BRIDGES
    Consider a 2-D map with a horizontal river passing through its center. 
    There are n cities on the southern bank with x-coordinates a(1) … a(n) and
    n cities on the northern bank with x-coordinates b(1) … b(n). 
    You want to connect as many north-south pairs of cities as possible with bridges
    such that no two bridges cross. When connecting cities, you can only connect 
    city a(i) on the northern bank to city b(i) on the southern bank. 
    
    Maximum number of bridges that can be built to connect north-south pairs with the 
    aforementioned constraints.
*/

import java.util.*;

static class pair implements Comparable<pair> {
    int n;
    int s;
    
    pair(int a, int b) {
        n = a;
        s = b;
    }
    
    //sort on the basis of southern points:-
    public int compareTo(pair o) {   
        if(this.s < o.s) {
            return -1;
        }
        else if(this.s == o.s) {       //if southern points are same, sort on increasing northern points order.
            if(this.n < o.n) {             //reason being, same valued element is allowed in LIS; (e.i., 1, 2, 2, 3, 4)
                return -1;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}


/*LIS BASED APPROACH
 *  Time: O(n.log(n) + n.log(n))   ==> sorting + LIS
 *  Space: O(n)
 */
public static int build_Bridges(String[] args) {
    int[] north = {8, 1, 4, 3, 5, 2, 6, 7};
    int[] south = {1, 2, 3, 3, 5, 6, 7, 8};

    pair[] arr = new pair[north.length];
    for(int i = 0; i < arr.length; i++) {
        arr[i] = new pair(north[i], south[i]);
    }
    Arrays.sort(arr);
    
    int[] lis = new int[north.length];
    
    int ans = 0;
    for(int i = 0; i < arr.length; i++) {
        int low = 0; 
        int high = ans;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(lis[mid] <= arr[i].n) {   //here, equal elements are also allowed in LIS. (implement by "<="")            
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        lis[low] = arr[i].n;
        
        if(low == ans) {
            ans++;
        }
    }
    
    return ans;
}