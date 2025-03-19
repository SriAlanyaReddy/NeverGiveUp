class Solution {
    public int minOperations(int[] a) {
        int flipcount=0;
        int n=a.length;

        for(int i=2;i<n;i++){
            if(a[i-2]==0){
                flipcount++;
                a[i-2]=1-a[i-2];
                a[i-1]=1-a[i-1];
                a[i]=1-a[i];
            }
        }
        return a[n-2]==1 && a[n-1]==1?flipcount:-1;
    }
}