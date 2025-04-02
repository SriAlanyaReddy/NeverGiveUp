class Solution {
    public long maximumTripletValue(int[] a) {
        int n=a.length;
          if (n < 3) return 0; 
        long res=0,maxdiff=0,maxvalue=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,maxdiff*a[i]);
       
           maxdiff=Math.max(maxdiff,maxvalue-a[i]);
              maxvalue=Math.max(maxvalue,a[i]);
           
        }
        return res;
    }
}