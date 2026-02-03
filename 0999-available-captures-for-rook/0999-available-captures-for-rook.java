class Solution {
    public int numRookCaptures(char[][] board) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    return dfs(board,i,j);
                }
            }
        }
        return 0;
    }
      private int dfs(char[][] board,int row,int col){
        int c=0;
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='P'){
                c++;
                break;
            }
            else if(board[i][col]=='B'){
                break;
            }
        }
        for(int i=row+1;i<8;i++){
            if(board[i][col]=='P'){
                c++;
                break;
            }
            else if(board[i][col]=='B'){
                break;
            }
        }
        for(int j=col+1;j<8;j++){
            if(board[row][j]=='P'){
                c++;
                break;
            }
            else if(board[row][j]=='B'){
                break;
            }
        }
        for(int j=col-1;j>=0;j--){
            if(board[row][j]=='P'){
                c++;
                break;
            }
            else if(board[row][j]=='B'){
                break;
            }
        }
      
      return c;
    }
}