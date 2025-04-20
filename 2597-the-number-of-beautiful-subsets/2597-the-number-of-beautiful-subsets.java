class Solution {
    private Map<Integer, Integer> freq = new HashMap<>();

    private int dfs(int[] nums, int k, int i) {
        if (i == nums.length) return 1;

        int notTake = dfs(nums, k, i + 1); // Skip nums[i]
        int take = 0;

        // Take nums[i] only if nums[i] - k not already taken
        if (!freq.containsKey(nums[i] - k)) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            take = dfs(nums, k, i + 1);
            freq.put(nums[i], freq.get(nums[i]) - 1);
            //if (freq.get(nums[i]) == 0) freq.remove(nums[i]);
        }

        return take + notTake;
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums); // Important to ensure same numbers are grouped
        return dfs(nums, k, 0) - 1; // Exclude empty subset
    }
}
