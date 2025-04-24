class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return findways(dp,m-1,n-1);
    }
    public int findways(int[] [] dp,int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int top=findways(dp,i,j-1);
        int left=findways(dp,i-1,j);
        return dp[i][j]=top+left;
    }
}