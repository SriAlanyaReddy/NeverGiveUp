class DSU {
    private List<Integer> parents;
    private List<Integer> ranks;

    public DSU(int nodes) {
        this.parents = new ArrayList<>();
        this.ranks = new ArrayList<>(Collections.nCopies(nodes, 1));
        for(int i=0;i<nodes;i++) parents.add(i);
    }

    int find(int x) {
        if (parents.get(x) != x) return find(parents.get(x));
        return x;
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        int pxRank = ranks.get(px);
        int pyRank = ranks.get(py);
        if (px != py) {
            if (pxRank < pyRank) {
                parents.set(px, py);
                ranks.set(py, pyRank + pxRank);
            } else {
                parents.set(py, px);
                ranks.set(px, pyRank + pxRank);
            }
            return true;
        }
        return false;
    }
}
class Edge implements Comparable<Edge>{
    int from,to,cost;
    Edge(int from,int to,int cost){
        this.from=from;
        this.to=to;
        this.cost=cost;

    }
    public int compareTo(Edge other){
        return this.cost-other.cost;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Integer>edges=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.offer(new Edge(i,j,cost));
            }
        }
        DSU ds=new DSU(n);
        int cost=0;
        int connected=0;
        while(!edges.isEmpty() && connected!=n-1){
            Edge edge=edges.poll();
            if(ds.union(edge.to,edge.from)){
                cost+=edge.cost;
                connected++;
            }

        }
        return cost;
    }
}