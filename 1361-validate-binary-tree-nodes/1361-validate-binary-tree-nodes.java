// Disjoint Set (Union-Find) data structure
class DisjointSet {
    int[] parent; // parent[i] = parent of node i
    int[] rank;   // rank[i] = approximate height of tree rooted at i

    // Initialize DSU with n isolated nodes
    DisjointSet(int v) {
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i; // each node is its own parent initially
            rank[i] = 0;   // initial rank is 0
        }
    }

    // Find the root (ultimate parent) of x
    // Uses path compression for efficiency
    public int findparent(int x) {
        if (parent[x] != x) {
            parent[x] = findparent(parent[x]); // compress path
        }
        return parent[x];
    }

    // Union the sets containing x and y
    // Returns false if a cycle is detected
    public boolean Union(int x, int y) {
        int rootx = findparent(x);
        int rooty = findparent(y);

        // If both nodes already share the same root,
        // adding this edge would create a cycle
        if (rootx == rooty) {
            return false;
        }

        // Union by rank to keep tree shallow
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

        // DSU to detect cycles and count connected components
        DisjointSet uf = new DisjointSet(n);

        // hasParent[i] = true if node i already has a parent
        boolean[] hasParent = new boolean[n];

        // Iterate over each node as a parent
        for (int i = 0; i < n; i++) {

            // Check both left and right children
            for (int child : new int[]{leftChild[i], rightChild[i]}) {

                // -1 means no child
                if (child == -1) continue;

                // If child already has a parent,
                // then it violates binary tree property
                if (hasParent[child]) return false;

                // Mark that this child now has a parent
                hasParent[child] = true;

                // Union parent and child
                // If Union returns false, a cycle exists
                if (!uf.Union(i, child)) return false;
            }
        }

        // Count number of roots (nodes whose parent is itself)
        int rc = 0;
        for (int i = 0; i < n; i++) {
            if (uf.parent[i] == i) rc++;

            // A valid binary tree must have exactly one root
            if (rc > 1) return false;
        }

        // Passed all checks → valid binary tree
        return true;
    }
}
