class DisjointSet {
    int parent[];
    int rank[];

    DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findparent(int u) {
        if (parent[u] != u) {
            parent[u] = findparent(parent[u]);
        }
        return parent[u];
    }

    public boolean Union(int u, int v) {
        int rootu = findparent(u);
        int rootv = findparent(v);

        if (rootu == rootv) {
            return false; // Cycle detected
        }

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
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] edge1 = null, edge2 = null;

        // Step 1: Identify if a node has two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != 0) { // Node already has a parent (2 parents found)
                edge1 = new int[]{parent[v], v}; // First parent edge
                edge2 = new int[]{u, v};         // Second parent edge
                edge[1] = 0; // Temporarily remove edge2
            }
            parent[v] = u;
        }

        // Step 2: Run Union-Find to check for cycle
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip removed edge

            if (!ds.Union(edge[0], edge[1])) {
                if (edge1 == null) return edge; // No multiple parents, return cycle-causing edge
                return edge1; // Cycle found, return first parent’s edge
            }
        }

        return edge2; // No cycle found, return the second parent’s edge
    }
}
