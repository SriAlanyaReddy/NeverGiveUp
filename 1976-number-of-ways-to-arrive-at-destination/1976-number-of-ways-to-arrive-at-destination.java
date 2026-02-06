class Solution {
    static class Pair{
        int node;
       long cost;
        Pair(int node,long cost){
            this.node=node;//destination
            this.cost=cost;
        }
    }
    public int countPaths(int n, int[][] roads) {
         List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:roads){
            int from=edge[0];
            int to=edge[1];
            int cost=edge[2];
            adj.get(from).add(new Pair(to,cost));
            adj.get(to).add(new Pair(from,cost));
        }
        return dijikshtra(adj,n);

        
    }

  
    
    public int dijikshtra(List<List<Pair>>adj,int n){
        long dist[]=new long[n];
          int MOD = 1_000_000_007;
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        long ways[]=new long[n];
        ways[0]=1;
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
                    ways[nextnode]=ways[currentNode];
                    q.add(new Pair(nextnode,newcost));
                }
                else if(newcost==dist[nextnode]){
                    ways[nextnode]=(ways[nextnode]+ways[currentNode])%MOD;
                }

            }
        }
        return (int)(ways[n-1]%MOD);
    }
}