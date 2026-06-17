class Solution {

    public int findCircleNum(int[][] g) {

        int n = g.length;
        boolean[] vis = new boolean[n];

        int provinces = 0;

        for(int i = 0; i < n; i++) {

            if(!vis[i]) {
                provinces++;
                dfs(g, vis, i);
            }
        }

        return provinces;
    }

    public void dfs(int[][] g, boolean[] vis, int node) {

        vis[node] = true;

        for(int adj = 0; adj < g.length; adj++) {

            if(g[node][adj] == 1 && !vis[adj]) {
                dfs(g, vis, adj);
            }
        }
    }
}