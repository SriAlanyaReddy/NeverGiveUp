class Solution {

    public long rob(int[] nums,
                             int[] colors) {

        int n = nums.length;

        long[] dp = new long[n];

        Arrays.fill(dp, -1);

        return find(n - 1,
                    nums,
                    colors,
                    dp);
    }

    public long find(int index,
                     int[] nums,
                     int[] colors,
                     long[] dp) {

        // No house
        if (index < 0) {
            return 0;
        }

        // First house
        if (index == 0) {
            return nums[0];
        }

        // Already computed
        if (dp[index] != -1) {
            return dp[index];
        }

        long take;

        // Adjacent houses have same color
        if (colors[index]
                == colors[index - 1]) {

            take =
                nums[index]
                + find(index - 2,
                       nums,
                       colors,
                       dp);
        }
        else {

            take =
                nums[index]
                + find(index - 1,
                       nums,
                       colors,
                       dp);
        }

        long notTake =
            find(index - 1,
                 nums,
                 colors,
                 dp);

        return dp[index] =
            Math.max(take, notTake);
    }
}