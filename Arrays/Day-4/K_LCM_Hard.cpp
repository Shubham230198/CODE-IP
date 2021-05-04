/*K_LCM Hard:

    You are given a positive integer n. Find k positive integers a1,a2,…,ak, such that:

        ---> a1 + a2 + … + ak = n
        ---> LCM(a1, a2, …, ak) ≤ n2



    Input:
    2
    6 4
    9 5

    Output:
    1 2 2 1 
    1 3 3 1 1 

*/


#include<bits/stdc++.h>
using namespace std;


/*Divide the number in 3 numbers, such that all of them are either "even" or "1".

    Way: --->If "n" is odd, then answer is (n/2, n/2, 1);
         --->else if "n" is divisible by 4, then answer is (n/4, n/4, n/2);
         --->else answer is (n/2 - 1, n/2 - 1, 2);

    Time: O(1);
    Space: O(1);
*/




int main() {
    int t; cin>>t;

    while(t--) {
        int n,k; cin>>n>>k;


        //print the number 1, untill only k=3,
        while(k != 3) {
            cout<<1<<" ";

            k--;
            n--;
        }


        //make the logic work.
        if(n % 2 == 1) {

            cout<<(n/2)<<" "<<(n/2)<<" "<<1<<"\n";
        }
        else {

            if(n % 4 == 0) {
                cout<<(n/4)<<" "<<(n/4)<<" "<<(n/2)<<"\n";
            }
            else {
                cout<<(n/2)<<" "<<(n/2)<<" "<<2<<"\n"; 
            }
        }
    }
}