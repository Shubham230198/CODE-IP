import java.util.*;

public class test {

	public static int commonSpecialString(String a1, String a2) {
		int[][] dp = new int[a1.length() + 1][a2.length() + 1];

		for(int i = 0; i < ; i--) {
			for(int j = dp[0].length - 1; j >= 0; j--) {

				if(i == a1.length() - 1 && j == a2.length() - 1) {
					dp[i][j] = 0;
				}
				else if(i == a1.length() - 1 ) {
					dp[i][j] = 
				}
				else {

					if(a1.charAt(i) == a2.charAt(j)) {
						dp[i][j] = 1 + dp[i + 1][j + 1];
					}
					else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
					}
				}
			}
		}

		return dp[0][0];
	}
}