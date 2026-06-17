class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
     int m=mat.length;
     int n=mat[0].length;
     int dp[][]=new int[m][n];
     for(int[] a:dp){
        Arrays.fill(a,-1);
     }
     return find(m-1,n-1,dp,mat);

    }
    public int find(int i,int j,int[][] dp,int[][] a){
        if(i<0 || j<0 || a[i][j]==1) {
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int val=find(i-1,j,dp,a)+find(i,j-1,dp,a);
        return dp[i][j]=val;

    }
}