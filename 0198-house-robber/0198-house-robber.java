class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return find(nums, dp, n - 1);
    }

    public int find(int[] nums,
                    int[] dp,
                    int index) {

        if(index < 0){
            return 0;
        }

        if(index == 0){
            return nums[0];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick =
                nums[index]
                + find(nums, dp, index - 2);

        int notPick =
                find(nums, dp, index - 1);

        return dp[index] =
                Math.max(pick, notPick);
    }
}