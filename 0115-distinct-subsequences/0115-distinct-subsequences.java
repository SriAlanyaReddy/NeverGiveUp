class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();

        int dp[][]=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return finddistinct(s,t,n,m,dp);
    }
    public int finddistinct(String s,String t,int ind1,int ind2,int[][] dp){
        if(ind2==0){
            return 1;
        }
        if(ind1==0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s.charAt(ind1-1)==t.charAt(ind2-1)){
            dp[ind1][ind2]=finddistinct(s,t,ind1-1,ind2-1,dp)+finddistinct(s,t,ind1-1,ind2,dp);
        }
        else{
            dp[ind1][ind2]=finddistinct(s,t,ind1-1,ind2,dp);
        }
        return dp[ind1][ind2];
    }
}