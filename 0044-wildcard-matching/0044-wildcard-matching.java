class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        int dp[][]=new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
            for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                  boolean match;
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
           match= dp[i-1][j-1]==1;
        }
        else if(p.charAt(j-1)=='*'){
            match=dp[i-1][j]==1||dp[i][j-1]==1;

        }
        else{
            match=false;

        }
        dp[i][j]=match?1:0;
            }
        }
       return dp[n][m]==1;
        
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