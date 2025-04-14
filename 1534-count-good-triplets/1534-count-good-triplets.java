class Solution {
    public int countGoodTriplets(int[] a, int m, int b, int c) {
       int ct=0;
       int n=a.length;
       for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            for(int k=j+1;k<n;k++){
                if(Math.abs(a[i]-a[j])<=m && Math.abs(a[j]-a[k])<=b && Math.abs(a[i]-a[k])<=c){
                    ct++;
                }
            }
        }
       }
       return ct;
    }
}