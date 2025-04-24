class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        // If the starting or ending point is an obstacle, return 0
        if (a[0][0] == 1 || a[n - 1][m - 1] == 1) return 0;

        int dp[][] = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize dp with -1
        }

        return findways(dp, n - 1, m - 1, a);
    }
    public int findways(int[][] dp,int i,int j,int[][] a){
        if(i==0 && j==0) return 1;
        if((i<0 || j<0) || a[i][j]==1 ) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int top=findways(dp,i,j-1,a);
        int left=findways(dp,i-1,j,a);
        return dp[i][j]=top+left;
    }
}