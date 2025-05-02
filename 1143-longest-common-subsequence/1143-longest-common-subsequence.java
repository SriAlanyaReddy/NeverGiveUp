class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int dp[][]=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return lcs(text1,text2,n-1,m-1,dp);
    }
    public int lcs(String text1,String text2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=1+lcs(text1,text2,i-1,j-1,dp);
        }
        else{
            dp[i][j]=Math.max(lcs(text1,text2,i-1,j,dp),lcs(text1,text2,i,j-1,dp));
        }
        return dp[i][j];

    }
}