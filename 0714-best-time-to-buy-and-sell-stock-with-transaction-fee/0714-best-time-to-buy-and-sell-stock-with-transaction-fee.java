class Solution {
    public int maxProfit(int[] prices, int fee) {
        
   
        
  

        int n = prices.length;
        // Memoization DP array: [day][canBuy]
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaxProfit(0, 1, prices, dp,fee);
    }

    private int getMaxProfit(int index, int canBuy, int[] prices, int[][] dp,int fee) {
        if (index == prices.length ) return 0;

        if (dp[index][canBuy] != -1) return dp[index][canBuy];

        int profit = 0;

        if (canBuy == 1) {
            // Can buy
            int buy = -prices[index] + getMaxProfit(index + 1, 0, prices, dp,fee);
            int skip = getMaxProfit(index + 1, 1, prices, dp,fee);
            profit = Math.max(buy, skip);
        } else {
            // Can sell
            int sell = prices[index]-fee + getMaxProfit(index + 1, 1, prices, dp,fee); // cooldown
            int hold = getMaxProfit(index + 1, 0, prices, dp,fee);
            profit = Math.max(sell, hold);
        }

        return dp[index][canBuy] = profit;
    }
}
