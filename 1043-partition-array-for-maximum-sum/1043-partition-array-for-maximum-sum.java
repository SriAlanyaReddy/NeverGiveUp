class Solution {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return find(a,k,dp,0);

        
    }
    public int find(int[] a,int k,int[] dp,int i){
        int n=a.length;
        if(i==n){
            return 0;
        }
        int len=0,maxi=Integer.MIN_VALUE,maxsum=Integer.MIN_VALUE;
        for(int ind=i;ind<Math.min(n,i+k);ind++){
            len++;
            maxi=Math.max(maxi,a[ind]);
            int sum=(len*maxi)+find(a,k,dp,ind+1);
            maxsum=Math.max(maxsum,sum);
        }
        return dp[i]=maxsum;
    }
}