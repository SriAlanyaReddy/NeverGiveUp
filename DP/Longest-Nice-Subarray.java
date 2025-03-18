class Solution {
    public int longestNiceSubarray(int[] a) {
        int l=0;
        int r=0;
        int n=a.length;
        int max=1;
        int currentsum=0;
        int xorsum=0;
        while(r<n){
            currentsum+=a[r];
            xorsum^=a[r];
            while(currentsum!=xorsum){
                currentsum-=a[l];
                xorsum^=a[l];
                l++;
            }
            max=Math.max(r-l+1,max);
            r++;
            
        }
        return max;
    }
}