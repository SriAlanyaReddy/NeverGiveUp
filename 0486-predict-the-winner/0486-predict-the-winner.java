class Solution {
    public boolean predictTheWinner(int[] a) {
        int ts = 0, n = a.length;
        for (int i = 0; i < n; i++) {
            ts += a[i];
        }

        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int firstPlayerScore = find(0, n - 1, a, dp);
        int secondPlayerScore = ts - firstPlayerScore;

        return firstPlayerScore >= secondPlayerScore;
    }

    public int find(int start, int end, int[] a, int[][] dp) {
        if (start > end) return 0;

        if (start == end) return a[start];

        if (dp[start][end] != -1) return dp[start][end];

        // If player picks start
        int pickStart = a[start] + Math.min(
            find(start + 2, end, a, dp),
            find(start + 1, end - 1, a, dp)
        );

        // If player picks end
        int pickEnd = a[end] + Math.min(
            find(start + 1, end - 1, a, dp),
            find(start, end - 2, a, dp)
        );

        dp[start][end] = Math.max(pickStart, pickEnd);
        return dp[start][end];
    }
}
