class Solution {

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        
        // 3D DP array to memoize results
        int[][][] dp = new int[n][op1 + 1][op2 + 1];
        
        // Initialize all DP states to -1 (uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= op1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Start solving from the last index
        return solve(nums, k, op1, op2, n - 1, dp);
    }

    // Recursive function to compute minimum sum from 0 to idx
    private int solve(int[] nums, int k, int op1, int op2, int idx, int[][][] dp) {
        if (idx < 0) {
            return 0; // Base case: no elements left to process
        }

        // Return memoized result if already computed
        if (dp[idx][op1][op2] != -1) {
            return dp[idx][op1][op2];
        }

        int minSum = Integer.MAX_VALUE;
        int current = nums[idx];

        // Case 1: Apply only Operation 1 (halving)
        if (op1 > 0) {
            int halved = (int) Math.ceil(current / 2.0);
            int sumWithOp1 = halved + solve(nums, k, op1 - 1, op2, idx - 1, dp);
            minSum = Math.min(minSum, sumWithOp1);
        }

        // Case 2: Apply only Operation 2 (subtract k), only if current <= k
        if (op2 > 0 && current <= k) {
            int subtracted = current - k;
            int sumWithOp2 = subtracted + solve(nums, k, op1, op2 - 1, idx - 1, dp);
            minSum = Math.min(minSum, sumWithOp2);
        }

        // Case 3: Apply Operation 1 then Operation 2
        if (op1 > 0 && op2 > 0) {
            int afterOp1 = (int) Math.ceil(current / 2.0);
            if (afterOp1 >= k) {
                int result = (afterOp1 - k) + solve(nums, k, op1 - 1, op2 - 1, idx - 1, dp);
                minSum = Math.min(minSum, result);
            }

            // Case 4: Apply Operation 2 then Operation 1
            if (current >= k) {
                int afterOp2Op1 = (int) Math.ceil((current - k) / 2.0);
                int result = afterOp2Op1 + solve(nums, k, op1 - 1, op2 - 1, idx - 1, dp);
                minSum = Math.min(minSum, result);
            }
        }

        // Case 5: Apply no operation
        int noOperation = current + solve(nums, k, op1, op2, idx - 1, dp);
        minSum = Math.min(minSum, noOperation);

        // Memoize the result and return
        dp[idx][op1][op2] = minSum;
        return minSum;
    }
}
