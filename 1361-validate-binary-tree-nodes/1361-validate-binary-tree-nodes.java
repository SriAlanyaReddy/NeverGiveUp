class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int v) {
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findparent(int x) {
        if (parent[x] != x) {
            parent[x] = findparent(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean Union(int x, int y) {
        int rootx = findparent(x);
        int rooty = findparent(y);
        if (rootx == rooty) {
            return false; // Cycle detected
        }

        // Union by rank
        if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else {
            parent[rooty] = rootx;
            rank[rootx]++;
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
            if(uf.parent[i]==i)rc++;
            if(rc>1)return false;
        }
        return true;
    }
}