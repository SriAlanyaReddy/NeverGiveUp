class DSU{
    int parent[];
    int rank[];
    DSU(int n){
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
    public boolean union(int u,int v){
        int rootu=findparent(u);
        int rootv=findparent(v);
       if (rank[rootu] > rank[rootv]) {
            parent[rootv] = rootu;
        } else if (rank[rootu] < rank[rootv]) {
            parent[rootu] = rootv;
        } else {
            parent[rootv] = rootu;
            rank[rootu]++;
        }
        
        return true;
    }
}
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {      Set<Integer>res=new HashSet<>();
    for(int i:restricted){
        res.add(i);
    }
       DSU ds=new DSU( n);
       for(int i=0;i<edges.length;i++){
        if(res.contains(edges[i][0]) || res.contains(edges[i][1])){
            continue;
        }
        else{
            ds.union(edges[i][0],edges[i][1]);
        }
       }
int c=0;
    for(int i=0;i<n;i++){
        if(ds.parent[i]==ds.parent[0] && !res.contains(i)){
            c++;
        }
    }
    return c;
    }
}