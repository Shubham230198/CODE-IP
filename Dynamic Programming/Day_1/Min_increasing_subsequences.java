/*COUNT OF MINIMUM INCREASING SUBSEQUENCES;
    Given an array of integers of size N, you have to divide it into the 
    minimum number of “strictly increasing subsequences”.

    For example: 
    let the sequence be {1, 3, 2, 4}, then the answer would be 2. 
    In this case, the first increasing sequence would be {1, 3, 4} and the second would be {2}.

*/


class MIS {

    /*
        Time: O(n.log(n))
        Space: O(n)
    */

    public static int findMIS(int[] arr) {
        int[] lis = new int[arr.length];

        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int low = 0; int high = ans;

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(lis[mid] > arr[i]) {       //Here, "<" of normal LIS is replaced with ">", as we want longest decreasing subsequence.
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            lis[low] = arr[i];
            
            if(low == ans) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 2, 9 };

        System.out.println(findMIS(arr));
    }
}