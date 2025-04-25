class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int dp[][]=new int[n][m];
        //for(int[] row:dp) Arrays.fill(row,-1);
        for(int j=0;j<m;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        //start from bootom 2nd row
        for(int currrow=n-2;currrow>=0;currrow--){
            for(int curcol=0;curcol<=currrow;curcol++){
                  int onestep=triangle.get(currrow).get(curcol)+dp[currrow+1][curcol];

         int twostep=triangle.get(currrow).get(curcol)+dp[currrow+1][curcol+1];
        dp[currrow][curcol]=Math.min(onestep,twostep);
            }
        }
        //return findpath(dp,0,0,triangle);
        return dp[0][0];
    }
    
}