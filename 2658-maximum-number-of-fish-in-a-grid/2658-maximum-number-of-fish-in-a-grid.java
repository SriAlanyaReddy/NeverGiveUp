class Solution {
    public int bfs(int row,int col,int[][] mat, boolean visited[][]){
        Queue<int[]>q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        q.offer(new int[]{row,col});
     
        visited[row][col]=true;
        int area=0;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!q.isEmpty()){
            int current[]=q.poll();
            int currentrow=current[0];
            int currentcol=current[1];
            area+=mat[currentrow][currentcol];
            
            for(int i=0;i<4;i++){
                int newrow=currentrow+dr[i];
                int newcol=currentcol+dc[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && visited[newrow][newcol]==false && mat[newrow][newcol]!=0){
                    q.offer(new int[]{newrow,newcol});
                    visited[newrow][newcol]=true;

                }

            }


        }
        return area;
    }
    public int findMaxFish(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int maxarea=0;
         boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=0){
                    //if it is water cell then start bfs
                    int area=bfs(i,j,mat,visited);
                    maxarea=Math.max(area,maxarea);
                    
                }

            }
        }
        return maxarea;
    }
}