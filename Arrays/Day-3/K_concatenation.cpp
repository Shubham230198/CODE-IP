/*K-CONCATENATION MAXIMUM SUM SUBARRAY.

    You are given an array A with size N (indexed from 0) and an integer K. Let's define 
    another array B with size N · K as the array that's formed by concatenating K copies of array A.

    For example, if A = {1, 2} and K = 3, then B = {1, 2, 1, 2, 1, 2}.

    You have to find the maximum subarray sum of the array B.


*/


#include<bits/stdc++.h>
using namespace std;

/*Special Approach, using kadane's algo.
    Time: O(3*n);
    Space: O(1);
*/

int kConcat(int arr[], int n, int k) {
    int nowMax = 0;
    int overAllMax = 0;

    int prev = 0;
    int delta = 0;
    int baseSum = 0;

    for(int j = 0; j < 3; j++) {

        for(int i = 0; i < n; i++) {
            nowMax = max(nowMax + arr[i], arr[i]);
            overAllMax = max(nowMax, overAllMax);
        }

        if(prev >= overAllMax) {
            return prev;
        }

        if(j == 0) {
            baseSum = overAllMax;
        }
        else if(j == 1) {
            delta = overAllMax - prev;
        }
        else {
            return (k - 1)*delta + baseSum;
        }

        prev = overAllMax;
    }

    return 0;   //code never get to this point.
}



int main() {
    int t; cin>>t;

    while(t--) {
        int n,k; cin>>n>>k;

        int arr[n];
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        int ans = kConcat(arr, n, k);

        cout<<ans<<"\n";

    }
}