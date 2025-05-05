class Solution {
    public int findNumberOfLIS(int[] a) {
        int n=a.length;
        int cnt[]=new int[n];
        Arrays.fill(cnt,1);
        int maxi=1;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    cnt[i]=cnt[j];
                }
                else if(a[i]>a[j] && 1+dp[j]==dp[i]){
                    cnt[i]+=cnt[j];

                }
            }
            max=Math.max(dp[i],max);
        }
        int tc=0;
        for(int i=0;i<n;i++){
           if(dp[i]==max){
            tc+=cnt[i];
           }
        }
        return tc;
        
    }
}