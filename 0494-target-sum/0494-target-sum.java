class Solution {
    public int findTargetSumWays(int[] a, int target) {
        int sum=0,n=a.length;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        int actualtarget=(sum-target)/2;
        int dp[][]=new int[n][actualtarget+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
          if (sum < target || (sum - target) % 2 != 0) return 0;
        return find(n-1,actualtarget,a,dp);


    }
    public int find(int idx,int target,int[] a,int[][] dp){
        if(idx==0){
            if(target==0 && a[0]==0){
                return 2;
            }
            if(target==a[0] || target==0){
                return 1;
            }
            return 0;

        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int take=0;
        int nottake=find(idx-1,target,a,dp);
        if(a[idx]<=target){
            take=find(idx-1,target-a[idx],a,dp);
        }
        return dp[idx][target]=take+nottake;

    }
}