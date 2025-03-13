import java.util.HashSet;

class DisjointSet {
    int parent[];
    int rank[];

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Initially, each node is its own parent
            rank[i] = 0;    // Initial rank is 0
        }
    }

    public int findparent(int x) {
        if (parent[x] != x) {
            parent[x] = findparent(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootx = findparent(x);
        int rooty = findparent(y);
        
        if (rootx == rooty) return; // Already connected

        if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rooty] = rootx;
            rank[rootx]++;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        // Process connections
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.union(i, j);
                }
            }
        }

        // Count unique province roots
       int c=0;
        for (int i = 0; i < n; i++) {
            if(ds.findparent(i)==i){
                c++;
            }
        }

        return c;
    }
}
