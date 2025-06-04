class Solution {
    public int findMiddleIndex(int[] a) {
        int n=a.length;
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+a[i];
        }
        for(int i=0;i<n;i++){
            int ls=prefix[i];
            int rs=prefix[n]-prefix[i+1];
            if(ls==rs){
                return i;
            }
        }
        return -1;
    }
}