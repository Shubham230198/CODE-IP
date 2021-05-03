/*Code Chef Buddy, Alice and Charlie Game.

    Note: A long question. HAHA
    Link: https://www.codechef.com/SNCKPE19/problems/BUDDYNIM


    Important: Bob can win iff --> {all non-zero elements on both tables are same}

*/



#include<bits/stdc++.h>
using namespace std;


//actual function, determining who wins.
string solve(int arr1[], int arr2[], int n, int m) {
    sort(arr1, arr1 + n);
    sort(arr2, arr2 + m);

    //ignoring the "0" values of arr1
    int idx1 = 0;
    while(idx1 < n && arr1[idx1] == 0) {
        idx1++;
    } 

    //ignoring the "0" values of arr2
    int idx2 = 0;
    while(idx2 < m && arr2[idx2] == 0) {
        idx2++;
    }

    //comparing the elements of tables.
    while(idx1 < n && idx2 < m) {
        if(arr1[idx1] != arr2[idx2]) {
            return "Alice";
        }

        idx1++;
        idx2++;
    }

    //if still any non-zero elements remains, on either of the tables.
    if(idx1 < n || idx2 < m) {
        return "Alice";
    }
    else {          //else the structure is exactly same.
        return "Bob";
    }

}




int main() {
    int t; cin>>t;

    while(t--) {
        //taking input for this case.
        int n,m; cin>>n>>m;

        int arr1[n];
        for(int i = 0; i < n; i++) {
            cin>>arr1[i];
        }

        int arr2[m];
        for(int i = 0; i < m; i++) {
            cin>>arr2[i];
        }

        //solving
        string winner = solve(arr1, arr2, n, m);
        
        cout<<winner<<"\n";

    }
}