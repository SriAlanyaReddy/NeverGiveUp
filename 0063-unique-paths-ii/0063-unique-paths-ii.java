import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int[][] dp = new int[n][m];

        // Start point
        if (a[0][0] == 1) return 0;
        dp[0][0] = 1;

        // Fill first column
        for (int i = 1; i < n; i++) {
            if (a[i][0] == 0) dp[i][0] = dp[i-1][0];
        }

        // Fill first row
        for (int j = 1; j < m; j++) {
            if (a[0][j] == 0) dp[0][j] =dp[0][j-1];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}
