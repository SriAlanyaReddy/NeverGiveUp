class Solution {
    public int numberOfWays(int n, int x) {
       int base=1,maxbase=1;
       //we newed to find max base
       while(Math.pow(maxbase,x)<=n){
        maxbase++;
       }
       int dp[][]=new int[maxbase+1][n+1];
       for(int[] row:dp){
        Arrays.fill(row,-1);
       }
       return findways(1,n,x,dp);
        
    }
    public int findways(int base,int target,int x,int[][] dp){
        if(target==0){
            return 1;


        }
        if(Math.pow(base,x)>target) return 0;
        if(dp[base][target]!=-1) return dp[base][target];


        int nottake=findways(base+1,target,x,dp);
        int val=(int)Math.pow(base,x);
        int take=0;
        if(val<=target){
            take=findways(base+1,target-val,x,dp);
        }
        return dp[base][target]=take+nottake;
    }
}