class Solution {
    public int maxSubArray(int[] a) {
        int maxn=Integer.MIN_VALUE;
        int sum=0,n=a.length;

        for(int i=0;i<n;i++){
            sum+=a[i];
            maxn=Math.max(sum,maxn);
            if(sum<0){
                sum=0;
            }

        }
        return maxn;
    }
}