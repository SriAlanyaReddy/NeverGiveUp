class Solution {
    public int maxUncrossedLines(int[] a1, int[] a2) {
        int n1=a1.length,n2=a2.length;

        int dp[][]=new int[n1][n2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return find(dp,a1,a2,n1-1,n2-1);
    }
    public int find(int[][] dp,int[] a1,int[] a2,int idx1,int idx2){
        if(idx<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        




        if(a1[idx1]==a2[idx2]){
            dp[idx1][idx2]=1+find(dp,a1,a2,idx1-1,idx2-1);
        }
        else{
            dp[idx1][idx2]=Math.max(find(dp,a1,a2,idx1-1,idx2),find(dp,a1,a2,idx1,idx2-1));
        }
        return dp[idx1][idx2];
    }
}