class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int j=0;j<n;j++){
            if(visited[0][j]==false && board[0][j]=='O'){
                dfs(board,0,j,visited);
            }
             if(visited[m-1][j]==false && board[m-1][j]=='O'){
                dfs(board,m-1,j,visited);
            }
        }
        for(int i=0;i<m;i++){
           if(visited[i][0]==false && board[i][0]=='O'){
                dfs(board,i,0,visited);
            }
             if(visited[i][n-1]==false && board[i][n-1]=='O'){
                dfs(board,i,n-1,visited);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
     public void dfs(char[][] board,int row,int col,boolean[][] visited){
        if(row>=board.length || col>=board[0].length || row<0 || col<0 || visited[row][col]==true || board[row][col]=='X'){
            return;
        }
        visited[row][col]=true;
        dfs(board,row+1,col,visited);
        dfs(board,row-1,col,visited);
        dfs(board,row,col+1,visited);
        dfs(board,row,col-1,visited);
    }
        
}