class DisjointSet{
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
}