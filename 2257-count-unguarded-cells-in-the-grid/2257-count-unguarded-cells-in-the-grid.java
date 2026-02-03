class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][]=new int[m][n];
        int[][] dirs ={{0,-1},{-1,0},{0,1},{1,0}}; 
        for(int i=0;i<guards.length;i++){
           int x=guards[i][0];
           int y=guards[i][1];
           grid[x][y]=1;
        }
        for(int[] wall:walls){
            int x=wall[0],y=wall[1];
            grid[x][y]=2;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    if(grid[i][j]==1){
                        dfs(grid,dirs[k][0],dirs[k][1],i+dirs[k][0],j+dirs[k][1]);
                    }
                }
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int[][] grid,int posx,int posy,int x,int y){
        if(x>=grid.length|| x<0|| y>=grid[0].length || y<0 || grid[x][y]==2 || grid[x][y]==1){
            return ;
        }
        grid[x][y]=3;
        dfs(grid,posx,posy,x+posx,y+posy);
    }
    
}