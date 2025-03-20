class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       List<List<Integer>>adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       }
      for(int[] i:dislikes){
        adj.get(i[0]).add(i[1]);
        adj.get(i[1]).add(i[0]);
      }
      int color[]=new int[n+1];
      Arrays.fill(color,-1);
      for(int i=1;i<=n;i++){
        if(color[i]==-1){
            if(!bfs(i,color,adj,0)){
                return false;
            }
        }
      }
      return true;
    }
    public boolean bfs(int node,int[] color,List<List<Integer>>adj,int c){
        color[node]=c;
        for(int adjnode:adj.get(node)){
            if(color[node]==color[adjnode]){
                return false;
            }
            if (color[adjnode] == -1) {
            if(!bfs(adjnode,color,adj,1-c)){
                return false;
            }
            }
        }
        return true;

    }
}