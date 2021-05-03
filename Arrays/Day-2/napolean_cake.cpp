#include<bits/stdc++.h>
using namespace std;

int main() {
    int t; cin>>t;

    while(t--) {
        int n; cin>>n;
        
        int arr[n];
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        int dp[n] {0};
        for(int i = 0; i < n; i++) {

            if(arr[i] != 0) {
                dp[i] = 1;

                if(i - arr[i] >= 0) {
                    dp[i - arr[i]] += -1;
                }
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            dp[i] += dp[i + 1];
        }

        for(int i = 0; i < n; i++) {
            if(dp[i] == 0) {
                cout<<0<<" ";
            }
            else {
                cout<<1<<" ";
            }
        }
        cout<<"\n";
    }
}