class Solution {
    public int findLength(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int[][] dp = new int[n1][n2];

        // Initialize dp with -1 for memoization
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }

        int maxLen = 0;

        // Try all starting points and take max result
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                maxLen = Math.max(maxLen, find(i, j, a1, a2, dp));
            }
        }

        return maxLen;
    }

    public int find(int idx1, int idx2, int[] a1, int[] a2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (a1[idx1] == a2[idx2]) {
            dp[idx1][idx2] = 1 + find(idx1 - 1, idx2 - 1, a1, a2, dp);
        } else {
            dp[idx1][idx2] = 0;
        }

        return dp[idx1][idx2];
    }
}
