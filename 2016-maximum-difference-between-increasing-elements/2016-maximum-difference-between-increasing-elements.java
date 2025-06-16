class Solution {
    public int maximumDifference(int[] a) {
        int n=a.length;
           int min = a[0];
        int maxdiff = -1;

        for(int i=1;i<n;i++){
            if(a[i]>min){
                maxdiff=Math.max(a[i]-min,maxdiff);

            }
            else{
                min=a[i];
            }

        }
        return maxdiff;
        
    }
}