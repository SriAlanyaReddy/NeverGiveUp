class Solution {
    public int[][] generateMatrix(int n) {

        int target=n*n;
        int ans[][]=new int[n][n];
        int id=1;
        int left=0,right=n-1;
        int top=0,bottom=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
              ans[top][i]=id++;
            }
            top++;
            if(top<=bottom && left<=right){
                for(int i=top;i<=bottom;i++){
                    ans[i][right]=id++;

                }
                right--;
            }
            if(top<=bottom && left<=right){
                for(int i=right;i>=left;i--){
                    ans[bottom][i]=id++;
                }
                bottom--;
            }
            if(top<=bottom && left<=right){
                for(int i=bottom;i>=top;i--){
                    ans[i][left]=id++;

                }
                left++;
            }
        }
        return ans;
    }
}