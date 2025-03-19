class Solution {
    public int jump(int[] a) {
        int n=a.length;
        int l=0;
        int r=0,jumps=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+a[i]);
            }
            l=r+1;
            r=farthest;
            jumps++;

        }
        return jumps;
        
    }
}