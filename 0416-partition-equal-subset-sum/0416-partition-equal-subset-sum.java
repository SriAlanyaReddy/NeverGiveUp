class Solution {
    public boolean canPartition(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += a[i];

        if (sum % 2 != 0) return false;

        int[][] dp = new int[n][sum / 2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isPossible(n - 1, a, sum / 2, dp);
    }

    public boolean isPossible(int ind, int[] a, int target, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return a[0] == target;
        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean notake = isPossible(ind - 1, a, target, dp);
        boolean take = false;
        if (target >= a[ind]) {
            take = isPossible(ind - 1, a, target - a[ind], dp);
        }

        dp[ind][target] = (take || notake) ? 1 : 0;
        return take || notake;
    }
}
