/*MAX RANGE QUERIES
    You have C=100,000 cakes, numbered 1 through C. Each cake has an integer height; initially, the height of each cake is 0.

    There are N operations. In each operation, you are given two integers L and R, and you should increase by 1 
    the height of each of the cakes L,L+1,…,R. One of these N operations should be removed and the remaining 
    N−1 operations are then performed.

    You need to find the maximum number of cakes with height exactly K that can be achieved by removing one operation.

*/

#include<bits/stdc++.h>
using namespace std;

/*Left-right update, with preSumCount arrays.
    Time: O(10e5);
    Space: 3*O(10e5) + O(n)
*/
int main() {
    int t; cin>>t;

    while(t--) {
        int arr[100000 + 2]{0};        //size set to "+2" to prevent handling edge cases.
        int n, k; cin>>n>>k;
        int left[n];
        int right[n];

        //setting the values of all queries in the array.
        for(int i = 0; i < n; i++) {
            cin>>left[i]>>right[i];
            
            arr[left[i]]++;
            arr[right[i] + 1]--;
        }
        
        //creating the preSum of array, and array-of-"K"Count, and array-of-"k+1"Count.
        int countK[100000 + 2] {0};
        int countKPlus1[100000 + 2] {0};
        
        for(int i = 1; i <= 100000; i++) {
            arr[i] = arr[i] + arr[i - 1];
            
            if(arr[i] == k) {
                countK[i]++;
            }
            else if(arr[i] == k + 1) {
                countKPlus1[i]++;
            }
        }

        //creating preSum in "K"Count array, and "k+1"Count array.
        for(int i = 1; i <= 100000; i++) {
            countK[i] += countK[i - 1];
            countKPlus1[i] += countKPlus1[i - 1];
        }
        
        //skiping all the left-right moves, one-by-one.
        int KCakeCount = 0;
        for(int i = 0; i < n; i++) {
            int gain = countKPlus1[right[i]] - countKPlus1[left[i] - 1];
            int loss = countK[right[i]] - countK[left[i] - 1];
            
            KCakeCount = max(KCakeCount, countK[100000] - loss + gain);
        }

        cout<<KCakeCount<<"\n";
    }
}