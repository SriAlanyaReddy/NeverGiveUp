class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = find(dp, s, 0);
        return ans >= (int) 1e9 ? -1 : ans;
    }

    public int find(int[] dp, String s, int i) { // FIXED here
        int n = s.length();
        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int minPartitions = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            if (isBeautiful(s, i, k)) {
                int count = 1 + find(dp, s, k + 1);
                minPartitions = Math.min(count, minPartitions);
            }
        }
        return dp[i] = minPartitions;
    }

    public boolean isBeautiful(String s, int start, int end) {
        if (s.charAt(start) == '0') return false;

        try {
            int n = Integer.parseInt(s.substring(start, end + 1));
            return isPowerOfFive(n);
        } catch (NumberFormatException e) {
            return false; // for very long binary strings
        }
    }

    public boolean isPowerOfFive(int n) {
        if (n == 1) return true;
        if (n % 5 != 0) return false;
        return isPowerOfFive(n / 5);
    }
}
