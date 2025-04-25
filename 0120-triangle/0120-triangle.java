class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int dp[][]=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return findpath(dp,0,0,triangle);
    }
    public int findpath(int[][] dp,int currentrow,int currentcol,List<List<Integer>>triangle){
        int n=triangle.size();
        if(currentrow==n-1){
            return triangle.get(currentrow).get(currentcol);
        }
        if(dp[currentrow][currentcol]!=-1){
            return dp[currentrow][currentcol];
        }
        int onestep=triangle.get(currentrow).get(currentcol)+findpath(dp,currentrow+1,currentcol,triangle);
        int twostep=triangle.get(currentrow).get(currentcol)+findpath(dp,currentrow+1,currentcol+1,triangle);
        return dp[currentrow][currentcol]=Math.min(onestep,twostep);
    }
}