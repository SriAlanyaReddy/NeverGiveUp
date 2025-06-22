import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        // Step 1: Add 0 and n to cuts
        int[] allCuts = new int[m + 2];
        allCuts[0] = 0;
        allCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            allCuts[i + 1] = cuts[i];
        }

        // Step 2: Sort the cuts
        Arrays.sort(allCuts);

        // Step 3: DP initialization
        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(1, m, allCuts, dp); // m+1 is last index
    }

    private int helper(int i, int j, int[] cuts, int[][] dp) {
        // Base case: no cuts between i and j
        if (i>j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        // ✅ Use your loop: k from i to j-1
        for (int k = i; k <= j; k++) {
            int cost = cuts[j+1] - cuts[i-1] // cutting between cuts[i] and cuts[j]
                     + helper(i, k-1, cuts, dp)
                     + helper(k+1, j, cuts, dp);

            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }
}
