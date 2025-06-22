class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return find(1, n, dp);
    }

    public int find(int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mincost = Integer.MAX_VALUE; // ✅ FIXED

        for (int x = i; x <= j; x++) {
            int left = find(i, x - 1, dp);
            int right = find(x + 1, j, dp);
            int cost = x + Math.max(left, right);

            mincost = Math.min(mincost, cost); // ✅ correct logic
        }

        return dp[i][j] = mincost;
    }
}
