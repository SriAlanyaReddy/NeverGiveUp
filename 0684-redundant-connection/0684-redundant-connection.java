class DisjointSet{
   int  parent[];
   int rank[];
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
       for(int i=0;i<n;i++){
         parent[i]=i;
         rank[i]=0;
       }
       
    }
    public int  findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int x,int y){
       int rootx=findparent(x);
        int rooty=findparent(y);
        if(rootx==rooty){
            return false;
        }
        if(rank[rootx]>rank[rooty]){
            parent[rooty]=rootx;
        }
        else if (rank[rootx]<rank[rooty]){
            parent[rootx]=rooty;
        }
        else {
            parent[rooty]=rootx;
            rank[rootx]++;
        }
        return true;
    }

}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet ds=new DisjointSet(n+1);
        int res[]=new int[]{-1,1};
        for(int i=0;i<n;i++){
            int firstx=edges[i][0];
            int secondx=edges[i][1];
            if(!ds.union(firstx,secondx)){
                res[0]=firstx;
                res[1]=secondx;
            }
        }
        return res;
    }
}