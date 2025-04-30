class DisjointSet{
    int parent[];
    int rank[];
    DisjointSet(int v){
        parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
        }
    }
    public int findparent(int x){
    if(parent[x]!=x){
        parent[x]=findparent(parent[x]);
    }
    return parent[x];
}
public boolean Union(int x,int y){
    int rootx=findparent(x);
    int rooty=findparent(y);
    if(rootx==rooty){
        return false;
    }
    else if(rootx>rooty){
        parent[rootx]=rooty;
    }
    else{
        parent[rooty]=rootx;
    }
    return true;
}
}

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DisjointSet uf=new DisjointSet(n);
        boolean hasParent[]=new boolean[n];
        for(int i=0;i<n;i++){
            for(int child:new int[]{leftChild[i],rightChild[i]}){
                if(child==-1)continue;
                if(hasParent[child]==true) return false;
                hasParent[child]=true;
                if(!uf.Union(i,child)) return false;
            }
        }
        int rc=0;
        for(int i=0;i<n;i++){
            if(!hasParent[i])rc++;
            if(rc>1)return false;
        }
        return true;
    }
}