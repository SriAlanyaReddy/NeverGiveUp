
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // DP table initialized to -1 for memoization
        int[][] dp = new int[numRows][numRows];
        for (int[] row : dp) Arrays.fill(row, -1);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int c = 0; c <= r; c++) {
                currentRow.add(getValue(r, c, dp));
            }
            result.add(currentRow);
        }
        return result;
    }

    // Recursive function with memoization
    private int getValue(int r, int c, int[][] dp) {
        if (c == 0 || c == r) return 1;               // Base cases
        if (dp[r][c] != -1) return dp[r][c];          // Cached value
        dp[r][c] = getValue(r - 1, c - 1, dp) + getValue(r - 1, c, dp);
        return dp[r][c];
    }

    
}
