class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
  
        int n = nums.length;
        int[] dp = new int[n];          // dp[i] = length of LIS ending at i
        int[] prev = new int[n];        // to reconstruct the sequence
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        Arrays.sort(nums);

        int maxLength = 1, lastIndex = 0;

        // Build dp and prev arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j]==0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct LIS from prev[]
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(nums[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        Collections.reverse(lis);
        return lis;
    }

   
}
