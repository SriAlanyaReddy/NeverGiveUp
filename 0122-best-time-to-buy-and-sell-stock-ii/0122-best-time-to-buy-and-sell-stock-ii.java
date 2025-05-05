class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int buy=1;
        return findmaxprofit(prices,0,buy,dp);
    }
    public int findmaxprofit(int[] prices,int ind,int buy,int[][] dp){
        int n=prices.length;
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit;
        if(buy==1){
            int take=-prices[ind]+findmaxprofit(prices,ind+1,0,dp);
             int nottake=findmaxprofit(prices,ind+1,1,dp);
             profit=Math.max(take,nottake);
        }
        else{
            int take=prices[ind]+findmaxprofit(prices,ind+1,1,dp);
            int nottake=findmaxprofit(prices,ind+1,0,dp);
             profit=Math.max(take,nottake);

        }
        return dp[ind][buy]=profit;
    }
}