public class subSequence_widthSum {


    /* Order of Elements doens't matter. 
        1. every element will be acting as a minEle for all subsequences created with greaterThan(including current) elements. {2^(greaterThanElements)}
        2. every element will be acting as a maxEle for all subsequences created with lessThan(including current) elements. --> {2^(lessThanElements)}

        Note: Considering the answer can fit in "int" range.

        Time: O(n.log(n) + n) {sorting and traversal}
        Space: O(1),  {all the 2-powers will be calculated on the fly}
    */

    public int sumSubseqWidths_1(int[] arr) {
        Arrays.sort(arr);
        
        int widthSum = 0;
        
        int countAsMax = 1;
        int countAsMin = power(2, arr.length - 1);
        int mod = 1_000_000_007;
        
        for(int i = 0; i < arr.length; i++) {
            
            int currVal = (countAsMax * arr[i]) - (countAsMin * arr[i]);
            widthSum += (currVal);
            
            
            //update the countAsMax and countAsMin
            countAsMax *= 2;
            countAsMin /= 2;
        }
        
        return widthSum;
        
    }
    /******************************************************************************* */








    /* Using PowerArr to store 2-powers. {based on same above logic}
    
        Note: {It will work even if the answer goes out of "int", and we want it (MOD 10e9 + 7)}

        Time: O(nlog(n) + n); {sorting + traversal}
        Space: O(n);
    */
    public static long[] getPowerArr(int size) {
        long MOD = 1_000_000_007;
        
        long[] ans = new long[size];
        ans[0] = 1;
        
        for(int i = 1; i < size; i++) {
            ans[i] = (ans[i - 1] * 2) % MOD;
        }
        
        return ans;
    }
    
    public int sumSubseqWidths_2(int[] A) {
        int N = A.length;
        long MOD = 1_000_000_007;        
        long[] powerArr = getPowerArr(N);
        
        Arrays.sort(A);

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans = (ans + (powerArr[i] - powerArr[N - i - 1]) * A[i]) % MOD;
        }

        return (int) ans;
    }
    /******************************************************************************************** */
}