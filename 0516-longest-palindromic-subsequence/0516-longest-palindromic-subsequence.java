class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        int dp[][]=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findlongestpalindrome(s,rev,n-1,n-1,dp);
    }
    public int findlongestpalindrome(String s,String rev,int ind1,int ind2,int[][] dp){
        if(ind1<0 || ind2<0){
            return 0;
        }
       
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1)==rev.charAt(ind2)){
            dp[ind1][ind2]=1+findlongestpalindrome(s,rev,ind1-1,ind2-1,dp);
        }
        else{
             dp[ind1][ind2]=Math.max(findlongestpalindrome(s,rev,ind1,ind2-1,dp),findlongestpalindrome(s,rev,ind1-1,ind2,dp));

        }
        return dp[ind1][ind2];
    }
   
}