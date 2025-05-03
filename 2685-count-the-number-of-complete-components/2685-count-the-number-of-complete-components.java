class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findparent(int x) {
        if (parent[x] != x) {
            parent[x] = findparent(parent[x]);  // Path compression
        }
        return parent[x];
    }

    public boolean Union(int x, int y) {
        int rootx = findparent(x);
        int rooty = findparent(y);
        if (rootx == rooty) return false;

        if (size[rootx] > size[rooty]) {
            parent[rooty] = rootx;
            size[rootx]+=size[rooty];
        } else {
            parent[rootx] = rooty;
            size[rooty]+=size[rootx];
        } 
        return true;
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet dsu=new DisjointSet(n);
        for(int []row:edges){
            dsu.Union(row[0],row[1]);
        }
        HashMap<Integer,Integer>edgecount=new HashMap<>();
        for(int[] e:edges){
            int parent=dsu.findparent(e[0]);
            edgecount.put(parent,edgecount.getOrDefault(parent,0)+1);
        }
        int completecount=0;
        for(int i=0;i<n;i++){
            if(dsu.findparent(i)==i){
            int nodecount=dsu.size[i];
            int numberofedges=edgecount.get(i);
            if(numberofedges==nodecount*(nodecount-1)/2){
                completecount++;
            }
            }
        }
        return completecount;
    }
}