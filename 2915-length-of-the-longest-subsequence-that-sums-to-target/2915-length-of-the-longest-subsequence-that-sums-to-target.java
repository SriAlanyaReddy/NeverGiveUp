class Solution {
    public int lengthOfLongestSubsequence(List<Integer> a, int target) {
        int n = a.size();
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res = find(n - 1, target, dp, a);
        return res <= 0 ? -1 : res; // If no valid subsequence, return -1 as per usual conventions
    }

    public int find(int ind, int target, int[][] dp, List<Integer> a) {
        if (target == 0) return 0;
        if (ind < 0) return Integer.MIN_VALUE;
        if (dp[ind][target] != -1) return dp[ind][target];

        int notTake = find(ind - 1, target, dp, a);
        int take = Integer.MIN_VALUE;
        if (a.get(ind) <= target) {
            int next = find(ind - 1, target - a.get(ind), dp, a);
            if (next != Integer.MIN_VALUE) take = 1 + next;
        }
        return dp[ind][target] = Math.max(take, notTake);
    }
}
