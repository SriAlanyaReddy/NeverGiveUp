import java.util.*;

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

    public void union(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV) return;

        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSet ds = new DisjointSet(2 * n);
        
        for (int[] stone : stones) {
            ds.union(stone[0], stone[1] + n); // Map columns to avoid overlap
        }

        Set<Integer> uniqueParents = new HashSet<>();
        for (int[] stone : stones) {
            uniqueParents.add(ds.findParent(stone[0]));
            uniqueParents.add(ds.findParent(stone[1] + n));
        }

        return n - uniqueParents.size();
    }
}
