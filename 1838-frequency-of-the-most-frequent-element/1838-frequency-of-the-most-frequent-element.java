class Solution {
    public int maxFrequency(int[] a, int k) {
        int len=1,l=0,r=0,n=a.length;
        long sum=0;
        Arrays.sort(a);
        while(r<n){
            sum+=a[r];
            while((long)(a[r])*(r-l+1)>sum+k){
                sum=sum-a[l];
                l++;

            }
            len=Math.max(r-l+1,len);
            r++;
        }
        return len;
        
    }
}