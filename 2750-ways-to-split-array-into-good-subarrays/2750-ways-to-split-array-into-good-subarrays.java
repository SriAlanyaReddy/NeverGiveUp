class Solution {
    public int numberOfGoodSubarraySplits(int[] a) {
        //for eavery gap between 2 ones we calculate Between each pair of 1s, the number of ways to split is determined by the number of zeros between them plus one
        // This is because every position between the 1s gives us a new way to split.
        int n=a.length;
         int last_idx = -1;
        int cnt = 1;
        int mod = 1_000_000_007;
        for(int i=0;i<n;i++){
            if(last_idx!=-1 && a[i]==1){
                last_idx=i;
            }
            else if(last_idx==-1 && a[i]==1){
                cnt=cnt*(i-last_idx)%mod;
                last_idx=i;

            }
        }
       return cnt if last_idx != -1 else 0;
    }
}