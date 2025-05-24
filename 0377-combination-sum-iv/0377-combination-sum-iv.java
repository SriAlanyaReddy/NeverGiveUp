import java.util.Arrays;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Use 1D dp since we only need to store result for each target
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return countWays(nums, target, dp);
    }

    public int countWays(int[] nums, int target, int[] dp) {
        // Base case: one way to form sum 0 (choose nothing)
        if (target == 0) return 1;

        // If result already computed
        if (dp[target] != -1) return dp[target];

        int totalWays = 0;

        // Try each number in nums as the start of the sequence
        for (int num : nums) {
            if (num <= target) {
                totalWays += countWays(nums, target - num, dp);
            }
        }

        // Store and return the result
        //dp[target] = totalWays;
        return  dp[target] = totalWays;
    }
}
