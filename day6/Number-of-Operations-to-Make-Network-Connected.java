class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if(rootU==rootV){
            return false;
        }
        
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        return true;
    }
}

class Solution {
   
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int redundantedges=0;
        for(int i=0;i<connections.length;i++){
            int firstnode=connections[i][0];
            int secondnode=connections[i][1];
            if(!ds.union(firstnode,secondnode)){
                redundantedges++;
            }
           
        }
        int connectedcomponents=0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i){
                connectedcomponents++;
            }
        }//intutuition is basically to we require if there are n connected componets we require n-1 eges to connect it
        //we calcualte connected componets && calculate redundant egdes
        if(redundantedges>=connectedcomponents-1){
            return connectedcomponents-1;
        }
        return -1;
    }
}