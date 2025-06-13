class Solution {
    public int arrayPairSum(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        int maxsum=Integer.MIN_VALUE;
        int i=0;
        while(i<n-3){
            int firstpair=Math.min(a[i],a[i+1]);
            int secondpair=Math.min(a[i+2],a[i+3]);
            int sum=firstpair+secondpair;
            maxsum=Math.max(maxsum,sum);
            i++;

        }
        return maxsum;
    }
}