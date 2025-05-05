class Solution {
    public int maxProfit(int[] prices) {
        
  

int n=prices.length;
        // Memoization DP array: [day][canBuy]
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaxProfit(0, 1, prices, dp);
    }

    private static int getMaxProfit(int index, int canBuy, int[] prices, int[][] dp) {
        if (index == prices.length) return 0;

        if (dp[index][canBuy] != -1) return dp[index][canBuy];

        int profit;

        if (canBuy == 1) {
            // Option 1: Buy now
            int buy = -prices[index] + getMaxProfit(index + 1, 0, prices, dp);
            // Option 2: Skip
            int skip = getMaxProfit(index + 1, 1, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            // Option 1: Sell now
            int sell = prices[index] + getMaxProfit(index + 2, 1, prices, dp);
            // Option 2: Hold (do nothing)
            int hold = getMaxProfit(index + 1, 0, prices, dp);
            profit = Math.max(sell, hold);
        }

        return dp[index][canBuy] = profit;
    }
}
