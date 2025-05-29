class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n1=edges1.length,n2=edges2.length;
        List<List<Integer>>adj1=new ArrayList<>();
        List<List<Integer>>adj2=new ArrayList<>();
        int res[]=new int[n1+1];
        for(int i=0;i<n1+1;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<n2+1;i++){
            adj2.add(new ArrayList<>());
        }
        for(int[] edge:edges1){
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }
        for(int[] edge:edges2){
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n1;i++){
            res[i]=dfs(i,-1,adj1,k);
        }
        int maxsize=Integer.MIN_VALUE;
        for(int i=0;i<n2;i++){
            maxsize=Math.max(dfs(i,-1,adj2,k-1),maxsize);
        }
        for(int i=0;i<n1;i++){
            res[i]+=maxsize;
        }
        return res;
        
    }
    public  int dfs(int node,int parent,List<List<Integer>>adj,int k){
        if(k<0){
            return 0;
        }
        int c=1;
        for(int neighbour:adj.get(node)){
            if(neighbour==node){
                continue;
            }
            c+=dfs(neighbour,node,adj,k-1);
        }
        return c;
    }
}