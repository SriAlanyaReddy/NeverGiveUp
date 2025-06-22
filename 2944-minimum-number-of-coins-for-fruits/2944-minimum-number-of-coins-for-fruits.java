class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n + 1]; // dp[i][free]: min cost starting at i with 'free' fruits available
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, prices, dp); // start from fruit 0, with no free fruits
    }

    int solve(int i, int free, int[] prices, int[][] dp) {
        if (i >= prices.length) return 0; // all fruits taken

        if (dp[i][free] != -1) return dp[i][free];

        // Option 1: Buy current fruit → get next i fruits free
        int take = prices[i] + solve(i + 1, free + i, prices, dp);

        // Option 2: Take current fruit for free
        int notTake = Integer.MAX_VALUE;
        if (free > 0) {
            notTake = solve(i + 1, free - 1, prices, dp);
        }

        return dp[i][free] = Math.min(take, notTake);
    }
}
