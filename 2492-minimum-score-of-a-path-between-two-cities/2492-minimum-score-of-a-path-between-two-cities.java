/*class DisjointSet{
    int parent[],rank[];
    DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }

    }
    public int findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }
    public void Union(int x,int y){
        int xPar=findparent(x);
        int yPar=findparent(y);
         if(xPar == yPar){
            return;
        }
        else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
        }
        else if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar;
        }
        else{
            parent[yPar] = xPar;
            rank[xPar]++;
        }

    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        DisjointSet dsu=new DisjointSet(n);
        int minpath=Integer.MAX_VALUE;
        for(int[] row:roads){
            dsu.Union(row[0],row[1]);
        }
      int xpar = dsu.findparent(1);  // ✅ correct

        for(int[] row:roads){
            int ypar = dsu.findparent(row[1]);  // ✅ correct

            if(ypar==xpar){
                minpath=Math.min(minpath,row[2]);
            }

        }
        return minpath;
        
    }
}*/
class Solution {
    public int minScore(int n, int[][] roads) {
        boolean visited[]=new boolean[n+1];
        List<List<int[]>>adj=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            adj.get(road[0]).add(new int[]{road[1],road[2]});
            adj.get(road[1]).add(new int[]{road[0],road[2]});
        }
        int[] minpath=new int[1];
        dfs(1,adj,visited,minpath);
        return minpath[0];
        
    }
    public void dfs(int source,List<List<int[]>>adj,boolean[] visited,int[] minpath){
        visited[source]=true;
        for(int[] neighbor:adj.get(source)){
            int next = neighbor[0];
            int dist = neighbor[1];

            // Update min score
            minpath[0] = Math.min(minpath[0], dist);
            if(visited[next]==false){
                dfs(next,adj,visited,minpath);
            }

        }
    }
}