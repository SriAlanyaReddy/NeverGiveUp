class Solution {
    public int waysToSplitArray(int[] a) {
      
        int n=a.length;
       long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        int c=0;
        long ls=0;
        for(int i=0;i<n-1;i++){
            ls+=a[i];
        
            long rs=sum-ls;
            if(ls>=rs){
              c++;
            }
        }
        return c;
    }
}
   