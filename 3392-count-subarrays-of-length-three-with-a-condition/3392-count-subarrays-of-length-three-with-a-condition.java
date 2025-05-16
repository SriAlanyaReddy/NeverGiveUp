class Solution {
    public int countSubarrays(int[] a) {
        int n=a.length,c=0;
        for(int i=0;i<n-2;i++){
            int sum=a[i]+a[i+2],middle=a[i+1];
            if(2*sum==middle){
                c++;
            }
        }
        return c;
        
    }
}