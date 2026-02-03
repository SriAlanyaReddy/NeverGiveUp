class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        // dp[day][canBuy][transactionsRemaining]
        int[][][] dp = new int[n][2][k+1];

        // Initialize all values to -1
        for (int[][] row : dp) {
            for (int[] inner : row) {
                Arrays.fill(inner, -1);
            }
        }

        return calculate(prices, 0, 1, k, dp);
    }

    public int calculate(int[] prices, int day, int canBuy, int transactionsLeft, int[][][] dp) {
        if (day == prices.length || transactionsLeft == 0) {
            return 0;
        }

        if (dp[day][canBuy][transactionsLeft] != -1) {
            return dp[day][canBuy][transactionsLeft];
        }

        int profit = 0;

        if (canBuy == 1) {
            int buy = -prices[day] + calculate(prices, day + 1, 0, transactionsLeft, dp);
            int skip = calculate(prices, day + 1, 1, transactionsLeft, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[day] + calculate(prices, day + 1, 1, transactionsLeft - 1, dp);
            int hold = calculate(prices, day + 1, 0, transactionsLeft, dp);
            profit = Math.max(sell, hold);
        }

        return dp[day][canBuy][transactionsLeft] = profit;
    }
    }
