import java.util.*;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add 1 before and after to handle boundaries
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Find max coins from index 1 to n (not 0 or n+1, they are virtual 1s)
        return helper(1, n, balloons, dp);
    }

    private int helper(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int maxCoins = 0;

        for (int k = i; k <= j; k++) {
            // nums[i-1]*nums[k]*nums[j+1] is the coins from bursting k last
            int coins = nums[i - 1] * nums[k] * nums[j + 1]
                      + helper(i, k - 1, nums, dp)
                      + helper(k + 1, j, nums, dp);
            maxCoins = Math.max(maxCoins, coins);
        }

        return dp[i][j] = maxCoins;
    }
}
