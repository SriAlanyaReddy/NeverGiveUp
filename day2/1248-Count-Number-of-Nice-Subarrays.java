class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        return findcount(a,k)-findcount(a,k-1);
    }
    public int findcount(int[] a,int k){
        if(k<0)return 0;
        int n=a.length;

        int countodd=0;
        int countsubarrays=0;
        int l=0;
        int r=0;
        while(r<n){
           if(a[r]%2!=0){
            countodd++;
           }
           while(countodd>k){
            if(a[l]%2!=0) countodd--;
            l++;
           }
         
           countsubarrays+=r-l+1;
           
           r++;
        }
        return countsubarrays;
    }
}