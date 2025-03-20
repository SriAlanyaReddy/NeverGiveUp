class Solution {
    public int regionsBySlashes(String[] grid) {
        //main intuition is to represent in in 3*3 matrices where every forward slash is represented by putting i,j+2,i+1,j+1,i+2,j in evry 3 *3 matrix & put backwrd slsh in digaonal i+1,j+1,i+2,j+2,i+3,j+3 & put seros in matrix fidn number number of connected zero components
        int size=grid.length;
        int mat[][]=new int[size*3][size*3];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[i].charAt(j)=='/'){
                    mat[i*3][j*3+2]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    mat[i*3][j*3]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3+2]=1;
                }
            }
        }
        boolean visited[][]=new boolean[size*3][size*3];
        int c=0;
        for(int i=0;i<size*3;i++){
            for(int j=0;j<size*3;j++){
                if(visited[i][j]==false && mat[i][j]==0){
                    c++;
                    dfs(i,j,visited,mat);
                }
            }
        }
        return c;
    }
    public void dfs(int i,int j,boolean visited[][],int[][] m){
        int m1=m.length;
        int n=m[0].length;

        if(i<0 || j<0 || i>=m1 || j>=n || visited[i][j]==true || m[i][j]==1){
            return ;
        }
        visited[i][j]=true;
        dfs(i+1,j,visited,m);
        dfs(i,j+1,visited,m);
        dfs(i,j-1,visited,m);
        dfs(i-1,j,visited,m);
    }
}