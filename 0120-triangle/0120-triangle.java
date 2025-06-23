class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // We use dp[i][j] to store the minimum path sum from position (i, j) to the bottom
        int[][] dp = new int[n][n];
        
        // Initialize with -1 meaning not computed
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findPath(0, 0, triangle, dp);  // Start from the top (0,0)
    }

    public int findPath(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();

        // Base case: if we're on the last row, return the value itself
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        // If already computed, return from dp table
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move to the row below: either same column (j) or next column (j+1)
        int down = triangle.get(i).get(j) + findPath(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + findPath(i + 1, j + 1, triangle, dp);

        // Store the minimum of both in dp table
        return dp[i][j] = Math.min(down, diagonal);
    }
}
