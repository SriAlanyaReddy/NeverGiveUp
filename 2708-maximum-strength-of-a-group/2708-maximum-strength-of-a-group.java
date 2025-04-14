class Solution {
    private long maxn;

    public long maxStrength(int[] nums) {
        maxn = Long.MIN_VALUE;         // start as small as possible
        dfs(nums, 0, 1L, 0);           // start with product=1, count=0
        return maxn;
    }

  
    private void dfs(int[] a, int ind, long product, int count) {
        // If we've considered every element, update max if we've picked at least one
        if (ind == a.length) {
            if (count > 0) {
                maxn = Math.max(maxn, product);
            }
            return;
        }

        // 1) Exclude a[ind]
        dfs(a, ind + 1, product, count);

        // 2) Include a[ind]
        //    Note: product may overflow if values are huge, but problem constraints usually keep it safe.
        dfs(a, ind + 1, product * a[ind], count + 1);
    }
}
