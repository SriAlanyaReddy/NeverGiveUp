class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int [] row:dp)
{
    Arrays.fill(row,-1);
}        return findminpath(dp,grid,n-1,m-1);
    }
    public int findminpath(int[][] dp,int[][] grid,int i,int j)
{
    if(i==0 && j==0){
        return grid[i][j];
    }
    if(i<0 || j<0 ){
        return Integer.MAX_VALUE;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    return dp[i][j]=grid[i][j]+ Math.min(findminpath(dp,grid,i,j-1),findminpath(dp,grid,i-1,j));
}}