class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int[] row:dp)
        Arrays.fill(row,-1);
        
        int res=find(n-1,amount,coins,dp);
        return res;
    }
    public int find(int ind,int amount,int[] coins,int[][] dp){
        if(ind==0){
            return (amount%coins[0]==0)?1:0;
            
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int take=0;
         int nottake=find(ind-1,amount,coins,dp);
        if(coins[ind]<=amount){
            take=find(ind,amount-coins[ind],coins,dp);
        }
        return dp[ind][amount]=take+nottake;
      
    }
}