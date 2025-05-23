class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=findchange(n-1,amount,coins,dp);
        return (ans>=(int)1e9-1)?-1:ans;
    }
    public int findchange(int i,int amount,int[] coins,int[][] dp){
        if(i==0){
            if(amount%coins[i]==0) return amount/coins[i];
           return (int)1e9;

        }
       int take = (int)1e9;
        int nottake=findchange(i-1,amount,coins,dp);
        if(coins[i]<=amount){
            take=1+findchange(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount]=Math.min(take,nottake);
    }
}