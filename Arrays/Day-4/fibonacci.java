/*Find Nth Fibonacci Number.

    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is 
    the sum of the two preceding ones, starting from 0 and 1. That is,

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
*/

public class fibonacci {
    
    /*Nth Fibonacci Number.
        Time: O(log(n));
        Space: O(1);
    */
    public int fib(int n) {
        if(n <= 1) return n;
        
        int[][] mat = new int[][] {{1, 1}, {1, 0}};
        
        getPower(mat, n - 1);
        
        return mat[0][0];
    }
    
    public static void getPower(int[][] mat, int n) {
        if(n == 1) {
            return;
        }
        
        getPower(mat, n / 2);
        multiply(mat, mat);
        
        if(n % 2 != 0) {
            int[][] B = new int[][] {{1, 1}, {1, 0}};
            multiply(mat, B);
        }
    }
    
    public static void multiply(int[][] A, int[][] B) {
        
        int x00 = A[0][0]*B[0][0] + A[0][1]*B[1][0];
        int x01 = A[0][0]*B[0][1] + A[0][1]*B[1][1];
        int x10 = A[1][0]*B[0][0] + A[1][1]*B[1][0];
        int x11 = A[1][0]*B[0][1] + A[1][1]*B[1][1];
        
        A[0][0] = x00;
        A[0][1] = x01;
        A[1][0] = x10;
        A[1][1] = x11;
    }

    /************************************************************************************** */










    /*Using Golden Ratio
        Time: O(log(n));
        Space: O(1);
    */
    public int fib_2(int n) {
        if(n <= 1) return n;
        
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        
        return (int)Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }
    /******************************************************************************** */
}
