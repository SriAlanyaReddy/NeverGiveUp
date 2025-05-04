class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        String rev=new StringBuilder(s).reverse().toString();
        for(int i=0;i<=n;i++){
             Arrays.fill(dp[i],-1);
        }
        return lcs(n,n,s,rev,dp);
    }
    public int lcs(int i,int j,String s,String rev,int[][] dp){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i-1)==rev.charAt(j-1)){
            return dp[i][j]=1+lcs(i-1,j-1,s,rev,dp);
        }
        return dp[i][j]=Math.max(lcs(i-1,j,s,rev,dp),lcs(i,j-1,s,rev,dp));
    }
}