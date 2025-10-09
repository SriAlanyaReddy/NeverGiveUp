class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return find(len, dp, strs, m, n);
    }

    public int countOnes(String s) {
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') c++;
        }
        return c;
    }

    public int find(int ind, int[][][] dp, String[] s, int m, int n) {
        if (ind == 0) return 0;
        if (dp[ind][m][n] != -1) return dp[ind][m][n];

        int ones = countOnes(s[ind - 1]);
        int zeros = s[ind - 1].length() - ones;

        int skip = find(ind - 1, dp, s, m, n);
        int take = 0;

        if (m >= zeros && n >= ones) {
            take = 1 + find(ind - 1, dp, s, m - zeros, n - ones);
        }

        return dp[ind][m][n] = Math.max(skip, take);
    }
}
