class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
  
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(find(dp, s1, s2, n1 - 1, n2 - 1));
    }

    public static int find(int[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 < 0 && i2 < 0) return 0;
        if (i1 < 0) {
            int sum = 0;
            for (int k = 0; k <= i2; k++) sum += s2.charAt(k); // ✅ fix here
            return sum;
        }
        if (i2 < 0) {
            int sum = 0;
            for (int k = 0; k <= i1; k++) sum += s1.charAt(k); // ✅ fix here
            return sum;
        }
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = find(dp, s1, s2, i1 - 1, i2 - 1);
        } else {
            dp[i1][i2] = Math.min(
                s1.charAt(i1) + find(dp, s1, s2, i1 - 1, i2),
                s2.charAt(i2) + find(dp, s1, s2, i1, i2 - 1)
            );
        }
        return dp[i1][i2];
    }
}
