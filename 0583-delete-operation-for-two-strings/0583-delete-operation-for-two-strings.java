import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        int lcs = findLCS(word1, word2, 0, 0, dp);
        return (n - lcs) + (m - lcs); // total deletions needed
    }

    private int findLCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + findLCS(s1, s2, i + 1, j + 1, dp);
        } else {
             return dp[i][j] = Math.max(
                findLCS(s1, s2, i + 1, j, dp),
                findLCS(s1, s2, i, j + 1, dp)
            );
        }

       
    }
}
