/*Interesting Subarray.

    We will call an array a of k integers interesting if max(a)−min(a)≥k. 
    For example, array [1,3,4,3] isn't interesting as max(a)−min(a)=4−1=3<4 while array [7,3,0,4,3] is as max(a)−min(a)=7−0=7≥5.

    You are given an array a of n integers. Find some interesting nonempty subarray of a, or tell that it doesn't exist.

    Input:
    1
    4
    2 0 1 9

    Output:
    YES
    1 4
*/


#include<bits/stdc++.h>
using namespace std;


/* Just have to check if any consecutive integers have absDiff moreThanEqual to 2.  (they will be our answer as subarray)

    Time: O(n);
    Space: O(1);

*/


int main() {
    int t; cin>>t;

    while(t--) {
        int n; cin>>n;
        int arr[n];
        
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        bool printNo = true;

        //check if any two consecutive elements have absDiff more than 1, then it will be our answer.
        for(int i = 1; i < n; i++) {
            if(abs(arr[i] - arr[i - 1]) >= 2) {
                printNo = false;

                //print the answer
                cout<<"YES\n";
                cout<<(i - 1)<<" "<<i<<"\n";
                break;
            }
        }

        if(printNo) {
            cout<<"NO\n";
        }
    }
}