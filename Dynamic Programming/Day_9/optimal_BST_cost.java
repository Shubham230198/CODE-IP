

public class optimal_BST_cost {
    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};

        // System.out.println(find_OBST_R(freq, 0, keys.length - 1));
        System.out.println(find_OBST_DP(freq));
    }

    /*Recursive Aproach
        Time: O(n^3)
        Space: O(n)  {recursive stack space}
    */
    public static int find_OBST_R(int[] freq, int left, int right) {
        if(left > right) {
            return 0;
        }
        else if(left == right) {
            return freq[left];            
        }
        

        int sum_lr = 0;
        for(int i = left; i <= right; i++) {
            sum_lr += freq[i];
        }

        int minCost = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            int leftCost = find_OBST_R(freq, left, i - 1);
            int rightCost = find_OBST_R(freq, i + 1, right);

            minCost = Math.min(leftCost + rightCost + sum_lr, minCost);
        }

        return minCost;
    }
    /******************************************************************** */

    /*2-D Dp   {similar to MCM}
        Time: O(n^2)
        Space: O(n^2)
    */
    public static int find_OBST_DP(int[] freq) {
        int[][] dp = new int[freq.length][freq.length];

        for(int gap = 0; gap < dp[0].length; gap++) {
            for(int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {

                if(gap == 0) {
                    dp[i][j] = freq[i];
                }
                else {
                    int sum = 0;
                    for(int x = i; x <= j; x++) {
                        sum += freq[x];
                    }

                    int cost = Integer.MAX_VALUE;
                    for(int k = i; k <= j; k++) {
                        int leftCost = 0;
                        int rightCost = 0;

                        if(k == i) {    //if there is no any left-subtree
                            leftCost = 0;
                            rightCost = dp[k + 1][j];
                        }
                        else if(k == j) {    //if there is no any right-subtree
                            leftCost = dp[i][k - 1];
                            rightCost = 0;
                        }
                        else {
                            leftCost = dp[i][k - 1];
                            rightCost = dp[k + 1][j]; 
                        }

                        cost = Math.min(leftCost + rightCost + sum, cost);
                    }

                    dp[i][j] = cost;
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }

    /********************************************************************* */
}
