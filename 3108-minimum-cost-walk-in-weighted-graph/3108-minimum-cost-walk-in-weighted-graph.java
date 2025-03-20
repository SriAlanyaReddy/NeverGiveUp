class DisjointSet{
    int parent[];
    int rank[];
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
   public int findparent(int u){
    if(parent[u]!=u){
        parent[u]=findparent(parent[u]);
    }
    return parent[u];
   }
   public void Union(int u,int v){
    int rootu=findparent(u);
    int rootv=findparent(v);
    if(rank[rootu]>rank[rootv]){
        parent[rootu]=rootv;
    }
    else if (rank[rootv]>rank[u]){
        parent[rootv]=rootu;
    }
    else{
        parent[rootv]=rootu;
        rank[rootu]++;

    }
   }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds=new DisjointSet(n);
        HashMap<Integer,Integer>componentweights=new HashMap<>();
        int m=edges.length;
        for(int i=0;i<m;i++){
            int first=edges[i][0];
            int second=edges[i][1];
            int wt=edges[i][1];
            ds.Union(first,second);
           

        }
        for(int i=0;i<m;i++){
            int root=ds.findparent(edges[i][0]);
            if(!componentweights.containsKey(root)){
                componentweights.put(root,edges[i][2]);
            }
            else{
                componentweights.put(root,componentweights.get(root)&edges[i][2]);
            }
        }
        int res[]=new int[query.length];
        int i=0;
        for(int[] q:query){
            int root1=ds.findparent(q[0]);
            int root2=ds.findparent(q[1]);
            if(root1!=root2){
                res[i]=-1;
            }
            else{
                res[i]=componentweights.get(root1);
            }
            i++;
        }
        return res;
    }
}