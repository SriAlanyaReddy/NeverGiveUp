class Solution {
    public long countSubarrays(int[] a, int k) {
        int max=Integer.MIN_VALUE;
        int n=a.length;
        for(int i=0;i<n;i++){
            max=Math.max(a[i],max);
        }
        int r=0,count=0,l=0;
        long ans=0;
        while(r<n){
            if(max==a[r]){
                count++;
            }
            while(count>=k){
                ans+=r-l+1;
                if(a[l]==max){
                    count--;
                }
                l++;
            }
            r++;

        }
        return ans;
    }
}