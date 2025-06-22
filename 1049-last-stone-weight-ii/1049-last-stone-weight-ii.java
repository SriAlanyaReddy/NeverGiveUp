class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) total += stone;
        
        // dp[i][j] = true if we can get sum j using stones from index i to end
        Boolean[][] dp = new Boolean[stones.length][total / 2 + 1];
        
        int maxSubsetSum = helper(stones, 0, 0, total / 2, dp);
        return total - 2 * maxSubsetSum;
    }

    private int helper(int[] stones, int index, int currentSum, int target, Boolean[][] dp) {
        if (index == stones.length) return currentSum;

        if (dp[index][currentSum] != null) {
            return dp[index][currentSum] ? currentSum : -1;
        }

        int include = -1;
        if (currentSum + stones[index] <= target) {
            include = helper(stones, index + 1, currentSum + stones[index], target, dp);
        }

        int exclude = helper(stones, index + 1, currentSum, target, dp);

        int best = Math.max(include, exclude);
        dp[index][currentSum] = best != -1;
        return best;
    }
}
