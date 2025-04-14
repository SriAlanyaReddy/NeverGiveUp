class Solution {
    public int countQuadruplets(int[] a) {
        int ct=0;
       int n=a.length;
       for(int i=0;i<n-3;i++){
        for(int j=i+1;j<n-2;j++){
            for(int k=j+1;k<n-1;k++){
                for(int m=k+1;m<n;m++){
               if(a[i]+a[j]+a[k]==a[m]){
                ct++;
               }
                }
            }
        }
       }
       return ct;
    }
}