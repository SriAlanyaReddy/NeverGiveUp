class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        int dp[][]=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return isPossible(dp,n-1,m-1,s,p);
        
    }
    public boolean isPossible(int[][] dp,int i,int j,String s,String p){
        if(i<0 && j<0){
            return true;
        }
        if(i>=0 && j<0){
            return false;
        }
        if(i<0 && j>=0){
            for(int ind=0;ind<=j;ind++){
                if(p.charAt(ind)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;

        boolean match;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
           match= isPossible(dp,i-1,j-1,s,p);
        }
        else if(p.charAt(j)=='*'){
            match=isPossible(dp,i-1,j,s,p)||isPossible(dp,i,j-1,s,p);

        }
        else{
            return false;
        }
        dp[i][j]=match?1:0;
        return match;
    }
}