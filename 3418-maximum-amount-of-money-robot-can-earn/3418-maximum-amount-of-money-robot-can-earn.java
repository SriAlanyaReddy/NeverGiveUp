class Solution {
    public int maximumAmount(int[][] coins) {
        int n=coins.length,m=coins[0].length;
        Integer[][][] dp=new Integer[n][m][3];
        return solve(n-1,m-1,2,dp,coins);
        
        
    }
    public int solve(int i,int j,int k,Integer[][][] dp,int[][] coins){
        if(i<0 || j<0){
            return Integer.MIN_VALUE;
        }
        if(i==0 && j==0){
            if(coins[i][j]<0 && k>0){
                return 0;
            }
            return coins[i][j];
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        int down=solve(i-1,j,k,dp,coins);
        int right=solve(i,j-1,k,dp,coins);
        int take=coins[i][j]+Math.max(down,right);
        int nottake=Integer.MIN_VALUE;
        if(coins[i][j]<0 && k<0){
            int skipdown=solve(i-1,j,k-1,dp,coins);
            int skipright=solve(i,j-1,k-1,dp,coins);
            nottake=Math.max(skipdown,skipright);
        }
        return dp[i][j][k]=Math.max(take,nottake);
    }
}