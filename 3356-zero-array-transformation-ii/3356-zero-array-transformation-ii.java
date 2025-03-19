class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int left = 0, right = queries.length, ans = -1;

        // Binary search to find the smallest k
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canZeroArray(nums, queries, mid, n)) {
                ans = mid;  // Try for smaller k
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canZeroArray(int[] nums, int[][] queries, int k, int n) {
        int[] diff = new int[n + 1]; // Difference array
        for (int i = 0; i < k; i++) {
            int li = queries[i][0], ri = queries[i][1], val = queries[i][2];
            diff[li] -= val;
            diff[ri + 1] += val;
        }

        // Apply the difference array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] + sum > 0) return false; // If any element remains nonzero
        }
        return true;
    }
}
