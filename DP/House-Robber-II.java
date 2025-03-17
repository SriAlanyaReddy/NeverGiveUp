class Solution {
    public int findmax(int[] a, int start, int end) {
        int prev = 0;
        int prev2 = 0;
         int  curr=Integer.MIN_VALUE;
        // Correct initialization
        for (int i = start; i <= end; i++) {
            int take = a[i] + prev2;
            int nottake = prev;
          curr = Math.max(take, nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] a) {
        int n = a.length;
        if (n == 1) return a[0];  // Edge case
        return Math.max(findmax(a, 0, n - 2), findmax(a, 1, n - 1));
    }
}
