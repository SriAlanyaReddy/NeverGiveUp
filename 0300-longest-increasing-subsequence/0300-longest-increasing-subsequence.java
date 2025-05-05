class Solution {
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        int dp[][]=new int[n][n+1];
        for(int[] row:dp)
        Arrays.fill(row,-1);
        return findlength(a,0,-1,dp);
        
    }
    public int findlength(int[] a,int ind,int prevind,int[][] dp){
        if(ind==a.length) return 0;
        if(dp[ind][prevind+1]!=-1) return dp[ind][prevind+1];



        int nottake=findlength(a,ind+1,prevind,dp);
        int take=0;
        if(prevind==-1 || a[ind]>a[prevind]){
            take=1+findlength(a,ind+1,ind,dp);
        }
        return dp[ind][prevind+1]=Math.max(take,nottake);
    }
}