class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return findminsteps(n,dp);
    }
    public int findminsteps(int n,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int sq=i*i;
            int steps=1+findminsteps(n-sq,dp);
            min=Math.min(steps,min);

        }
        return dp[n]=min;
    }
}