class Solution {

    public int findTheCity(int n,
                           int[][] edges,
                           int distanceThreshold) {

        int INF = (int)1e9;

        // Distance matrix
        int[][] dist = new int[n][n];

        // Initially set all distances as INF
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                dist[i][j] = INF;
            }

            // Distance from node to itself = 0
            dist[i][i] = 0;
        }

        // Fill given edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt; // Undirected graph
        }

        // Floyd Warshall
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    dist[i][j] =
                            Math.min(
                                    dist[i][j],
                                    dist[i][via]
                                    + dist[via][j]
                            );
                }
            }
        }

        int cityAnswer = -1;

        int minimumReachableCities = Integer.MAX_VALUE;

        // Check every city
        for (int city = 0; city < n; city++) {

            int reachableCities = 0;

            // Count cities reachable
            // within threshold distance
            for (int neighbour = 0;
                 neighbour < n;
                 neighbour++) {

                if (dist[city][neighbour]
                        <= distanceThreshold) {

                    reachableCities++;
                }
            }

            // If smaller count found
            // OR same count but larger city number
            if (reachableCities
                    <= minimumReachableCities) {

                minimumReachableCities =
                        reachableCities;

                cityAnswer = city;
            }
        }

        return cityAnswer;
    }
}