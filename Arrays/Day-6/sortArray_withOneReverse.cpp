/*Sort the Array, by just one subArray reversal.

    Given an array, find is it possible to sort the array a (in increasing order) by reversing exactly one segment of array.
    If Yes, then find the segment too.

    Input:
    3
    3 2 1

    Output:
    yes
    1 3

*/


#include<bits/stdc++.h>
using namespace std;

/* Reverse the reversed-segment and again check if the array is sorted now.

    way: --->find (starting_decrement_element), and (ending_increment_element).
         --->reverse the above fragment.
         --->Check if the array is sorted now.

    Time: O(n + n + n + n); {find-(starting_decrement_element and ending_increment_element) + reversing_the_segment + checking_if_the_array_is_sorted_or_not}
    Space: O(1);
*/

int main() {
    int n; cin>>n;
    int arr[n];
    for(int i = 0 ; i < n; i++) {
        cin>>arr[i];
    }


    //find first decreasing element from starting.
    int dIdx = 0;
    while(dIdx < n - 1) {
        if(arr[dIdx] > arr[dIdx + 1]) {
            break;
        }

        dIdx++;
    }


    //find first increasing element from ending.
    int iIdx = n - 1;
    while(iIdx > 0) {
        if(arr[iIdx] < arr[iIdx - 1]) {
            break;
        } 

        iIdx--;
    }


    //check if reversing is need or not, if not print the answer.
    if(iIdx == 0) {                //(dIdx == 0) also works
        cout<<"yes\n";
        cout<<1<<" "<<1<<"\n";
        return -1;
    }

    
    //reverse the corresponding segment and check if now the array is sorted.
    int left = dIdx;
    int right = iIdx;
    while(left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }

    bool isSorted = true;
    for(int i = 1; i < n; i++) {
        if(arr[i] < arr[i - 1]) {
            isSorted = false;
            break;
        }
    }


    //print the answer, on the basis of isSorted answer.
    if(isSorted) {
        cout<<"yes\n";
        cout<<(dIdx + 1)<<" "<<(iIdx + 1)<<"\n";
    }
    else {
        cout<<"no\n";
    }
}
