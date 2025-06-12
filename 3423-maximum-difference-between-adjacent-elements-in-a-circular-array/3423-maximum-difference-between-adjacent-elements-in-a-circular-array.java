class Solution {
    public int maxAdjacentDistance(int[] a) {
        int n=a.length,max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            max=Math.max(Math.abs(a[i]-a[i-1]),max);


        }
        return Math.max(max,Math.abs(a[n-1]-a[0]));
    }
}