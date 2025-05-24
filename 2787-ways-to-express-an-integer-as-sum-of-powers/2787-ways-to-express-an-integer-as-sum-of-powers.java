import java.util.Arrays;

class Solution {
    static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        // Find the maximum base that raised to power x is <= n
        int maxbase = 1;
        while (Math.pow(maxbase, x) <= n) {
            maxbase++;
        }

        // Memoization table: base from 1 to maxbase, target from 0 to n
        int[][] dp = new int[maxbase + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start with base 1 and target n
        return findways(1, n, x, dp);
    }

    public int findways(int base, int target, int x, int[][] dp) {
        // If target becomes zero, we found one valid combination
        if (target == 0) return 1;

        // If base^x exceeds target, no valid combination from here
        if (Math.pow(base, x) > target) return 0;

        // Check memoization
        if (dp[base][target] != -1) return dp[base][target];

        int val = (int) Math.pow(base, x);

        // Option 1: Do not take the current base
        int nottake = findways(base + 1, target, x, dp);

        // Option 2: Take current base if its power is <= target
        int take = 0;
        if (val <= target) {
            take = findways(base + 1, target - val, x, dp);
        }

        // Save the result modulo 1e9+7 to avoid overflow
        return dp[base][target] = (take + nottake) % MOD;
    }
}
