class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       return Math.min(find(dp, cost, n - 1), find(dp, cost, n - 2));
    }

    public int find(int[] dp,int[] cost,int i){
        if(i==0 || i==1){
            return cost[i];
        }
        if(dp[i]!=-1) return dp[i];
        int onestep=cost[i]+find(dp,cost,i-1);
        int twostep=Integer.MAX_VALUE;
        if(i>=2)
         twostep=cost[i]+find(dp,cost,i-2);
         return dp[i]=Math.min(twostep,onestep);

    }
}