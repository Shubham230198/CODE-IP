/* Mexximization ---> {sort the array, just all the repetitive elements should come at last.}

    You are given an integer n and an array a1,a2,…,an. You should reorder the elements of the array a 
    in such way that the sum of MEX on prefixes (i-th prefix is a1,a2,…,ai) is maximized.

    MEX  of a set of nonnegative integers is the minimal nonnegative integer such that it is not in the set.
    For example, MEX({1,2,3})=0, MEX({0,1,2,4,5})=3.

    Input:
    3
    7
    4 2 0 1 3 3 7
    5
    2 2 8 6 9
    1
    0


    Output:
    0 1 2 3 4 7 3 
    2 6 8 9 2 
    0
*/




#include<bits/stdc++.h>
using namespace std;

int main() {
    int t; cin>>t;

    while(t--) {
        int n; cin>>n;
        vector<int> arr(n, 0);
        
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        sort(arr.begin(), arr.end());

        vector<int> temp;
        vector<int> ans;
        ans.push_back(arr[0]);
        for(int i = 1; i < n; i++) {
            int val = arr[i];

            if(ans[ans.size() - 1] == val) {
                temp.push_back(val);
            }
            else {
                ans.push_back(val);
            }
        }

        for(int x: ans) {
            cout<<x<<" ";
        }

        for(int x: temp) {
            cout<<x<<" ";
        }       

        cout<<"\n";
    }
}