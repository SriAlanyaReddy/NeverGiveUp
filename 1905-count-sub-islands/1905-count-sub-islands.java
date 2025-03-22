class Solution {
    public boolean isLand(int[][] g,int i,int j){
        return g[i][j]==1;
    }
    public boolean isSubland(int[][] grid1,int[][] grid2,int r,int c,boolean[][] visited){
        int n2=grid2.length;
        int m2=grid2[0].length;
        Queue<int[]>q=new LinkedList<>();
      
        q.offer(new int[]{r,c});
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        boolean Subland=true;
        visited[r][c]=true;
        while(!q.isEmpty()){
            int current[]=q.poll();
            int row=current[0];
            int col=current[1];
            if(isLand(grid1,row,col)==false){
                Subland=false;
            }

            for(int i=0;i<4;i++){
                int newrow=row+dr[i];
                int newcol=col+dc[i];
                if(newrow>=0 && newrow<n2 && newcol>=0 && newcol<m2 && isLand(grid2,newrow,newcol) && visited[newrow][newcol]==false){
                    q.offer(new int[]{newrow,newcol});
                    visited[newrow][newcol]=true;

                }
            }
        }
        return Subland;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n2=grid2.length;
        int m2=grid2[0].length;
        int c=0;
          boolean visited[][]=new boolean[n2][m2];
        for(int i=0;i<n2;i++){
            for(int j=0;j<m2;j++){
                if(isLand(grid2,i,j) && visited[i][j]==false && isSubland(grid1,grid2,i,j,visited)){
                    c++;
                }
            }
        }
        return c;
    }
}