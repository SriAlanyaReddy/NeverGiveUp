class Solution {
    public boolean isPossibleCapability(int []a,int k,int capability){
        int steals=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]<=capability){
                steals++;
                i++;
            }
            if(steals>=k) return true;
        }
        return false;
    }
    public int minCapability(int[] a, int k) {
        int n=a.length;
        int mincapability=Integer.MAX_VALUE;
        int maxcapability=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            mincapability=Math.min(mincapability,a[i]);
            maxcapability=Math.max(maxcapability,a[i]);
        }
        int low=mincapability;
        int high=maxcapability;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(isPossibleCapability(a,k,mid)){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}