class Solution {
    static class Pair{
        int node;
       long cost;
        Pair(int node,long cost){
            this.node=node;//destination
            this.cost=cost;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int cost=edge[2];
            adj.get(from).add(new Pair(to,cost));
            adj.get(to).add(new Pair(from,2L*cost));
        }
        return (int)dijikshtra(adj,n);

        
    }
    public long dijikshtra(List<List<Pair>>adj,int n){
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair current=q.poll();
            int currentNode=current.node;
            long currentcost=current.cost;
            if(currentcost>dist[currentNode]) continue;
            for(Pair edge:adj.get(currentNode)){
                int nextnode=edge.node;
                long edgecost=edge.cost;
                long newcost=currentcost+edgecost;
                if(newcost<dist[nextnode]){
                    dist[nextnode]=newcost;
                    q.add(new Pair(nextnode,newcost));
                }

            }
        }
        return dist[n-1]==Long.MAX_VALUE?-1:dist[n-1];
    }
}