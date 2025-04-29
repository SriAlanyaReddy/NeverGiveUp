class Solution {
    public int cherryPickup(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
        int dp[][][] = new int[n][m][m];
       

    // Initialize the dp array with -1
    for (int row1[][] : dp) {
      for (int row2[] : row1) {
        Arrays.fill(row2, -1);
      }
    }

    // Call the utility function to find the maximum number of chocolates
    return maxChocoUtil(0, 0, m - 1,grid, dp);
        
    }
    public int maxChocoUtil(int i1,int j1,int j2,int[][] a,int[][][] dp){
        int m=a[0].length;
        int n=a.length;
         if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return -1_000_000_000; // invalid move

        if(i1== n-1){
            if(j1==j2){
                return a[i1][j1];
            }
            else{
                return a[i1][j1]+a[i1][j2];
            }
        }
         if (dp[i1][j1][j2] != -1)
            return dp[i1][j1][j2];

             // Base cases
       
        int max=Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
               int ans=0;
                if(j1==j2){
                    ans+=a[i1][j1]+maxChocoUtil(i1+1,j1+d1,j2+d2,a,dp);
                }
                else{
                    ans+=a[i1][j1]+a[i1][j2]+maxChocoUtil(i1+1,j1+d1,j2+d2,a,dp);
                }
                max=Math.max(ans,max);
            }
        }
        return dp[i1][j1][j2]=max;
    }
}