class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // use n+1 for 1-based indexing
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]}); // [target, weight]
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], node = current[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] adjnode : adj.get(node)) {
                int nextnode = adjnode[0]; // ✅ correct: target
                int weight = adjnode[1];   // ✅ correct: weight

                if (dist[nextnode] > time + weight) {
                    dist[nextnode] = time + weight;
                    pq.add(new int[]{dist[nextnode], nextnode});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}

/*class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the adjacency list with int[]: [target, weight]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Initialize distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: PriorityQueue for Dijkstra: [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[nextNode] > time + weight) {
                    dist[nextNode] = time + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        // Step 4: Find the max delay time
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
*/