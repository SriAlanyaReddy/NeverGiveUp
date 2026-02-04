class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] indegree=new int[n];
        int champion=-1;
        for(int i=0;i<n;i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
            
        }
        for(int i=0;i<n;i++){
           if(indegree[i]==0){
            if(champion==-1){
                champion=i;//which means it is the only chmapion
            }
            else{
                return -1;

            }
           }
        }
        return champion;
    }
}