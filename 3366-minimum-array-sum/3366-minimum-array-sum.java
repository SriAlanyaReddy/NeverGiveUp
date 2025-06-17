class Solution {
    public int minArraySum(int[] a, int k, int op1, int op2) {
        int n=a.length;
        int dp[][][]=new int[n][op1+1][op2+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=op1;j++)
            Arrays.fill(dp[i][j],-1);
        }
        return find(a,k,op1,op2,dp,n-1);
        
    }
    public int find(int[] a,int k,int op1,int op2,int[][][] dp,int idx){
        if(idx<0){
            return 0;

        }
        if(dp[idx][op1][op2]!=-1){
            return dp[idx][op1][op2];
        }
        int ans=Integer.MAX_VALUE;
        if(op1!=0){
            int rounded=((int)Math.ceil(a[idx]/2.00));
            int firstop1=rounded+find(a,k,op1-1,op2,dp,idx-1);
            ans=Math.min(ans,firstop1);
        }
        if(op2!=0 && a[idx]<=k){
            int firstop2=a[idx]-k+find(a,k,op1,op2-1,dp,idx-1);
            ans=Math.min(ans,firstop2);
        }
        if(op1!=0 && op2!=0){
            int afterop1=(int)Math.ceil(a[idx]/2.00);
            if(afterop1>=k){
                int sumop1op2=afterop1-k+find(a,k,op1-1,op2-1,dp,idx-1);
                ans=Math.min(ans,sumop1op2);
            }
            if(a[idx]>=k){
                int sumop2op1=((int)Math.ceil((a[idx]-k)/2.00))+find(a,k,op1-1,op2-1,dp,idx-1);
                ans=Math.min(ans,sumop2op1);
            }

        }
        int no_oper=a[idx]+find(a,k,op1,op2,dp,idx-1);
        ans=Math.min(no_oper,ans);
        dp[idx][op1][op2]=ans;
        return ans;

    }
}