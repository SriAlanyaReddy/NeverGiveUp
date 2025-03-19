class Solution {
    public boolean canReach(int[] a, int start) {
        int n=a.length;
        boolean visited[]=new boolean[n];
        return isPossible(a,start,visited);
    }
    public boolean isPossible(int[] a,int start,boolean[] visited){
        int n=a.length;
        

        // Base cases
        if (start < 0 || start >= n || visited[start]) return false;
        if(a[start]==0){
            return true;
        }
        visited[start]=true;
        return isPossible(a,start-a[start],visited) || isPossible(a,start+a[start],visited);
    }
}