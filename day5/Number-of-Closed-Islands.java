class Solution {
    public int closedIsland(int[][] a) {
        int c=0;
        int n=a.length;
        int m=a[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0 &&(i==0 || i==n-1 || j==m-1 || j==0)){
                    dfs(i,j,visited,a);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && a[i][j]==0){
                    c++;
                    dfs(i,j,visited,a);
                }
            }
        }
        return c;
    }
        public void dfs(int i,int j,boolean[][] visited,int a[][]){
            int n=a.length;
            int m=a[0].length;
            if( i<0 || j<0 || i>=n || j>=m || a[i][j]==1 ||visited[i][j]==true){
                return;
            }
            visited[i][j]=true;
            dfs(i+1,j,visited,a);
            dfs(i-1,j,visited,a);
            dfs(i,j-1,visited,a);
            dfs(i,j+1,visited,a);
        }
        
    
}