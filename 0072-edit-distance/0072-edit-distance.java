class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
              if (word1.charAt(i-1) == word2.charAt(j-1)) {
            dp[i][j] = dp[i - 1][j - 1];
        } else {
            int insert = dp[i][j - 1];
            int delete = dp[i-1][j];
            int replace =dp[i-1][j - 1];
            dp[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
        }
            }
        }

        return dp[n][m];
    }

    public int findMin(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0) return j ;  // If word1 is empty, insert all of word2[0...j]
        if (j == 0) return i;  // If word2 is empty, delete all of word1[0...i]
        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i-1) == word2.charAt(j-1)) {
            return dp[i][j] = findMin(word1, word2, i - 1, j - 1, dp);
        } else {
            int insert = findMin(word1, word2, i, j - 1, dp);
            int delete = findMin(word1, word2, i - 1, j, dp);
            int replace = findMin(word1, word2, i - 1, j - 1, dp);
            return dp[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
        }
    }
}
