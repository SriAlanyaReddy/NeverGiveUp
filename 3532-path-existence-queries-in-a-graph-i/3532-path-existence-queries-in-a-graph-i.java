class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
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

        if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rootx] = rooty;
            rank[rooty]++;
        }
        return true;
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] a, int maxDiff, int[][] queries) {
        DisjointSet dsu = new DisjointSet(n);

        // Build graph connections
        for (int i = 0; i < n-1; i++) {
           
                if (Math.abs(a[i+1] - a[i]) <= maxDiff) {
                    dsu.Union(i, i+1);
                }
            
        }

        // Answer queries
        boolean[] isPath = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            isPath[i] = (dsu.findparent(u) == dsu.findparent(v));
        }

        return isPath;
    }
}
