class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m= word2.length();
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return findMin(word1,word2,0,0,dp);
    }
    public int findMin(String word1,String word2,int idx1,int idx2,int[][] dp){
        if(idx1==word1.length()) return word2.length()-idx2;
         if(idx2==word2.length()) return word1.length()-idx1;
         if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
         if(word1.charAt(idx1)==word2.charAt(idx2)){
            return dp[idx1][idx2]=findMin(word1,word2,idx1+1,idx2+1,dp);
         }
         else{
            int insert=findMin(word1,word2,idx1+1,idx2,dp);
            int delete=findMin(word1,word2,idx1,idx2+1,dp);
            int replace=findMin(word1,word2,idx1+1,idx2+1,dp);
            return dp[idx1][idx2]= 1+Math.min(Math.min(insert,delete),replace);
         }

    }
}