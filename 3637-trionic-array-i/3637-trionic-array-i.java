class Solution {
    public boolean isTrionic(int[] a) {
        int i=0,n=a.length;
        while(i+1<n && a[i]<a[i+1]){
            i++;
        }
        if(i==0) return false;
        while(i+1<n && a[i]>a[i+1]){
            i++;
        }
        if(i==n-1) return false;
       while(i+1<n && a[i]<a[i+1]){
            i++;
        }
        return i==n-1;
    }
}