class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int ans[][]=new int[rows*cols][2];
         int index=0;
         ans[index++]=new int[]{rStart,cStart};
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int moves=0,d=0;
       int r=rStart,c=cStart;
         while(index<rows*cols){
            if(d%2==0){
                moves++;
            }
            for(int i=0;i<moves;i++){
                r=r+dir[d][0];
                c=c+dir[d][1];
                if(r<rows && c<cols && r>=0 && c>=0){
                   ans[index++]=new int[]{r,c};
                  
                }
            }
            d=(d+1)%4;
         }
         return ans;
    }
}