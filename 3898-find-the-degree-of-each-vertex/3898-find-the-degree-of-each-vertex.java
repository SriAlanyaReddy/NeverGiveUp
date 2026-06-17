class Solution {
    public int[] findDegrees(int[][] mat) {
        int n=mat.length;
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                c=c+mat[i][j];
            }
            ans[i]=c;
        }
        return ans;
    }
}